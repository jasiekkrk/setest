<!DOCTYPE html>
<html>
    <head>
        <title><g:layoutTitle default="Grails" /></title>
        <link href="${resource(dir:'css',file:'main.css')}" media="screen" rel="stylesheet" type="text/css">
        <g:javascript library="jquery" />
        <g:javascript library="namespace"/>
        <g:layoutHead />
    </head>
    <body>
        <div id="spinner" class="spinner" style="display:none;">
            <img src="${resource(dir:'images',file:'spinner.gif')}" alt="${message(code:'spinner.alt',default:'Loading...')}" />
        </div>
            
        <div id="nav">
			      	<g:link controller="transactions" action="pay"><g:message code="nav.pay.label" default="Pay"></g:message> </g:link>
			      	| 
			      	<g:link controller="transactions" action="transactions"><g:message code="nav.transactions.label" default="Transactions"></g:message> </g:link>
        </div>
        <div id="pageBody">
        	<g:layoutBody/>
        </div>
    </body>
</html>