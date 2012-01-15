<html>
    <head>
        <title>See transactions</title>
        <meta name="layout" content="main" />
    </head>
    <body>
		<div>
			<h2>Transactions</h2>
			<g:if test="${flash.message}">
				${flash.message.encodeAsHTML()}
			</g:if>
			<div class="errors">
			[ errors go here ]
			</div>
			<g:form action="transactions">
			<b>Person:</b>  <g:select from="${users}" name="selectedAccount" optionValue="${{it.name+' / avail: '+it.balance}}" optionKey="id" value="${params?.selectedAccount}"></g:select>
			<br/>
			<b><g:actionSubmit value="Select"></g:actionSubmit> </b>
			</g:form>
			------------------------------------------------------
			<div>Balance: [amount]</div>
			<div>some awesome table with transaction amounts</div>
        </div>
    </body>
</html>