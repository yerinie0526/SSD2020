<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="../IncludeTop.jsp" %>
<div align="center">
<p>${iData.name}</p>
<ul>
	<li>Product Name : ${iData.name} </li>
	<li>Pet Kind : ${iData.cname}</li>
	<li>Item Kind: ${iData.itemKind}</li>
	<li>Price : ${iData.price}</li>
	<li>Description : ${iData.description}</li> 
	<li>Item Status : ${iData.istatus}</li>
</ul>

<p><a href="<c:url value='/spetstore/market/addCart/${iData.itemId}' />">Add Cart</a></p>
</div>
<%@ include file="../IncludeBottom.jsp" %>