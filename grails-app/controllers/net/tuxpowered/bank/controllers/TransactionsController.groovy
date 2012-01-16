package net.tuxpowered.bank.controllers;

import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.validation.ObjectError;

import net.tuxpowered.bank.domain.TransactionLog;
import net.tuxpowered.bank.domain.User;

class TransactionsController {

	def transactionsService
	
    def index = { 
		redirect(action:'pay')
	}
	
	def registerPayment = {
		def result = [:]
		try{ 
			result = transactionsService.registerPayment(params)
		}
		catch (OptimisticLockingFailureException e) {
			result.message = "Error"
			result.errors = [new ObjectError('Data changed!')]
		}
		flash.message  = result.message
		if(result.errors)
			render(view: 'pay', model:[result: result, users: User.list()])
		else
			redirect(action: 'index', controller: 'transactionsHistory',selectedAccount: params.senderAccount)
	}
	
	def pay = {
		def users = User.list()
		[users: users]
	}
}

