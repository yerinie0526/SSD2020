package dongduk.cs.ssd.summerpetstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import dongduk.cs.ssd.summerpetstore.model.ItemModel;
import dongduk.cs.ssd.summerpetstore.service.SProductService;
import dongduk.cs.ssd.summerpetstore.service.SproductService;

@Controller
public class ShowDetailController {
	
	@Autowired
	private SproductService sproductService;	
	ItemModel item;
	
	public void setSproductService(SproductService sproductService) {
		this.sproductService = sproductService;
	}
	
	@RequestMapping("/spetstore/spetitem/detail")	
	public String showSpetitem(@RequestParam("itemId") int itemId, Model model) {
		
		System.out.println("여기로너어옴");
		item= sproductService.showdetailInfoSP(itemId);
		model.addAttribute("di", item);
		System.out.println("22222222222"+itemId+"%%%%%%%%%%%"+item.getItemId());

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
