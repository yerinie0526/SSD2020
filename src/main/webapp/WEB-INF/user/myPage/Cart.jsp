<%@ include file="../../IncludeTop.jsp"%>
<h2>My Cart</h2>
<table style="border:none;border-collapse:collapse;width:100%">
<script>
function createOrder(){
    form.submit();
}
function comeBack(targetUri) {
   form.action = targetUri;
   form.submit();
}
</script>
<c:set var="orderTotalPrice" value="0"/>
<c:forEach var="ci" items="${cartList}">
	<tr>
		<td><a href="<c:url value='/spetstore/market/detail?itemId=${ci.itemId}'/>">${ci.iname}</a></td>
	</tr>
	<tr>
		<td>
			[item pic]
		</td>
		<td>
			<table>
				<tr><td>${ci.itemId}</td></tr>
				<tr><td>${ci.price}</td></tr>
			</table>
		</td>
	</tr>
	<tr>
		<td>Quantity : <input type="number" value="${ci.quantity}"/></td>
	</tr>
	<tr>
		<c:set var="subtotal" value="${ci.price * ci.quantity}"/>
		<td>SubTotal Price : ${ci.price * ci.quantity} </td>
		<c:set var="orderTotalPrice" value="${orderTotalPrice + subtotal}"/>
	</tr>
	<tr>
		<td>
			<input type="button"
		         value="remove from my cart"
		         onclick="location.href='<c:url value='/spetstore/user/myPage/cart?itemId=${ci.itemId}' />'" />
         </td>
	</tr>
</c:forEach>
<tr>
	<td>
		Total price : ${orderToatalPrice} won
		<h2><c:out value="#{subtotal}"/></h2>
	</td>
</tr>
</table>
<%@ include file="../../IncludeBottom.jsp"%>
