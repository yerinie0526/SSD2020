<%@ include file="../IncludeTop.jsp" %>
<div align="center">
<p>${auctionModel.name}</p>
<ul>
	<li> D-Day ${auctionModel.dday}</li>
	<li> Deadline ${auctionModel.deadline}</li>
	<li> Auction Number: ${auctionModel.auctionId}</li>
	<li> Auction Name : ${auctionModel.name}</li>
	<li> Pet KindÖ : ${auctionModel.cname}</li>
	
	<li> Current Max Price: ${auctionModel.curMaxPrice} </li>
	<li> User : ${auctionModel.firstId} </li>
	
	<li> DescriptionÖ : ${auctionModel.description}</li>
	<li> Minimum Price : ${auctionModel.minprice}</li>
	<li> Sellerãù : ${auctionModel.sellerInfoId}</li>
	<li> Status : ${auctionModel.minPrice}</li>
	
	
</ul>
<p><a href="<c:url value='/spetstore/auction/priceregister' />">Register Price</a></p>
</div>
<%@ include file="../IncludeBottom.jsp" %>