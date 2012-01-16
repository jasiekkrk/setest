package net.tuxpowered.bank.controllers

import net.tuxpowered.bank.domain.TransactionLog;
import net.tuxpowered.bank.domain.User;

class TransactionsHistoryController {

    def index = {
		def users = User.list()
		[users: users]
	}
	
	
	def showTransactions = {
		def user = User.get(params.selectedAccount)
		def result = TransactionLog.executeQuery("select new map(t.amountAfter as amountAfter, transaction.dateCreated as transactionDate,sender.name as senderName, recipient.name as recipientName, transaction.amount as transactionAmount) from TransactionLog t inner join t.user as user inner join t.transaction as transaction inner join transaction.sender as sender inner join transaction.recipient as recipient where t.user = :user",[user: user])
		def balance = user.balance
		render(template: 'transactionsLog', model: [result: result, balance: balance])
	}
	
}
