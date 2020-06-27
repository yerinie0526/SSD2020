<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="../IncludeTop.jsp" %>

<h2><c:out value="${itemmodel.name}"/></h2>
<ul>
	<li>Product Name : ${itemmodel.name} </li>
	<li>Pet Kind : ${itemmodel.cname}</li>
	<li>Item Kind: ${itemmodel.itemKind}</li>
	<li>Price : ${itemmodel.price}</li>
	<li>Description : ${itemmodel.description}</li> 
	<li>Item Status : ${itemmodel.istatus}</li>
</ul>

<p><a href="<c:url value='/spetstore/market/addCart?itemId=${itemmodel.itemId}' />">Add Cart</a></p>

<%@ include file="../IncludeBottom.jsp" %>