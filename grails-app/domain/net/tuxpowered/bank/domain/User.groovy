package net.tuxpowered.bank.domain

class User {

	String name
	String email
	
	BigDecimal balance
	
	static hasMany = [transactions: TransactionLog]
	
    static constraints = {
		balance min: 0.0
		email email: true
		name nullable: false, blank: false
    }
}
