package net.tuxpowered.bank.services

import net.tuxpowered.bank.domain.Transaction;
import net.tuxpowered.bank.domain.TransactionLog;
import net.tuxpowered.bank.domain.User;
import grails.test.*

class TransactionsServiceTests extends GrailsUnitTestCase {
    protected void setUp() {
        super.setUp()
    }

    protected void tearDown() {
        super.tearDown()
    }

    void testIfRegisterPayment() {
		//act
		mockDomain(User, [
				new User(id: 1, email: "patsy@funnybank.com", name: 'Patsy', balance: 200.0 ), 
				new User(id: 2, email: "joe@funnybank.com", name: 'Joe', balance: 200.0 )
		])
		
		mockDomain Transaction
		mockDomain TransactionLog
		
		def service = new TransactionsService()
		service.metaClass.sendMail = {
			
		}
		//act
		def resultOK = service.registerPayment([senderAccount: 1, toAccount: 2, amount:'10.0'])
		def resultFail = service.registerPayment([senderAccount: 1, toAccount: 2, amount:'10111.0'])
		
		//arrange
		assert resultOK.errors.size == 0
		assert resultFail.errors.size == 1
		assert resultFail.errors[0].defaultMessage.equals('Amount too big')
    }
}
