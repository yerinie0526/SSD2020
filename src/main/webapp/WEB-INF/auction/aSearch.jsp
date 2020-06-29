<%@ include file="../IncludeTop.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<table style="border:none;border-collapse:collapse;width:100%">
   <tr>
      <td>Search Item by condition</td>
   </tr>
   <tr>
      <td>
         <form action="<c:url value="/spetstore/auction/aSearch/aSearch.do"/>">
               <select name="cname"> 
                  <option value="">--Select pet kind--</option>
                  <option value="dog">dog</option>
                  <option value="cat">cat</option>
                  <option value="fish">fish</option>
               </select>
               <select name="itemKind"> <!-- itemKind ë³´ê¸° ì  ê° í ´ë³´ê¸° -->
                  <option value="">--Select item kind--</option>
                  <option value="bath">bath product</option>
                  <option value="feed">feeding Item</option>
                  <option value="care">care Item</option>
                  <option value="home">home Item</option>
                  <option value="else">else</option>
               </select>
              <input type="text" name="keyword" size="14" />
              <input type="submit" value="search">
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
         <a href="<c:url value='/spetstore/auction/aregister'/>"> Register Auction</a>
      </td>
   </tr>
</table>
<table style="border:none;border-collapse:collapse;width:100%">
<c:forEach var="ai" items="${aList}">
   <tr>
      <td><a href="<c:url value='/spetstore/auction/detail?auctionId=${ai.auctionId}'/>">${ai.name}</a></td>
   </tr>
   <tr>
      <td>
         [item pic]
      </td>
      <td>
         <table>
            <tr><td>${ai.actionId}</td></tr>
            <tr><td>${ai.astatus}</td></tr>
            <tr><td>${ai.minPrice}</td></tr>
            <tr><td>${ai.curMaxPrice}</td></tr>
         </table>
      </td>
      <td>
         ${ai.deadline}
      </td>
   </tr>
</c:forEach>
</table>
<%@ include file="../IncludeBottom.jsp" %>