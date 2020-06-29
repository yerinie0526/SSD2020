<%@ include file="../IncludeTop.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div align="center">
<p>Congratulation!! You success to register new auction in the Summerpetstore Auction!</p>
<p>view auction item detail:</p>
<ul>
	<li>Product Name : ${marketForm.name} </li>
	<li>Pet Kind : ${marketForm.cname}</li>
	<li>Item Kind: ${marketForm.itemKind}</li>
	<li>Price : ${marketForm.price}</li>
	<li>Description : ${marketForm.description}</li>
</ul>
<p><a href="<c:url value='/spetstore/market/aSearch.do' />">Go to Market List</a></p>

<%@ include file="../IncludeBottom.jsp" %>
</div>