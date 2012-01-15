package net.tuxpowered.bank.domain

class TransactionLog {

	User user
	BigDecimal amountAfter
	Transaction transaction
	
	static belongsTo = User
	
	static mapping = {
	}
	
    static constraints = {
		user: nullable: false
    }
}
