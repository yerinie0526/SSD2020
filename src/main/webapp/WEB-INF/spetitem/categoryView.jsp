<%@ include file="../IncludeTop.jsp" %>

<div align="center">
  <b><font size="4"><c:out value="Products for sale at Spet Store" /></font></b>
  
  <table class="n23">
    <tr bgcolor="#FFCCCC">
      <td><b>Item ID</b></td>
      <td><b>Category</b></td>
      <td><b>Name</b></td>
      <td><b>Price</b></td>
    </tr>
    <c:forEach var="sitem" items="${cdata}">
      <tr bgcolor="#FFFF88">
        <td><b> 
          <a href='<c:url value="/spetstore/spetitem/detail">
            <c:param name="itemId" value="${sitem.itemId}"/></c:url>'>
              <c:out value="${sitem.itemId}" />
          </a></b></td>
        <td><c:out value="${sitem.cname}" /></td>
        <td>
        
          <c:out value="${sitem.name}" />
        </td>
        <td><fmt:formatNumber value="${sitem.price}" pattern="#won" /></td>
      </c:forEach>
    </table>
    
    <HR>
    <b><font size="4"><c:out value="Products for sale at Market" /></font></b>
    <table>
    <tr bgcolor="#FFCCFF">
      <td><b>Item ID</b></td>
      <td><b>Category</b></td>
      <td><b>Name</b></td>
      <td><b>Price</b></td>
    </tr>    
    
	<c:forEach var="item" items="${mdata}">
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
  
     <HR>
    <b><font size="4"><c:out value="Products for Auction" /></font></b>
    <table>
    <tr bgcolor="#CCFF99">
      <td><b>Auction Number</b></td>
      <td><b>Name</b></td>
      <td><b>D-DAY</b></td>
      <td><b>Current Price</b></td>
    </tr>    
    
	<c:forEach var="a" items="${adata}">
		<tr bgcolor="#FFFF88">
        	<td><b> 
          		<a href='<c:url value="/spetstore/spetitem/detail">
           			 <c:param name="auctionId" value="${a.auctionId}"/></c:url>'>
              	<c:out value="${a.auctionId}" />
          		</a></b></td>
        	<td><c:out value="${a.name}" /></td>
        	<td>
          		<c:out value="${a.dday}" />
        	</td>
        <td><fmt:formatNumber value="${a.curMaxPrice}" pattern="#won" /></td>
    </c:forEach>
  </table>
</div>