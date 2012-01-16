<html>
    <head>
        <title>See transactions</title>
        <meta name="layout" content="main" />
        <g:javascript library="views/transactions"/>
    </head>
    <body>
		<div>
			<h2>Transactions</h2>
			<g:if test="${flash.message}">
				${flash.message.encodeAsHTML()}
			</g:if>
			<div class="errors">
			
			</div>
			<div>
			<form id="account_selector_form">
				<b>Person:</b>  <g:select id="selectedAccount" from="${users}" name="selectedAccount" optionValue="${{it.name+' / avail: '+it.balance}}" optionKey="id" value="${params?.selectedAccount}"></g:select>
				<br/>
			</form>
			<b><input type="button" id="show_transactions" value="Show"/></b>
			</div>
			<div id="transaction_log_placeholder">
			</div>
        </div>
        <script type="text/javascript">
        	net.tuxpowered.funbank.views.Transactions.config.showTransactionsLink = "${createLink(action:'showTransactions', controller: 'transactionsHistory')}";
        </script>
    </body>
</html>