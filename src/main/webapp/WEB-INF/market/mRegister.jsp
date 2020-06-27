<%@ include file="../IncludeTop.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<form:form modelAttribute="marketForm" action="/spetstore/market/register">
<p>
	<form:label path="name">상품명 : </form:label>
	<form:input path="name" />
	<form:errors path="name" />
</p>
<p>
	<form:label path="categoryId">동물 종 : </form:label>
	<form:select path="categoryId">
		<option value="">--pet kind--</option>
		<form:options items="${categoryIds}"/>
	</form:select>
	<form:errors path="categoryId" />
</p>
<p>
	<form:label path="itemKind">상품 종류 : </form:label>
	<form:select path="itemKind">
		<option value="">--Item Kind--</option>
		<form:options items="${itemKinds}"/>
	</form:select>
	<form:errors path="itemKind" />
</p>
<p> <!-- 직거래/택배 -->
	<form:label path="pMethod">거래 방식 : </form:label>
	<form:radiobuttons items="${pMethods}" path="pMethod"/>
	<form:errors path="pMethod" />
</p>
<p>
	<form:label path="">설명 : </form:label>
	<form:textarea path="description" cols="20" row="3"/>
	<form:errors path="description" />
</p>
<input type="submit" value="등록하기" />
<input type="button" value="취소"/>
</form:form>

<%@ include file="../IncludeBottom.jsp" %>