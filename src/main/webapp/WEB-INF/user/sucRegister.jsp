<%@ include file="../IncludeTop.jsp" %>

<div align="center">
축하드립니다
${userModel.username}님의 회원가입이 완료되었습니다.
<table>
<tr>
	<td> <a href="<c:url value="/spetstore/user/signonForm.do"/>">
                     로그인 하기</a></td>
    <td> <a href="<c:url value="/index"/>">
                     홈으로 가기</a></td>
</table>
</div>
