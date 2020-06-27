<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="../IncludeTop.jsp" %>

<h2>${ItemModel.name}</h2>
<ul>
	<li>Product Name : ${ItemModel.name} </li>
	<li>Pet Kind : ${ItemModel.cname}</li>
	<li>Item Kind: ${ItemModel.itemKind}</li>
	<li>Price : ${ItemModel.price}</li>
	<li>Contributing Way: ${ItemModel.pMethod}</li>
	<li>Description : ${ItemModel.description}</li> 
	<li>Item Status : ${ItemModel.istatus}</li>
</ul>

<p><a href="<c:url value='/spetstore/market/addCart?itemId=${ItemModel.itemId}' />">Add Cart</a></p>

<%@ include file="../IncludeBottom.jsp" %>