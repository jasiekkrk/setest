<div>Balance: ${balance.encodeAsHTML() }</div>
<div>
<table>
<tr>
<th>Date</th>
<th>From</th>
<th>To</th>
<th>Amount</th>
<th>Balance after</th>
</tr>
<thead>
</thead>
<tbody>
<g:each in="${result}" var="transactionItem">
<tr>
	<td><g:formatDate date="${transactionItem.transactionDate}" format="yyyy-MM-dd"></g:formatDate></td>
	<td>${transactionItem.senderName.encodeAsHTML()}</td>
	<td>${transactionItem.recipientName.encodeAsHTML()}</td>
	<td>${transactionItem.transactionAmount?.encodeAsHTML()}</td>
	<td>${transactionItem.amountAfter.encodeAsHTML()}</td>
</tr>
</g:each>
</tbody>
</table>
</div>