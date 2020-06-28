<%@ include file="../../IncludeTop.jsp"%>
 
<c:forEach var="mi" items="${mList}">
	<tr>
		<td><a href="<c:url value='/spetstore/market/detail?itemId=${mi.itemId}'/>">${mi.name}</a></td>
	</tr>
	<tr>
		<td>
			[item pic]
		</td>
		<td>
			<table>
				<tr><td>${mi.itemId}</td></tr>
				<tr><td>${mi.istatus}</td></tr>
				<tr><td>${mi.price}</td></tr>
			</table>
		</td>
	</tr>
</c:forEach>

<%@ include file="../../IncludeBottom.jsp"%>
