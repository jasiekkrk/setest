package net.tuxpowered.bank.controllers

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
		assert "transactions".equals(controller.redirectArgs.action)
    }
	
	void testIfRegisterPayment() {
		controller.registerPayment()
		assert "Transaction was successful".equals(controller.flash.message)
		assert "transactions".equals(controller.redirectArgs.action)
	}
}
