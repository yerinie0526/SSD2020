<%@ include file="../IncludeTop.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="targetUrl"><c:url value="/spetstore/market/mSearch/mRegisterSuc.do" /></c:set>
<div align="center">
<form:form modelAttribute="marketForm" action="${targetUrl}" >
<p>
	<form:label path="name">Product Name : </form:label>
	<form:input path="name" />
	<form:errors path="name" />
</p>
<p>
	<form:label path="cname">Pet Kind : </form:label>
	<form:select path="cname">
		<option value="">--pet kind--</option>
		<form:options items="${categoryIds}"/>
	</form:select>
	<form:errors path="cname" />
</p>
<p>
	<form:label path="itemKind">Item Kind : </form:label>
	<form:select path="itemKind">
		<option value="">--Item Kind--</option>
		<form:options items="${itemKinds}"/>
	</form:select>
	<form:errors path="itemKind" />
</p>
<p>
	<form:label path="price">Price : </form:label>
	<form:input path="price" />
	<form:errors path="price" />
</p>
<p>
	<form:label path="">Description : </form:label>
	<form:textarea path="description" cols="20" row="3"/>
	<form:errors path="description" />
</p>
<input type="submit" value="register" />
<input type="button"
         value="cancel"
         onclick="location.href='<c:url value='/spetstore/market/mSearch.do' />'" />
</form:form>
</div>
<%@ include file="../IncludeBottom.jsp" %>