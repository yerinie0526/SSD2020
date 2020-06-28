<%@ include file="../IncludeTop.jsp" %>

<div align="center">
  <table id="item">
    <tr>
      <td bgcolor="#FFFFFF">
        <c:out value="DESCRIPTION: ${di.description}" escapeXml="false" /></td>
    </tr>
    <tr>
      <td width="100%" bgcolor="#CCCCCC"><b><c:out value="ITEMID: ${di.itemId}" /></b></td>
    </tr>
  
    <tr>
      <td><font size="3"><i><c:out value="NAME: ${di.name}" /></i></font></td>
    </tr>
   <tr>
      <td><font size="3"><i><c:out value="ITEMKIND: ${di.itemKind}" /></i></font></td>
    </tr>
    <tr>
      <td>ITEMPRICE: <fmt:formatNumber value="${di.price}" pattern="$#,##0.00" /></td>
    </tr>
    <tr>
      <td>
        <a href='<c:url value="/spetstore/spetitem/addCart.do">
          <c:param name="workingItemId" value="${di.itemId}"/></c:url>'>
          ADD CART</a>
      </td>
    </tr>
  </table>
</div>