<%@ include file="../../IncludeTop.jsp"%>
<h2>My Cart</h2>
<table style="border:none;border-collapse:collapse;width:100%">
<c:forEach var="ci" items="${cartList}">
	<tr>
		<td><a href="<c:url value='/spetstore/market/detail?itemId=${ci.itemId}'/>">${ci.name}</a></td>
	</tr>
	<tr>
		<td>
			[item pic]
		</td>
		<td>
			<table>
				<tr><td>${ci.itecid}</td></tr>
				<tr><td>${ci.istatus}</td></tr>
				<tr><td>${ci.price}</td></tr>
			</table>
		</td>
	</tr>
	<tr>
		<td>
			<input type="button"
		         value="remove from my cart"
		         onclick="location.href='<c:url value='/spetstore/user/myPage/cart?itemId=${ci.itemId}' />'" />
         </td>
	</tr>
</c:forEach>
</table>
<%@ include file="../../IncludeBottom.jsp"%>
