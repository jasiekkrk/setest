/**
 * 
 */
namespace('net.tuxpowered.funbank.views.Transactions');

net.tuxpowered.funbank.views.Transactions = {
	config: {},
	bindEvents: function(){
		$('#show_transactions').on('click', function(){
			var config = net.tuxpowered.funbank.views.Transactions.config;
			$('#transaction_log_placeholder').load(config.showTransactionsLink, $('#account_selector_form').serialize());
		});
	},
	init: function(){
		net.tuxpowered.funbank.views.Transactions.bindEvents();
	}
};


$(document).ready(function(){
	net.tuxpowered.funbank.views.Transactions.init();
});