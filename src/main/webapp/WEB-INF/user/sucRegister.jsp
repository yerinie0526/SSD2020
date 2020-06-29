<%@ include file="../IncludeTop.jsp" %>

<div align="center">
Congratulations!<br>
Welcome, ${user.account.username}<br>
Membership success<br>
<table>
<tr>
	<td> <a href="<c:url value="/spetstore/user/signonForm.do"/>">
                LOGIN</a></td>
    <td> <a href="<c:url value="/index"/>">
                    HOME</a></td>
</table>
</div>
