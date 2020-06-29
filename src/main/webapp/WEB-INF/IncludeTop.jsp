<!-- index로 가는 버튼/카트/로그인 유무(로그인한 상태인 경우, 마이페이지 버튼 보임)/itemKind 선택/검색창 및 검색 버튼-->
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
  <title>SummerPetStore</title>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
  <meta http-equiv="Cache-Control" content="max-age=0">
  <meta http-equiv="Cache-Control" content="no-cache">
  <meta http-equiv="expires" content="0">
  <meta http-equiv="Expires" content="Tue, 01 Jan 1980 1:00:00 GMT">
  <meta http-equiv="Pragma" content="no-cache">
  <link rel="stylesheet" href="../style/petstore.css" type="text/css" />
</head>

<body bgcolor="white">
<table class="top">
	<tr>
		<td>
	    	<a href="<c:url value="/index"/>">
	        (go to home)</a>
	    </td>
	    
	    <td style="text-align:right">
	      <a href="<c:url value="/spetstore/user/myPage/cart.do"/>">
	        (cart)</a>
	      <c:if test="${empty userSession.userId}" >
	        <a href="<c:url value="/spetstore/user/signonForm.do"/>">
	          (login)</a>
	      </c:if>
	      <c:if test="${!empty userSession.userId}" >
	        <a href="<c:url value="/spetstore/user/signoff.do"/>">	<!-- controller에서 로그아웃 처리하기 -->
	          (logout)</a>
	        <a href="<c:url value="/spetstore/user/myPage.do"/>">
	         (myPage)</a>
	      </c:if>
	    </td>
	    
	    <td style="text-align:left">
	      <form action="<c:url value="/spetstore/spetitem/categoryView.do"/>" method="post">
	        <input type="text" name="keyword" size="14" />
	        <input type="submit" value="search">
	      </form>
	    </td>
	</tr>
</table>

<%@ include file="IncludeQuickHeader.jsp" %>
