package dongduk.cs.ssd.summerpetstore.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import dongduk.cs.ssd.summerpetstore.service.AuctionService;
import dongduk.cs.ssd.summerpetstore.service.MarketService;
import dongduk.cs.ssd.summerpetstore.service.SProductService;

@Controller
public class ShowMyDetailController {
	@Autowired
	private AuctionService auctionservice;
	@Autowired
	private MarketService marketservice;
	@Autowired
	private SProductService sproductservice;
	
	
	public void setAuctionService(AuctionService auctionservice) {
		this.auctionservice = auctionservice;
	}
	public void setMarketService(MarketService marketservice) {
		this.marketservice = marketservice;
	}
	public void setSProductService(SProductService sproductservice) {
		this.sproductservice = sproductservice;
	}
	
	@RequestMapping("/spetitem/update") 
	public String showMyGp(@RequestParam("itemId") int itemId, @RequestParam("userId") String userId) {
		sproductservice.showInfo(itemId);
		return "gspetitem/gListDetail"; 
	}//참여한 공동구매 보기
	
//	@RequestMapping("/auction/detail") 
//	public String showMyAuction(@RequestParam("auctionListId") int auctionListId, @RequestParam("userId") String userId) {
//		auctionservice.showInfo(auctionListId, userId);
//		return "auction/aListDetail"; 
//	}//참여한 경매 보기
	
//	@RequestMapping("/market/detail") 
//	public String showMyMarket(@RequestParam("itemId") int itemId, @RequestParam("userId") String userId) {
//		marketservice.showInfo(itemId, userId);
//		return "market/gListDetail"; 
//	}//내놓은 물건 보기(장터)
}
