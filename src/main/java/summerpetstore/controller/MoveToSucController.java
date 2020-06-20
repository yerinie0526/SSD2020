package summerpetstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import summerpetstore.service.AuctionService;

@Controller
public class MoveToSucController {
	
	private AuctionService auctionservice;
	
	@Autowired
	public void setAuctionService(AuctionService auctionservice) {
		this.auctionservice = auctionservice;
	}
	
	@RequestMapping("/auction/apsuc") 
	public String sucBid(@RequestParam("userId") String userId) {	
		auctionservice.getBid();	//무슨 역할인가요?
		auctionservice.setBid();	
		auctionservice.printPriceRank();
		
		return "auction/aPriceRegisterSuc"; 	
	}//경매입찰성공
	
	@RequestMapping("/auction/asuc") 
	public String succseRegister(@RequestParam("auctionId") int auctionId) {	
		auctionservice.updateAuction();
		
		return "auction/aRegisterSuc"; 	
	}//경매등록성공
	
	@RequestMapping("/myPage") 
	public String successUpdate(@RequestParam("auctionId") int auctionId) {	
		auctionservice.popUpdateSuc();	//무슨 역할인가요?	
		
		return "auction/myPage"; 	
	}//경매수정성공
	
	@RequestMapping("/auction/ausuc") 
	public String successUpdateBid(@RequestParam("auctionId") int auctionId) {	
		auctionservice.getBid();	//무슨 역할인가요?
		auctionservice.setBid();	
		auctionservice.printPriceRank();
		
		return "auction/aPriceRegisterSuc"; 	
	}//경매입찰수정성공
}
