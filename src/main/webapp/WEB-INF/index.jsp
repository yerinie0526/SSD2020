<%@ include file="IncludeTop.jsp" %> 
<table class ="main"style="border:none;border-collapse:collapse;width:100%">
  <tr>
    <td style="text-align:left;vertical-align:top;width:100%">
      <table style="border:none;border-collapse:collapse;width:80%">
        <tr>
          <td valign="top">                    
            <!-- SIDEBAR -->
            <table id="index">
              <tr>
                <td>
                <c:if test="${!empty userSession.userId}">
			       <b><i><font size="4" color="RED">Welcome!</font></i></b>
                </c:if>&nbsp;
                </td>
              </tr>
              <tr>
                <td>
                  <a href="<c:url value="/spetstore/category/fish"/>">
                     FISH</a>
                </td>
              </tr>
              <tr>
                <td>
                  <a href="<c:url value="/spetstore/category/dog"/>">
                    DOG</a>
                </td>
              </tr>
              <tr>
                <td>
                  <a href="<c:url value="/spetstore/category/rabbit"/>">
                   RABBIT</a>
                </td>
              </tr>
              <tr>
                <td>
                  <a href="<c:url value="/spetstore/category/cat"/>">
                    CAT</a>
                </td>
              </tr>
              </table>
        
          </td>
          <td style="text-align:center;background-color:white;height:300;width:100%">
            <td id = "spet"> <img border="0" src="images/mainpic.PNG" width = "800" height="800"style="float:right"/></td>
          </td>
         
        </tr>
      </table>
    </td>
  </tr>
</table>
<!-- 주석추가 -->
<%-- <%@ include file="IncludeBanner.jsp" %> --%>

<%@ include file="IncludeBottom.jsp" %>
