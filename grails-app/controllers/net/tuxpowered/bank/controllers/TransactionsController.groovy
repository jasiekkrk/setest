package net.tuxpowered.bank.controllers

import net.tuxpowered.bank.domain.User;

class TransactionsController {

	def transactionsService
	
    def index = { 
		redirect(action:'transactions')
	}
	
	def transactions = {
		
	}
	
	def registerPayment = {
		transactionsService.registerPayment(params)
		flash.message = "Transaction was successful"
		redirect(action: 'transactions')
	}
	
	def pay = {
		def users = User.list()
		[users: users]
	}
	
	
}
