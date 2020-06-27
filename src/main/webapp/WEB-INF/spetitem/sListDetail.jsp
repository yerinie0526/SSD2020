<%@ include file="../IncludeTop.jsp" %>

<div align="center">
  <table id="item">
    <tr>
      <td bgcolor="#FFFFFF">
        <c:out value="${product.description}" escapeXml="false" /></td>
    </tr>
    <tr>
      <td width="100%" bgcolor="#CCCCCC"><b><c:out value="${ItemModel.itemId}" /></b></td>
    </tr>
  
    <tr>
      <td><font size="3"><i><c:out value="${ItemModel.name}" /></i></font></td>
    </tr>
    <tr>
      <td>
      <c:if test="${item.quantity <= 0}">
        <font color="red" size="2"><i>Back ordered.</i></font>
      </c:if> 
      <c:if test="${item.quantity > 0}">
        <font size="2"><fmt:formatNumber value="${item.quantity}" /> in stock.</font>
      </c:if>
      </td>
    </tr>
    <tr>
      <td><fmt:formatNumber value="${ItemModel.price}" pattern="$#,##0.00" /></td>
    </tr>
    <tr>
      <td>
        <a href='<c:url value="/spetstore/spetitem/addCart.do">
          <c:param name="workingItemId" value="${ItemModel.itemId}"/></c:url>'>
          <img border="0" src="../images/button_add_to_cart.gif" alt="" /></a>
      </td>
    </tr>
  </table>
</div>