<%@ include file="IncludeTop.jsp" %> 
<table style="border:none;border-collapse:collapse;width:100%">
  <tr>
    <td style="text-align:left;vertical-align:top;width:100%">
      <table style="border:none;border-collapse:collapse;width:80%">
        <tr>
          <td valign="top">                    
            <!-- SIDEBAR -->
            <table id="index">
              <tr>
                <td>
                <c:if test="${!empty userSession.account}">
			       <b><i><font size="4" color="RED">Welcome ${userSession.account.firstName}!</font></i></b>
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
                  <a href="<c:url value="/spetstore/category.do/rabbit"/>">
                   RABBIT</a>
                </td>
              </tr>
              <tr>
                <td>
                  <a href="<c:url value="/spetstore/category/fish"/>">
                    FISH</a>
                </td>
              </tr>
              
            </table>
          </td>
          <td style="text-align:center;background-color:white;height:300;width:100%">
            MAIN IMAGE
            <p>main contents</p>
          </td>
        </tr>
      </table>
    </td>
  </tr>
</table>
<!-- 주석추가 -->
<%-- <%@ include file="IncludeBanner.jsp" %> --%>

<%@ include file="IncludeBottom.jsp" %>
