package net.tuxpowered.bank.controllers

import net.tuxpowered.bank.domain.User;

class TransactionsController {

    def index = { 
		redirect(action:transactions)
	}
	
	def transactions = {
		
	}
	
	def registerPayment = {
		
	}
	
	def pay = {
		def users = User.list()
		[users: users]
	}
	
	
}
