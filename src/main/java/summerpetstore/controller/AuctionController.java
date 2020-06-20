//package summerpetstore.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import summerpetstore.service.AuctionService;
//
//@Controller
//public class AuctionController {
//	private AuctionService auctionservice;
//	
//	@Autowired
//	public void setAuctionService(AuctionService auctionservice) {
//		this.auctionservice = auctionservice;
//	}
//	
//	@RequestMapping("/auction/aregister") 
//	public String registerAuction(@RequestParam("userId") String userId) {	
//		auctionservice.registerAuction(userId);
//		return "auction/aRegister"; 	
//	}//경매등록
//	
//	@RequestMapping("/auction/search") 
//	public String select(@RequestParam("name") String name, @RequestParam("itemKind") String itemKind) {	
//		auctionservice.searchName(name);
//		auctionservice.filterCategory();
//		auctionservice.filterDate();
//		auctionservice.filterPopular();
//		auctionservice.filterProgress();
//		auctionservice.filterCategory();
//		auctionservice.filterProduct();	//filter역할은 무엇인가요??
//		return "auction/aSearch"; 	
//	}//경매검색
//	
//	@RequestMapping("/auction/aupdate") 
//	public String updateAuction(@RequestParam("auctionId") int auctionId, @RequestParam("userId") String userId) {	
//		if(auctionservice.is_sBid_exist())
//			auctionservice.searchAuction();	//경매수정이니까 이름 바꾸는게 좋지않을까요?
//		
//		return "auction/aRegister"; 	
//	}//경매수정
//}
