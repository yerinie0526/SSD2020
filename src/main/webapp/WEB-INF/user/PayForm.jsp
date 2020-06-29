<%@ include file="../IncludeTop.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="targetUrl"><c:url value="/spetstore/user/order/PaidSuc.do" /></c:set>
<div align="center">
<form:form modelAttribute="orderForm" action="${targetUrl}" >
  <form:errors cssClass="error" /> <br><br>
  
  <table class="n13">
    <tr>
      <td colspan="2">
        <font color="green" size="4"><b>Payment Details</b></font></td>
    </tr>
    <tr>
      <td>Card Type:</td>
      <td>
      	<form:select path="cardCompany">
			<option value="">--Card Type--</option>
			<form:options items="${creditCardTypes}"/>
		</form:select>
      </td>
    </tr>
    <tr>
      <td>Card Number:</td>
      <td><form:input path="cardNum" /> 
        <form:errors path="cardNum" /></td>
    </tr>
    <tr>
      <td>Expiry Date (MM/YYYY):</td>
      <td><form:input path="cardMonth" /> 
        <form:input path="cardYear" /> </td>
    </tr>
    <tr>
      <td>CVC Number:</td>
      <td><form:input path="cardCVC" /></td>
    </tr>
    <tr>
      <td>Zip Code:</td>
      <td><form:input path="zip" /></td>
    </tr>
    <tr>
      <td colspan="2">
        <font color="green" size="4"><b>Billing Address</b></font></td>
    </tr>
    <tr>
      <td>Name:</td>
      <td><form:input path="name" /> 
        <form:errors path="name" /></td>
    </tr>
    <tr>
      <td>Address:</td>
      <td><form:input path="address" />
        <form:errors path="address" /></td>
    </tr>
    <tr>
      <td>Phone Number:</td>
      <td><form:input path="phone" />
        <form:errors path="phone" /></td>
    </tr>
    <tr>
    	<td><input type="submit" value="ok"></td>
    </tr>
  </table>
</form:form>
</div>
<%@ include file="../IncludeBottom.jsp" %>