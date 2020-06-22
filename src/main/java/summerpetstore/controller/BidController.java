package summerpetstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import summerpetstore.model.AuctionJPModel;
import summerpetstore.model.AuctionModel;
import summerpetstore.model.CartModel;
import summerpetstore.model.ItemModel;
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
	public String bid(@RequestParam("myPrice") int myPrice, @RequestParam("userId") String userId,
			@RequestParam("auctionId") int auctionId, @ModelAttribute("AuctionJP")AuctionJPModel jpm, @ModelAttribute("Auction")AuctionModel am) {	
		auctionservice.showJPList(auctionId);
		auctionservice.isNewPrice(myPrice, auctionId); //최고가 이면 true를 반환하게 함 최고가가 아니면 등록을 못하게 해야함
		auctionservice.bid(jpm, am); 
		//이렇게 모델 두개가필요해서 모델 두개를 파라미터에 추가하고 넣어줬어!
		//그러면 사실 jp에있는 파라미터모두랑 jp모델 둘다 파라미터로 전송되기때문에 둘중하나는 없애도 될것같음
		//모델을 보낼지 파라미터 각각을 보낼지 수정은 금방하니까 수현이 편한걸로해
		//밑에 업데이트 bid도 마찬가지야
		return "auction/aPriceRegister"; 	
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
