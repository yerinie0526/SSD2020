<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../IncludeTop.jsp" %>

<table style="border:none;border-collapse:collapse;width:100%">
	<tr>
      <td style="text-align:right">
      <input type="button"
         value="Register Market"
         onclick="location.href='<c:url value='/spetstore/market/mSearch/mRegister.do' />'" />
      </td>
   </tr>
</table>
<table style="border:none;border-collapse:collapse;width:100%">
<c:forEach var="mi" items="${mList}">
	<tr style="border:1px solid black;">
		<td>
			[item pic]
		</td>
		<td>
			<table>
			<tr><td><a href="<c:url value='/spetstore/market/detail?itemId=${mi.itemId}'/>">${mi.name}</a></td></tr>
				<tr><td>Item Number: ${mi.itemId}</td></tr>
				<tr><td>Status: ${mi.istatus}</td></tr>
				<tr><td>Price: ${mi.price}</td></tr>
			</table>
		</td>
	</tr>
</c:forEach>
</table>
<%@ include file="../IncludeBottom.jsp" %>