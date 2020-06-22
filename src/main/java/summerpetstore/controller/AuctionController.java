package summerpetstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import summerpetstore.model.AuctionModel;
import summerpetstore.service.AuctionService;

@Controller
public class AuctionController {
	private AuctionService auctionservice;
	
	@Autowired
	public void setAuctionService(AuctionService auctionservice) {
		this.auctionservice = auctionservice;
	}
	
	@RequestMapping("/auction/aregister") 
	public String registerAuction(@RequestParam("userId") String userId, @ModelAttribute("Auction")AuctionModel am) {	
		auctionservice.registerAuction(am);
		return "auction/aRegister"; 	
	}//경매등록
	
	@RequestMapping("/auction/search") 
	public String select(@RequestParam("name") String name, @RequestParam("itemKind") String itemKind, @ModelAttribute("Auction")AuctionModel am) {	
		//auctionservice.searchAuction(am);
		//auctionservice.filterCategory();
		auctionservice.searchAuctionByDday(am); //날짜 촉박한순
		auctionservice.searchAuctionByCon(am); //인기순
		//auctionservice.filterProgress();
		//auctionservice.filterCategory();
		//auctionservice.filterProduct();
		//위에주석처리한 메소드들은 searchAuction머시기가 한꺼번에 검사해줘서 주석처리함 결과값은 어디다가 저장하는진 모르겠다...
		return "auction/aSearch"; 	
	}//경매검색
	
	@RequestMapping("/auction/aupdate") 
	public String updateAuction(@RequestParam("auctionId") int auctionId, @RequestParam("userId") String userId, @ModelAttribute("Auction")AuctionModel am) {	
		if(auctionservice.is_sBid_exist())
			auctionservice.updateAuction(am);
		
		return "auction/aRegister"; 	
	}//경매수정
}
