<%@ include file="../IncludeTop.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<form:form modelAttribute="marketForm" action="/spetstore/market/mSearch//mRegisterSuc.do" >
<p>
	<form:label path="name">Prouduct Name : </form:label>
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
<p> <!-- 직거래/택배 -->
	<form:label path="pMethod">Contributing Way : </form:label>
	<form:radiobuttons items="${pMethods}" path="pMethod"/>
	<form:errors path="pMethod" />
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

<%@ include file="../IncludeBottom.jsp" %>