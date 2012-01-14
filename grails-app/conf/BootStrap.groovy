import net.tuxpowered.bank.domain.User;

class BootStrap {

    def init = { servletContext ->
		def patsy = new User(email: "patsy@funnybank.com", name: 'Patsy', balance: 200.0 )
		def joe = new User(email: "joe@funnybank.com", name: 'Joe', balance: 200.0 )
		patsy.save(flush:true)
		joe.save(flush:true)
    }
    def destroy = {
    }
}
