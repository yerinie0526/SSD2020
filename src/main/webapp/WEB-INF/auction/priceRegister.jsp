<%@ include file="../IncludeTop.jsp" %>

<p>${apriceregist.name}</p>
<table>
<tr>
	<b><font size="4"><c:out value="Current Price: ${curMaxPrice}     by ${firstId}" /></font></b>
	<td>
	<c:set var="targetUrl"><c:url value="/spetstore/auction/bid/${curMaxPrice}/${auctionId}" /></c:set>
		<form:form modelAttribute="prForm" action="${targetUrl}">
			<form:label path="bidPrice"></form:label>
			<form:input path="bidPrice" />
			<form:errors path="bidPrice" />
		<input type="submit" value="Bid" />
		</form:form> 
	</td>
</tr>
</table>

<%@ include file="../IncludeBottom.jsp" %>