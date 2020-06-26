package dongduk.cs.ssd.summerpetstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import dongduk.cs.ssd.summerpetstore.model.ItemModel;
import dongduk.cs.ssd.summerpetstore.service.SProductService;

@Controller
public class ShowDetailController {
	
	@Autowired
	private SProductService sproductService;	
	ItemModel item;
	
	public void setCartService(SProductService sproductService) {
		this.sproductService = sproductService;
	}
	
	@RequestMapping("/spetitem/detail")	
	public String showSpetitem(@RequestParam("itemId") int itemId, Model model) {
		item = sproductService.showInfo(itemId);
		model.addAttribute("item", item);
		return "spetitem/sListDetail"; 
	}//일반구매물품자세히보기

	@RequestMapping("/market/detail")	
	public String showMarketItem(@RequestParam("itemId") int itemId, Model model) {
		item = sproductService.showInfo(itemId);
		model.addAttribute("item", item);
		return "market/mListDetail"; 
	}//장터물품자세히보기
	
	
	@RequestMapping("/auction/detail")	
	public String showAuction(@RequestParam("auctionId") int auctionId, Model model) {
		item = sproductService.showInfo(auctionId);
		model.addAttribute("item", item);
		return "auction/aListDetail"; 
	}//경매자세히보기
	

//	@RequestMapping("/gp/detail")	
//	public String showMarketItem(@RequestParam("itemId") int itemId) {
//		if(market물품)
//			return "market/mListDetail";
//		return "spetitem/gListDetail";
//	}//공동구매자세히보기

}
