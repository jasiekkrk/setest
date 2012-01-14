<html>
    <head>
        <title>Pay Some Person</title>
        <meta name="layout" content="main" />
    </head>
    <body>
		<div>
			<h2>Pay</h2>
			<div class="errors">
				[ errors go here ]
			</div>
			<br/>
			<g:form action="registerPayment" controller="transactions">
				<b>From:</b>
				<g:select from="${users}" name="senderAccount" optionValue="${{it.name+' / avail: '+it.balance}}" optionKey="id"></g:select>
				<br/>
				<b>To:</b>
				<g:select from="${users}" name="toAccount" optionValue="name" optionKey="id"></g:select>
				<br/>
				<b>Amount:</b>
				<g:textField name="amount"></g:textField>  
				<br/>
				<b>
				<g:actionSubmit value="Submit" action="registerPayment"></g:actionSubmit>
				</b>
			</g:form>
        </div>
    </body>
</html>