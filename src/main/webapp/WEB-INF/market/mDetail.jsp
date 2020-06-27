<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="../IncludeTop.jsp" %>

<h2>${ItemModel.name}</h2>
<ul>
	<li> 물품 번호 : ${ItemModel.itemId}</li>
	<li> 동물 종 : ${ItemModel.categoryId}</li>
	<li> 상품 종류 : ${ItemModel.ItemKind}</li>
	<li> 상세 설명 : ${ItemModel.description}</li>
	<li> 가격 : ${ItemModel.price}</li>
</ul>

<p><a href="<c:url value='/spetstore/market/addCart?itemId=${ItemModel.itemId}' />">장바구니</a></p>

<%@ include file="../IncludeBottom.jsp" %>