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
			<b>Person:</b>  [ from Account.list() ] <---- dropdown
			<br/>
			<b>[ submit ]</b>
			------------------------------------------------------
			<div>Balance: [amount]</div>
			<div>some awesome table with transaction amounts</div>
        </div>
    </body>
</html>