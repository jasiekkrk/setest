package net.tuxpowered.bank.domain

class TransactionLog {

	User user
	BigDecimal amountAfter
	Transaction transaction
	
	static belongsTo = User
	
	static fetchMode = [transaction:"join"]
	
	static mapping = {
	}
	
    static constraints = {
		user: nullable: false
    }
}
