<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../IncludeTop.jsp" %>

<table style="border:none;border-collapse:collapse;width:100%">
	<tr>
		<td>Search Item by condition</td>
	</tr>
	<tr>
		<td>
			<form action="<c:url value="/spetstore/market/mSearch/mSearch.do"/>">
		      	<select name="cname"> 
		      		<option value="">--Select pet kind--</option>
		      		<option value="1">dog</option>
		      		<option value="2">cat</option>
		      		<option value="3">fish</option>
		      	</select>
		      	<select name="itemKind"> <!-- itemKind ë³´ê¸° ìê°í´ë³´ê¸° -->
		      		<option value="">--Select itemkind--</option>
		      		<option value="1">bath product</option>
		      		<option value="2">feeding Item</option>
		      		<option value="3">care Item</option>
		      	</select>
		        <input type="text" name="keyword" size="14" />
		        <input src="../../images/search.gif" type="image"/>
		   </form>
		</td>
		<td>
			<select name="astatus"> 
		      	<option value="1" selected="selected">All</option>
		      	<option value="2">In progress</option>
		      	<option value="3">Expired</option>
		    </select>
		    <select name="order">
		      	<option value="1">popular</option>
		      	<option value="2" selected="selected">date</option>
		   </select>
		</td>
		<td>
			<a href="/spetstore/market/mSearch/mRegister.do">등록하기</a>
		</td>
	</tr>
</table>
<table style="border:none;border-collapse:collapse;width:100%">
<c:forEach var="mi" items="${mList}">
	<tr>
		<td><a href="<c:url value='/spetstore/market/detail?itemId=${mi.itemId}'/>">${ai.name}</a></td>
	</tr>
	<tr>
		<td>
			[item pic]
		</td>
		<td>
			<table>
				<tr><td>${mi.itemId}</td></tr>
				<tr><td>${mi.istatus}</td></tr>
				<tr><td>${mi.price}</td></tr>
			</table>
		</td>
	</tr>
</c:forEach>
</table>
<%@ include file="../IncludeBottom.jsp" %>