<%@ include file="../IncludeTop.jsp" %>

<form:form modelAttribute="auctionForm" action="aRegisterSuc">
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
	<form:input path="deadline" type="date"/>
	<form:errors path="dealine" />
</p>
<!-- <p>
	<form:label path="">거래 방식 : </form:label>
	<form:radiobuttons items="${pMethods}" path="pMethod"/>
	<form:errors path="pMethod" />
</p>-->
<p>
	<form:label path="description">Description : </form:label>
	<form:textarea path="description" cols="20" row="3"/>
	<form:errors path="description" />
</p>
<p>
	<form:label path="minPrice">Minimum Price� : </form:label>
	<form:input path="minPrice" />
	<form:errors path="minPrice" />
</p>
<input type="submit" value="Register" />
<input type="button" value="Register"/>
</form:form>

<%@ include file="../IncludeBottom.jsp" %>