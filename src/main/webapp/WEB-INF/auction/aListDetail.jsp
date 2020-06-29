<%@ include file="../IncludeTop.jsp" %>
<div align="center">
<p>${auctionModel.name}</p>
<ul>
	<li> D-Day ${auctionModel.dday}</li>
	<li> Deadline ${auctionModel.deadline}</li>
	<li> Auction Number: ${auctionModel.auctionId}</li>
	<li> Auction Name : ${auctionModel.name}</li>
	<li> Pet Kind� : ${auctionModel.cname}</li>
	
	<li> Current Max Price: ${auctionModel.curMaxPrice} </li>
	<li> User : ${auctionModel.firstId} </li>
	
	<li> Description� : ${auctionModel.description}</li>
	<li> Minimum Price : ${auctionModel.minPrice}</li>
	<li> Seller�� : ${auctionModel.sellerInfoId}</li>
	<li> Status : ${auctionModel.minPrice}</li>
	
	
</ul>
<p><a href="<c:url value='/spetstore/auction/priceregister' />">가격 제시/수정하기</a></p>
</div>
<%@ include file="../IncludeBottom.jsp" %>