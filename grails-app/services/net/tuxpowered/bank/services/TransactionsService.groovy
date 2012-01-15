package net.tuxpowered.bank.services

import net.tuxpowered.bank.domain.Transaction;
import net.tuxpowered.bank.domain.TransactionLog;
import net.tuxpowered.bank.domain.User;

class TransactionsService {

    static transactional = true

    def registerPayment(paramz) {
		def result= [errors: [], message: '']
			
		def from = User.get(paramz.senderAccount)
		def to = User.get(paramz.toAccount)
		
		result.errors = validate(from, to, paramz)
		if(!result.errors)
			result.errors = doPayment( from, to, paramz)
		
		if(!result.errors){
			sendMailToUser(from)
			sendMailToUser(to)
		}

		return result
		
    }
	
	
	private def validate(from, to, paramz){
		def errors = []
		if(!from || !to){
			errors << "Invalid users"
		}
		
		if(!paramz.amount || !paramz.amount.isBigDecimal())
			errors << "Invalid amount"
		else if(from.balance < paramz.amount.toBigDecimal()){
			errors << "Amount too big"
		}
		return errors
	}
	
	
	private def doPayment(from, to, paramz){
		def errors = []
		def amount = paramz.amount.toBigDecimal()
		from.balance -= amount
		from.validate()
		if(from.hasErrors())
			errors << from.errors
		
		to.balance += amount
		to.validate()
		if(to.hasErrors())
			errors << to.errors
		
		Transaction transaction = new Transaction(sender: from, recipient: to, title:'Some title', amount: amount)
		transaction.validate()
		if(transaction.hasErrors())
			errors << transaction.errors
		
		if(!errors)
		{
			transaction = transaction.save(flush: true)
			to.save(flush:true)
			from.save(flush:true)
			TransactionLog senderLogEntry  = new TransactionLog(user: to, amountAfter: to.balance, transaction: transaction)
			senderLogEntry.save(flush:true)  
			TransactionLog recipientLogEntry  = new TransactionLog(user: from, amountAfter: from.balance, transaction: transaction)
			recipientLogEntry.save(flush:true)
		}
		return errors?.flatten()		
	}
	
	private def sendMailToUser(to){
		sendMail {
			to "${to.email}"
			subject "New transaction"
			body 'Your transaction is completed'
		  }
	}
	
}
