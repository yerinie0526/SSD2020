package dongduk.cs.ssd.summerpetstore.controller;

import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import dongduk.cs.ssd.summerpetstore.model.ItemModel;
import dongduk.cs.ssd.summerpetstore.service.CartService;
import dongduk.cs.ssd.summerpetstore.service.MarketService;

@Controller
@SessionAttributes("marketForm")
public class MarketController {
	
	@Autowired
	private MarketService marketService;	
	
	
	public void setMarketService(MarketService marketService) {
		this.marketService = marketService;
	}
	
	@ModelAttribute("categoryIds") 		// select �깭洹몄씤 pKind �젙蹂� ���옣
	public List<String> cData() throws Exception{
		List<String> cKinds = new ArrayList<String>();
		cKinds.add("dog");
		cKinds.add("cat");
		cKinds.add("rabbit");
		cKinds.add("fish");
		return cKinds;
	}
	
	@ModelAttribute("itemKinds")		// select �깭洹몄씤 pGenre �젙蹂� ���옣
	public List<String> pGenreData() throws Exception{
		List<String> iKinds = new ArrayList<String>();
		iKinds.add("bath");
		iKinds.add("feed");
		iKinds.add("care");
		return iKinds;
	}
	
	@ModelAttribute("pMethods")		// select �깭洹몄씤 pGenre �젙蹂� ���옣
	public List<String> mMethodData() throws Exception{
		List<String> iKinds = new ArrayList<String>();
		iKinds.add("parcel");
		iKinds.add("in person");
		return iKinds;
	}
	
	@ModelAttribute("marketForm")
	public MarketForm marketFormData() {
		return new MarketForm();
	}	
	
//	@RequestMapping("/market/main") 
//	public String showMarketList(Model model) {
//		List<Market> mList = marketService.getMarketList();
//		model.addAttribute("mList", mList);
//		return "market/mSearch"; 
//	}
//	
	  @RequestMapping("/spetstore/market/mSearch//mRegisterSuc.do") 
	  public String registerMarket(@ModelAttribute("marketForm") MarketForm marketForm, 
			  SessionStatus sessionStatus, Model model){
		  marketService.registerItem(marketForm); 
		  sessionStatus.setComplete();
		  System.out.println("################mregistersucc controller");
		  return "market/mRegisterSuc"; 
	  }//�옣�꽣臾쇳뭹�벑濡�
//	  
//	  @RequestMapping("/market/delete") 
//	  public String deleteMarket(@RequestParam("marketId") int marketId)
//	  {
//		  marketService.deleteItem(marketId); 
//		  return "market/mSearach";
//	  }//�옣�꽣臾쇳뭹�궘�젣
//	  
//	  @RequestMapping("/market/mitemView") 
//	  public String updateMarket(@RequestParam("userId") String userId) {
//		  marketService.updateItem(userId); 
//	  	  return "market/mListDetail";
//	  }//�옣�꽣臾쇳뭹�닔�젙
	  
//	  @RequestMapping("/market/search") 
//	  public String select(@RequestParam("name")String name, @RequestParam("itemKind")String itemKind, @RequestParam("keyword")String keyword) {
//		  System.out.println("/market/search");
//		  marketService.searchItem(name, itemKind, keyword); 
//		  return "market/mListDetail";
//	  
//	  }//吏뺥꽣寃��깋
	  

	  @RequestMapping(value="/spetstore/market/mSearch/mSearch.do") 
	  public ModelAndView submit(HttpServletRequest request, 
			  @RequestParam("cname") String name, 
			  @RequestParam("itemKind") String itemKind, 
			  @RequestParam("keyword") String keyword) throws Exception{
		  System.out.println("#####################Controller");
		  List<ItemModel> imList = marketService.searchItem(name, itemKind, keyword); 
		  //System.out.println(imList.get(0).getName());
		  return new ModelAndView("/market/mSearch", "mList", imList);
	  
	  }//吏뺥꽣寃��깋
	  
	  
	  
	
	 }