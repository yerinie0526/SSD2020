<%@ include file="IncludeTop.jsp" %> 
<table class ="main"style="border:none;border-collapse:collapse;width:100%">
  <tr>
    <td style="text-align:left;vertical-align:top;width:100%">
      <table style="border:none;border-collapse:collapse;width:80%;">
        <tr>
          <td valign="top">                    
            <!-- SIDEBAR -->
            <table id="index">
              <tr>
                <td>
                <c:if test="${!empty userSession.userId}">
                <b><i><font size="3" color="GREEN">Welcome!</font> <font size="4" color="RED">${userSession.userId}</font></i></b>
                </c:if>&nbsp;
                </td>
              </tr>
              <tr><td>&nbsp;</td>
              </tr>
              <tr style="background-color: #bbdefb">
                <td>
                  <a href="<c:url value="/spetstore/category/fish"/>" style="font-family:cursive;">
                     <font size="4" color="BROWN">FISH</font></a>
                </td>
              </tr>
              <tr style="background-color: #bbdefb">
                <td>
                  <a href="<c:url value="/spetstore/category/dog"/>" style="font-family:cursive;">
                    <font size="4" color="BROWN">DOG</font></a>
                </td>
              </tr>
              <tr style="background-color: #bbdefb">
                <td>
                  <a href="<c:url value="/spetstore/category/rabbit"/>" style="font-family:cursive;">
                   <font size="4" color="BROWN">RABBIT</font></a>
                </td>
              </tr>
              <tr style="background-color: #bbdefb">
                <td>
                  <a href="<c:url value="/spetstore/category/cat"/>" style="font-family:cursive;">
                    <font size="4" color="BROWN">CAT</font></a>
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