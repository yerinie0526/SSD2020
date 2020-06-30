<%@ include file="../IncludeTop.jsp" %>

Current Price: ${curMaxPrice} by User: ${firstId}
<table>
<tr>
	<td>
	<c:set var="targetUrl"><c:url value="/spetstore/auction/bid/${curMaxPrice}/${auctionId}" /></c:set>
		<form:form modelAttribute="prForm" action="${targetUrl}">
			<form:label path="bidPrice"></form:label>
			<form:input path="bidPrice" />
		<input type="submit" value="bid" />
		</form:form> 
	</td>
</tr>
</table>

<%@ include file="../IncludeBottom.jsp" %>