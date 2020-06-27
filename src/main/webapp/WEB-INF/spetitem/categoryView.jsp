<%@ include file="../IncludeTop.jsp" %>

<div align="center">
  <b><font size="4"><c:out value="판매상품" /></font></b>
  <table class="n23">
    <tr bgcolor="#CCCCCC">
      <td><b>Item ID</b></td>
      <td><b>Product ID</b></td>
      <td><b>Name</b></td>
      <td><b>Price</b></td>
    </tr>
    <c:forEach var="item" items="${ItemModel.pageList}">
      <tr bgcolor="#FFFF88">
        <td><b> 
          <a href='<c:url value="/shop/viewItem.do">
            <c:param name="itemId" value="${item.itemId}"/></c:url>'>
              <c:out value="${item.itemId}" />
          </a></b></td>
        <td><c:out value="${item.productId}" /></td>
        <td>
          <c:out value="${item.attribute1}" /> 
          <c:out value="${item.attribute2}" /> 
          <c:out value="${item.attribute3}" /> 
          <c:out value="${item.attribute4}" /> 
          <c:out value="${item.attribute5}" /> 
          <c:out value="${product.name}" />
        </td>
        <td><fmt:formatNumber value="${item.listPrice}" pattern="$#,##0.00" /></td>
        <td>
          <a href='<c:url value="/shop/addItemToCart.do">
            <c:param name="workingItemId" value="${item.itemId}"/></c:url>'>
              <img border="0" src="../images/button_add_to_cart.gif" alt="" />
          </a></td>
      </tr>
    </c:forEach>
    <tr>
      <td>
        <c:if test="${!itemList.firstPage}">
          <a href="?page=previous"><font color="white"><B>&lt;&lt; Prev</B></font></a>
        </c:if> 
        <c:if test="${!itemList.lastPage}">
          <a href="?page=next"><font color="white"><B>Next &gt;&gt;</B></font></a>
        </c:if>
      </td>
    </tr>
  </table>
</div>