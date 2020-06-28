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
            
              <form:input path="username" />
              <B><form:errors path="username" cssClass="error" /></B>
         
            </td>
          </tr>
          <tr>
            <td>password:</td>
            <td>
              <form:password path="password" /> 
              <B><form:errors path="password" cssClass="error" /></B></td>
          </tr>
         
          <tr>
            <td>Email:</td>
            <td>
              <form:input path="email" /> 
              <B><form:errors path="email" cssClass="error" /></B></td>
          </tr>
          <tr>
            <td>Address:</td>
            <td>
              <form:input path="address" /> 
              <B><form:errors path="address" cssClass="error" /></B></td>
          </tr>
          <tr>
            <td>Phone:</td>
            <td>
              <form:input path="phone" /> 
              <B><form:errors path="phone" cssClass="error" /></B></td>
          </tr>
        </table> 
        

      </td>
    </tr>
  </table>
  <br />
  <table>
  <tr></tr>
  <tr>
  <td><a href="/spetstore/mypage/update">MODIFIED</a> </td>
  <td><a href="/spetstore/mypage/memberdelete">MEMBERSHIP WITHDRAWAL</a> </td>
  </tr>
  </table>
<a href="/spetstore/register">REGISTER</a> &nbsp;&nbsp;
</form:form>
<p></p>
  
</div>

