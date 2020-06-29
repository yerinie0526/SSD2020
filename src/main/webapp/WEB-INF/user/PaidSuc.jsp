<%@ include file="../IncludeTop.jsp" %>
<div align="center">
<h2>You success to order products!</h2>
<table>
<tr>
	<td> Your orderId : ${oList.orderId}</td>
</tr>
<tr>
	<td> 
		<a href="<c:url value="/spetstore/order/detail?itemId=${oList.itemId}"/>">
          show order detail</a>
   </td>
</tr>
<tr>
    <td> 
    	<a href="<c:url value="/index"/>"> go to home</a>
    </td>
</table>
</div>
<%@ include file="../IncludeBottom.jsp" %>