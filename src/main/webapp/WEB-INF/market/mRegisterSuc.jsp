<%@ include file="../IncludeTop.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<p>장터에 성공적으로 물품이 등록되었습니다!</p>
<p>접수 내용:</p>
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