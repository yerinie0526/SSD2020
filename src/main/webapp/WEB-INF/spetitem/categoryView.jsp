<%@ include file="../IncludeTop.jsp" %>

<div align="center">
  <b><font size="4"><c:out value="Products for sale" /></font></b>
  <table class="n23">
    <tr bgcolor="#CCCCCC">
      <td><b>Item ID</b></td>
      <td><b>Category</b></td>
      <td><b>Name</b></td>
      <td><b>Price</b></td>
    </tr>
    <c:forEach var="item" items="${cdata}">
      <tr bgcolor="#FFFF88">
        <td><b> 
          <a href='<c:url value="/spetstore/spetitem/detail">
            <c:param name="itemId" value="${item.itemId}"/></c:url>'>
              <c:out value="${item.itemId}" />
          </a></b></td>
        <td><c:out value="${item.cname}" /></td>
        <td>
        
          <c:out value="${item.name}" />
        </td>
        <td><fmt:formatNumber value="${item.price}" pattern="#won" /></td>
        
    </c:forEach>
 
  </table>
</div>