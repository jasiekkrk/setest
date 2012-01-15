<html>
    <head>
        <title>Pay Some Person</title>
        <meta name="layout" content="main" />
    </head>
    <body>
		<div>
			<h2>Pay</h2>
			<g:if test="${result?.errors }">
			We cannot complete your request due to following errors:
				<div class="errors">
					<ul>
					<g:each in="${result.errors}" var="error">
						<li>${error.encodeAsHTML()}</li>	
					</g:each>
					</ul>
				</div>
			</g:if>
			<br/>
			<g:form action="registerPayment" controller="transactions">
				<b>From:</b>
				<g:select from="${users}" name="senderAccount" optionValue="${{it.name+' / avail: '+it.balance}}" optionKey="id" value="${params?.senderAccount}"></g:select>
				<br/>
				<b>To:</b>
				<g:select from="${users}" name="toAccount" optionValue="name" optionKey="id" value="${params?.toAccount}"></g:select>
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