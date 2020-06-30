package dongduk.cs.ssd.summerpetstore.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.WebUtils;

import dongduk.cs.ssd.summerpetstore.model.AuctionJPModel;
import dongduk.cs.ssd.summerpetstore.model.AuctionModel;
import dongduk.cs.ssd.summerpetstore.model.CartModel;
import dongduk.cs.ssd.summerpetstore.model.ItemModel;
import dongduk.cs.ssd.summerpetstore.service.AuctionService;
import dongduk.cs.ssd.summerpetstore.service.CartService;

@Controller
public class BidController {
	@Autowired
	private AuctionService auctionservice;
	
	
	public void setAuctionService(AuctionService auctionservice) {
		this.auctionservice = auctionservice;
	}
	
	 @ModelAttribute("prForm")
     public PriceRegisterForm prFormData() {
        return new PriceRegisterForm();
     }
	 
	 
	@RequestMapping("/spetstore/auction/bid/{curMaxPrice}/{auctionId}") 
	public String bid(@RequestParam("bidPrice") int myPrice, 
			@PathVariable int curMaxPrice, @PathVariable int auctionId,
			HttpServletRequest request) {	
		if(myPrice <= curMaxPrice) {
			return "auction/priceRegister";
		}
		else {
			UserSession userSession = 
					(UserSession) WebUtils.getSessionAttribute(request, "userSession");
			auctionservice.bid(userSession.getUserId(), myPrice, auctionId); 
			return "auction/aRegisterSuc"; 	
		}	
	}//입찰
	
	@RequestMapping("/auction/priceupdate") 
	public String updateBid(@RequestParam("myPrice") int myPrice, @RequestParam("userId") String userId, 
			@RequestParam("auctionId") int auctionId, @ModelAttribute("AuctionJP")AuctionJPModel jpm) {	
		auctionservice.showJPList(auctionId);
		auctionservice.isNewPrice(myPrice, auctionId); //최고가 이면 true를 반환하게 함 최고가로 수정한게 아니면 등록을 못하게 해야함
		auctionservice.updateBid(jpm);	
		return "auction/aPriceRegister"; 
		
	}//입찰수정
	
	
}
