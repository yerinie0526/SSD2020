<%@ include file="../IncludeTop.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div align="center">
<p>Congratulation!! You success to register new auction in the Summerpetstore Auction!</p>
<p>view auction item detail:</p>
<ul>
	<li>Product Name : ${auctionForm.name} </li>
	<li>Pet Kind : ${auctionForm.cname}</li>
	<li>Price : ${auctionForm.minPrice}</li>
	<li>Expire Date: ${auctionForm.deadline}</li>
	<li>Description : ${auctionForm.description}</li>
</ul>
<p><a href="<c:url value='/spetstore/auction/aSearch.do' />">Go to Market List</a></p>

<%@ include file="../IncludeBottom.jsp" %>
</div>