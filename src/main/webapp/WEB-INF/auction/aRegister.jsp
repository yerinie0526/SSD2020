<%@ include file="../IncludeTop.jsp" %>

<c:set var="targetUrl"><c:url value="/spetstore/auction/aSearch/aRegisterSuc.do" /></c:set>
<div align="center">
<form:form modelAttribute="auctionForm" action="${targetUrl}">
 <form:errors cssClass="error" /> <br><br>
<p>
	<form:label path="name">Title : </form:label>
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
	<form:label path="deadline">Deadline : </form:label>
	<form:input path="deadline" placeholder="yyyymmdd ex) 20200630"/>
	<form:errors path="deadline" cssClass="error"/>
</p>
<p>
	<form:label path="description">Description : </form:label>
	<form:textarea path="description" cols="20" row="3"/>
	<form:errors path="description" />
</p>
<p>
	<form:label path="minPrice">Minimum Price€ : </form:label>
	<form:input path="minPrice" />
	<form:errors path="minPrice" />
</p>
<input type="submit" value="Register" />
</form:form>
</div>
<%@ include file="../IncludeBottom.jsp" %>