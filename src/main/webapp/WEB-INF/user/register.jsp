
<%@ include file="../IncludeTop.jsp" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div align="center">
<form:form modelAttribute="user" method="post">
  <form:errors cssClass="error" /> <br><br>
  
  <table id="account">
    <tr>
      <td>
        <h3><font color="darkgreen">User Information</font></h3>
        <table class="n13">
          <tr>
            <td>User ID:</td>
            <td>
           
            <c:if test="${user.newAccount}">
              <form:input path="account.userId" />
              <B><form:errors path="account.userId" cssClass="error" /></B>
            </c:if> 
            <c:if test="${!user.newAccount}">
              <c:out value="${user.account.userId}" />
            </c:if>
            </td>
          </tr>
          <tr>
            <td>password:</td>
            <td>
              <form:password path="account.password" /> 
              <B><form:errors path="account.password" cssClass="error" /></B></td>
          </tr>
          <tr>
            <td>Name:</td>
            <td>
              <form:input path="account.username" /> 
              <B><form:errors path="account.username" cssClass="error" /></B></td>
          </tr>
          <tr>
            <td>Email:</td>
            <td>
              <form:input type = "email" path="account.email" /> 
              <B><form:errors path="account.email" cssClass="error" /></B></td>
          </tr>
          <tr>
            <td>Address:</td>
            <td>
              <form:input path="account.address" /> 
              <B><form:errors path="account.address" cssClass="error" /></B></td>
          </tr>
          <tr>
            <td>Phone:</td>
            <td>
              <form:input path="account.phone" /> 
              <B><form:errors path="account.phone" cssClass="error" /></B></td>
          </tr>
        </table> 
        

      </td>
    </tr>
  </table>
  <br />
<input type="submit" name="submit"
      value="Save Account Information" />
      <br/>
        <br/>
      
       <c:if test="${!user.newAccount}">
              <a href='<c:url value="/spetstore/delete"> 
            <c:param name="userId" value="${user.account.userId}"/></c:url>'onclick="if(!confirm('Are you sure you want to delete this ?')){return false;}" >

                          <c:out value="WITHDRAWAL" />
                          
 
            </a>
            </c:if> 
   </form:form>
<p></p>
  
</div>
