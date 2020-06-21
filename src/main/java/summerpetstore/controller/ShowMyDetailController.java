package summerpetstore.controller;
//package summerpetstore.controller;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import summerpetstore.service.AuctionService;
//import summerpetstore.service.MarketService;
//import summerpetstore.service.SpetItemService;
//
//@Controller
//public class ShowMyDetailController {
//	private AuctionService auctionservice;
//	private MarketService marketservice;
//	private SpetItemService spetitemservice;
//	
//	//@Autowired
//	public void setAuctionService(AuctionService auctionservice) {
//		this.auctionservice = auctionservice;
//	}
//	//@Autowired
//	public void setMarketService(MarketService marketservice) {
//		this.marketservice = marketservice;
//	}
//	//@Autowired
//	public void setSpetItemService(SpetItemService spetitemservice) {
//		this.spetitemservice = spetitemservice;
//	}
//	
//	@RequestMapping("/spetitem/update") 
//	public String showMyGp(@RequestParam("itemId") int itemId, @RequestParam("userId") String userId) {
//		spetitemservice.showInfo(itemId, userId);
//		return "gspetitem/gListDetail"; 
//	}//참여한 공동구매 보기
//	
//	@RequestMapping("/auction/detail") 
//	public String showMyAuction(@RequestParam("auctionListId") int auctionListId, @RequestParam("userId") String userId) {
//		auctionservice.showInfo(auctionListId, userId);
//		return "auction/aListDetail"; 
//	}//참여한 경매 보기
//	
//	@RequestMapping("/market/detail") 
//	public String showMyMarket(@RequestParam("itemId") int itemId, @RequestParam("userId") String userId) {
//		marketservice.showInfo(itemId, userId);
//		return "market/gListDetail"; 
//	}//내놓은 물건 보기(장터)
//}
