package net.tuxpowered.bank.domain

class Transaction {

	Long id
	User sender
	User recipient
	String title
	BigDecimal amount
	Date dateCreated
	
    static constraints = {
		sender nullable: false
		recipient nullable: false
		title nullable: false, blank: false
		amount nullable: false, blank: false, min: 0.0
    }
	
	static mapping = {
		autoTimestamp true
	}
	
}
