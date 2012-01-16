package net.tuxpowered.bank.controllers

import net.tuxpowered.bank.services.TransactionsService;
import grails.test.*

class TransactionsControllerTests extends ControllerUnitTestCase {
    protected void setUp() {
        super.setUp()
    }

    protected void tearDown() {
        super.tearDown()
    }

	void testIfDoRedirect() {
		controller.index()
		assert "pay".equals(controller.redirectArgs.action)
    }
	
	void testIfRegisterPayment() {
		//arrange
		def transactionsServiceMock = mockFor(TransactionsService)
		transactionsServiceMock.demand.registerPayment{ paramz ->
			return [errors: [], message: 'Transaction was successful']
		}
		controller.transactionsService = transactionsServiceMock.createMock()
		//act
		controller.registerPayment()
		
		//assert
		assert "Transaction was successful".equals(controller.flash.message)
		assert "index".equals(controller.redirectArgs.action)
		assert "transactionsHistory".equals(controller.redirectArgs.controller)
	}
}
