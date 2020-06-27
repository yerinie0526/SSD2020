<%@ include file="../IncludeTop.jsp" %>

<div align="center">
  <form action='<c:url value="/spetstore/logincheck"/>' method="POST">
    <c:if test="${!empty signonForwardAction}">
      <input type="hidden" name="forwardAction"
        value='<c:url value="${signonForwardAction}"/>' />
    </c:if>
    <table>
      <tr>
        <td colspan="2">Please enter your username and password. <br />&nbsp;
        </td>
      </tr>
      <tr>
        <td>Username:</td>
<<<<<<< HEAD
        <td><input type="text" name="userId" size="20" value="" /></td>
=======
        <td><input type="text" name="username" size="20"  /></td>
>>>>>>> branch 'develop' of https://github.com/yerinie0526/SSD2020.git
      </tr>
      <tr>
        <td>Password:</td>
<<<<<<< HEAD
        <td><input type="password" name="password" size="20" value="" /></td>
=======
        <td><input type="password" name="password" size="20" /></td>
>>>>>>> branch 'develop' of https://github.com/yerinie0526/SSD2020.git
      </tr>
      <tr>
        <td>&nbsp;</td>
        <td><input type="submit" value="login"></td>
      </tr>
    </table>
  </form>
  <a href='<c:url value="/spetstore/user/newAccount.do"/>'> register now  </a>
</div>
<%@ include file="../IncludeBottom.jsp" %>