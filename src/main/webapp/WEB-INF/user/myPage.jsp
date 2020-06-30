<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../IncludeTop.jsp" %>

<table style="border:none;border-collapse:collapse;width:100%">
<tr>
	<td> <a href="<c:url value="/spetstore/user/editAccount.do"/>">Edit My Info</a></td>
</tr>
<tr>
	<td>My Auction</td>
</tr>
<c:forEach var="ai" items="${aList}">
	<tr>
		<td><a href="<c:url value='/spetstore/auction/detail?itemId=${ai.auctionId}'/>">${ai.name}</a></td>
	</tr>
	<tr>
		<td>
			[item pic]
		</td>
		<td>
			<table>
				<tr><td>${ai.auctionId}</td></tr>
				<tr><td>${ai.astatus}</td></tr>
				<tr><td>${ai.minprice}</td></tr>
				<tr><td>${ai.curMaxPrice}</td></tr>
			</table>
		</td>
	</tr>
</c:forEach>
<tr>
	<td>My Group Purchases</td>
</tr>
<%-- <c:foreach var="gp" items="${gpList}">
	<tr>
		<td><a href="<c:url value='/spetstore/gp/detail?itemId=${gp.itemId}'/>">${gp.name}</a></td>
	</tr>
	<tr>
		<td>
			[item pic]
		</td>
		<td>
			<table>
				<tr><td>${gp.itemId}</td></tr>
				<tr><td>${gp.gpstatus}</td></tr>
				<tr><td>${gp.price}</td></tr>
				<tr><td>${gp.sale}</td></tr>
			</table>
		</td>
	</tr>
</c:foreach> --%>


<tr>
	<td>My Market</td><hr>
</tr>
<c:forEach var="mi" items="${mList}">
	<tr>
		<td><a href="<c:url value='/spetstore/market/detail?itemId=${mi.itemId}'/>">${ai.name}</a></td>
	</tr>
	<tr>
		<td>
			<input type="image" src="../../images/spet-logo2.gif" name="orderimg" />
		</td>
		<td>
			<table>
				<tr><td>${mi.itemId}</td></tr>
				<tr><td>${mi.istatus}</td></tr>
				<tr><td>${mi.price}</td></tr>
				<tr><td>${error}</td></tr>
				<tr><td><p><a href="<c:url value='/spetstore/market/delete/${mi.itemId}' />" onclick="if(!confirm('Are you sure you want to delete this item?\n If someone puts an item in the shopping cart, it cannot be deleted')){return false;}">Delete Item</a></p></td></tr>
			</table>
		</td>
	</tr>
</c:forEach>
<tr>
 <td><b><a href='<c:url value="/spetstore/listOrders.do"/>'>My Orders</a></b></td>
 </tr>
</table>

<%@ include file="../IncludeBottom.jsp" %>