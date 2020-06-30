<%@ include file="../IncludeTop.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<table style="border:none;border-collapse:collapse;width:100%">
	<tr>
      <td style="text-align:right">
      <input type="button"
         value="Register Auction"
         onclick="location.href='<c:url value='/spetstore/auction/aregister' />'" />
      </td>
   </tr>
</table>
<table style="border:none;border-collapse:collapse;width:100%">
<c:forEach var="ai" items="${aList}">
   <tr>
      <td>
         [item pic]
      </td>
      <td>
         <table>
         <tr><td><td>Auction Name: &nbsp;&nbsp;<a href="<c:url value='/spetstore/auction/detail?auctionId=${ai.auctionId}'/>">${ai.name}</a></td></tr>
            <tr><td>Auction Number:&nbsp;&nbsp;&nbsp;&nbsp;${ai.auctionId}</td></tr>
            <tr><td>Status:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${ai.astatus}</td></tr>
            <tr><td>Minimum Price:&nbsp;&nbsp;&nbsp;&nbsp;${ai.minprice}</td></tr>
            <tr><td>Current Price:&nbsp;&nbsp;&nbsp;&nbsp;${ai.curMaxPrice}</td></tr>
         </table>
      </td>
      <td>
        D-${ai.dday}
      </td>
   </tr>
</c:forEach>
</table>
<%@ include file="../IncludeBottom.jsp" %>