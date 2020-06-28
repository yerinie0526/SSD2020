<%@ include file="../IncludeTop.jsp" %>
<div align="center">
축하드립니다
You success to order products!
<table>
<tr>
	<td> Your orderId : ${oList.orderId}</td>
</tr>
<tr>
	<td> 
		<a href="<c:url value="/spetstore/user/order/detail?orderId=${oList.orderId}"/>">
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