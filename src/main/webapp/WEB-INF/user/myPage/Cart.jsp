<%@ include file="../../IncludeTop.jsp"%>
<div align="center">
<h2>My Cart</h2>
<c:set var="orderTotalPrice" value="0"/>
<c:forEach var="ci" items="${cartList}">
<table style="border:none;border-collapse:collapse;width:100%">
<form id = "updateQuantity" action='<c:url value='/spetstore/user/myPage/cart/updatequantity?itemId=${ci.itemId}' />' method="post">
	<tr>
		<td><a href="<c:url value='/spetstore/market/detail?itemId=${ci.itemId}'/>">${ci.iname}</a></td>
	</tr>
	<tr>
		<td>
			<input type="image" src="../../../images/spet-logo2.gif" name="orderimg" />
		</td>
		<td>
			<table>
				<tr><td>Item Number:${ci.itemId}</td></tr>
				<tr><td>${ci.iname}</td></tr>
				<tr><td>${ci.price}Won</td></tr>
			</table>
		</td>
	</tr>
	<tr>
		<td>Quantity : <input type="number" name = "newQuantity" value="${ci.quantity}"/></td>
		<td>
			<table>
				<tr>
					<td><input type="submit" value="update" /></td>
				</tr>
				<tr>
					<td><input type="button"
				         value="Remove"
				         onclick="location.href='<c:url value='/spetstore/user/myPage/cart/remove?itemId=${ci.itemId}' />'" />
         			</td>
				</tr>
			</table>
		</td>
		<c:set var="orderTotalPrice" value="${orderTotalPrice + ci.quantity * ci.price}"/>
	</tr>
</form>
</table>
<hr/>
</c:forEach>
<hr/>
<table>
<tr>
	<td>
		Total price : <c:out value="${orderTotalPrice}"/> won
	</td>
</tr>
<tr>
	<td><input type="button"
         value="submit"
         onclick="location.href='<c:url value='/spetstore/user/order/PaidForm.do?totalPrice=${orderTotalPrice}' />'" /></td>
</tr>
</table>
</div>
<%@ include file="../../IncludeBottom.jsp"%>
