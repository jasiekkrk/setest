package net.tuxpowered.bank.controllers

import net.tuxpowered.bank.domain.User;

class TransactionsController {

	def transactionsService
	
    def index = { 
		redirect(action:'transactions')
	}
	
	def transactions = {
		def users = User.list()
		[users: users]
	}
	
	def registerPayment = {
		def result = transactionsService.registerPayment(params)
		flash.message  = result.message
		if(result.errors)
			render(view: 'pay', model:[result: result, users: User.list()])
		else
			redirect(action: 'transactions', selectedAccount: params.senderAccount)
	}
	
	def pay = {
		def users = User.list()
		[users: users]
	}
	
	
}
