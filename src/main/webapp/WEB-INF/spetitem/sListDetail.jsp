<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="../IncludeTop.jsp" %>

<p>${di.name}</p>
<ul>
	<li>Product Name : ${di.name} </li>
	<li>Pet Kind : ${di.cname}</li>
	<li>Item Kind: ${di.itemKind}</li>
	<li>Price : ${di.price}</li>
	<li>Description : ${di.description}</li> 
	<li>Item Status : ${di.istatus}</li>
</ul>

 <a href='<c:url value="/spetstore/spetitem/addCart.do">
          <c:param name="additemId" value="${di.itemId}"/></c:url>'>
          ADD CART</a>