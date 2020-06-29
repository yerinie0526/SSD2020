<%@ include file="../../IncludeTop.jsp"%>
<h2>My Cart</h2>
<table style="border:none;border-collapse:collapse;width:100%">
<c:set var="orderTotalPrice" value="0"/>
<c:forEach var="ci" items="${cartList}">
<form action='<c:url value='/spetstore/user/myPage/cart/updatequantity' />' method="post">
	<tr>
		<td><a href="<c:url value='/spetstore/market/detail?itemId=${ci.itemId}'/>">${ci.iname}</a></td>
	</tr>
	<tr>
		<td>
			<input type="image" src="../../../images/spet-logo2.gif" name="orderimg" />
		</td>
		<td>
			<table>
				<tr><td>${ci.itemId}</td></tr>
				<tr><td>${ci.price}</td></tr>
			</table>
		</td>
	</tr>
	<tr>
		<td>Quantity : <input type="number" name= "${ci.itemId}" value="${ci.quantity}"/></td>
		<td>
			<input type="submit" value="update" />
		</td>
		<c:set var="orderTotalPrice" value="${orderTotalPrice + ci.quantity * ci.price}"/>
	</tr>
</form>
</c:forEach>	
<tr>
	<td>
		Total price : <c:out value="${orderTotalPrice}"/> won
	</td>
</tr>
<tr>

</tr>
</table>
<%@ include file="../../IncludeBottom.jsp"%>
