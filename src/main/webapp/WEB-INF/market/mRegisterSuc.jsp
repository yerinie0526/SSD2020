<%@ include file="../IncludeTop.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<p>Congratulation!! You success to register new item in the Summerpetstore Market!</p>
<p>view market item detail:</p>
<ul>
	<li>Product Name : ${marketForm.name} </li>
	<li>Pet Kind : ${marketForm.cname}</li>
	<li>Item Kind: ${marketForm.itemKind}</li>
	<li>Price : ${marketForm.price}</li>
	<li>Contributing Way: ${marketForm.pMethod}</li>
	<li>Description : ${marketForm.description}</li>
</ul>
<p><a href="<c:url value='/spetstore/market/mSearch.do' />">Go to Market List</a></p>

<%@ include file="../IncludeBottom.jsp" %>