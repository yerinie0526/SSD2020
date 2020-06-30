<%@ include file="../IncludeTop.jsp" %>

<p>${apriceregist.name}</p>
<table>
<tr>
	<b><font size="4"><c:out value="Current Price: ${auctionJPModel.curMaxPrice}     by ${prForm.firstId}" /></font></b>
	<td>
	<%-- <c:set var="targetUrl"><c:url value="/spetstore/auction/bid/${curMaxPrice}/${auctionId}" /></c:set> --%>
	<c:set var="targetUrl"><c:url value="/spetstore/auction/aSearch/aPriceRegisterSuc.do" /></c:set>
		<form:form modelAttribute="auctionJPModel" action="${targetUrl}">
			<form:label path="offerPrice"></form:label>
			<form:input path="offerPrice" />
		<input type="submit" value="bid" />
		</form:form> 
	</td>
</tr>
</table>

<%@ include file="../IncludeBottom.jsp" %>