package summerpetstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import summerpetstore.model.CartModel;
import summerpetstore.service.AuctionService;
import summerpetstore.service.CartService;

@Controller
public class BidController {
	private AuctionService auctionservice;
	
	@Autowired
	public void setAuctionService(AuctionService auctionservice) {
		this.auctionservice = auctionservice;
	}
	
	@RequestMapping("/auction/priceregister") 
	public String bid(@RequestParam("myPrice") int myPrice,@RequestParam("userId") String userId,@RequestParam("auctionId") int auctionId) {	
		auctionservice.showJPList(auctionId);
		auctionservice.isNewPrice(myPrice);
		auctionservice.getBid();	
		auctionservice.setBid();	
		return "auction/aPriceRegister"; 	
	}//ÀÔÂû
	
	@RequestMapping("/auction/priceupdate") 
	public String updateBid(@RequestParam("myPrice") int myPrice,@RequestParam("userId") String userId) {	
		auctionservice.printPriceRank();
		auctionservice.isNewPrice(myPrice);
		auctionservice.getBid();	
		auctionservice.setBid();
		
		return "auction/aPriceRegister"; 
		
	}//ÀÔÂû¼öÁ¤
	
	
}
