package dongduk.cs.ssd.summerpetstore.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import dongduk.cs.ssd.summerpetstore.model.ItemModel;
import dongduk.cs.ssd.summerpetstore.service.CartService;
import dongduk.cs.ssd.summerpetstore.service.MarketService;

@Controller
public class MarketController {
	
	
	private MarketService marketService;	
	
	@Autowired
	public void setMarketService(MarketService marketService) {
		this.marketService = marketService;
	}
	
//	@RequestMapping("/market/main") 
//	public String showMarketList(Model model) {
//		List<Market> mList = marketService.getMarketList();
//		model.addAttribute("mList", mList);
//		return "market/mSearch"; 
//	}
//	
//	  @RequestMapping("/market/register") 
//	  public String registerMarket(@ModelAttribute("itemmodel")ItemModel itemmodel) 
//	  {
//		  marketService.registerItem(itemmodel); return "market/mSearach"; 
//	  }//장터물품등록
//	  
//	  @RequestMapping("/market/delete") 
//	  public String deleteMarket(@RequestParam("marketId") int marketId)
//	  {
//		  marketService.deleteItem(marketId); 
//		  return "market/mSearach";
//	  }//장터물품삭제
//	  
//	  @RequestMapping("/market/mitemView") 
//	  public String updateMarket(@RequestParam("userId") String userId) {
//		  marketService.updateItem(userId); 
//	  	  return "market/mListDetail";
//	  }//장터물품수정
	  
//	  @RequestMapping("/market/search") 
//	  public String select(@RequestParam("name")String name, @RequestParam("itemKind")String itemKind, @RequestParam("keyword")String keyword) {
//		  System.out.println("/market/search");
//		  marketService.searchItem(name, itemKind, keyword); 
//		  return "market/mListDetail";
//	  
//	  }//징터검색
	  

	  @RequestMapping(value="/spetstore/market/mSearch/mSearch.do") 
	  public ModelAndView submit(HttpServletRequest request, 
			  @RequestParam("cname") String name, 
			  @RequestParam("itemKind") String itemKind, 
			  @RequestParam("keyword") String keyword) throws Exception{
		  System.out.println("#####################Controller");
		  List<ItemModel> imList = marketService.searchItem(name, itemKind, keyword); 
		  return new ModelAndView("mSearch", "mList", imList);
	  
	  }//징터검색
	  
	  
	  
	
	 }