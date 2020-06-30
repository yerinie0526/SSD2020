package dongduk.cs.ssd.summerpetstore.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.WebUtils;

import dongduk.cs.ssd.summerpetstore.controller.MarketFilter;
import dongduk.cs.ssd.summerpetstore.model.ItemModel;
import dongduk.cs.ssd.summerpetstore.service.CartService;
import dongduk.cs.ssd.summerpetstore.service.MarketService;

@Controller
@SessionAttributes("userSession")
public class MarketController {
   
   @Autowired
   private MarketService marketService;   
   
   
   public void setMarketService(MarketService marketService) {
      this.marketService = marketService;
   }
   
   @ModelAttribute("categoryIds")       // select  ÉúÍ∑∏Ïù∏ pKind  †ïÎ≥     û•
   public List<String> cData() throws Exception{
      List<String> cKinds = new ArrayList<String>();
      cKinds.add("dog");
      cKinds.add("cat");
      cKinds.add("rabbit");
      cKinds.add("fish");
      return cKinds;
   }
   
   @ModelAttribute("itemKinds")      // select  ÉúÍ∑∏Ïù∏ pGenre  †ïÎ≥     û•
   public List<String> pGenreData() throws Exception{
      List<String> iKinds = new ArrayList<String>();
      iKinds.add("bath");
      iKinds.add("feed");
      iKinds.add("care");
      return iKinds;
   }
   
   @ModelAttribute("pMethods")      // select  ÉúÍ∑∏Ïù∏ pGenre  †ïÎ≥     û•
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
   
   @ModelAttribute("marketfilter")
   public MarketFilter marketFilterData() {
      return new MarketFilter();
   } 
   
//   @RequestMapping("/market/main") 
//   public String showMarketList(Model model) {
//      List<Market> mList = marketService.getMarketList();
//      model.addAttribute("mList", mList);
//      return "market/mSearch"; 
//   }
//   
// 
   @RequestMapping("/spetstore/market/mSearch/mRegisterSuc.do") 
   public String registerMarket(@ModelAttribute("marketForm") MarketForm marketForm, 
         SessionStatus sessionStatus, Model model, HttpServletRequest request){
  	 UserSession userSession = 
				(UserSession) WebUtils.getSessionAttribute(request, "userSession");
  	 marketForm.setSellerInfoId(userSession.getUserId());
      marketService.registerItem(marketForm); 
      System.out.println("################mregistersucc controller");
      return "market/mRegisterSuc"; 
   }
     
     
     
     // û• Ñ∞Î¨ºÌíà ì±Î° 
//     
//     @RequestMapping("/market/delete") 
//     public String deleteMarket(@RequestParam("marketId") int marketId)
//     {
//        marketService.deleteItem(marketId); 
//        return "market/mSearach";
//     }// û• Ñ∞Î¨ºÌíà Ç≠ †ú
//     
//     @RequestMapping("/market/mitemView") 
//     public String updateMarket(@RequestParam("userId") String userId) {
//        marketService.updateItem(userId); 
//          return "market/mListDetail";
//     }// û• Ñ∞Î¨ºÌíà àò †ï
     
//     @RequestMapping("/market/search") 
//     public String select(@RequestParam("name")String name, @RequestParam("itemKind")String itemKind, @RequestParam("keyword")String keyword) {
//        System.out.println("/market/search");
//        marketService.searchItem(name, itemKind, keyword); 
//        return "market/mListDetail";
//     
//     }//◊ŸïÌÑ∞Í≤  Éâ
     

     @RequestMapping(value="/spetstore/market/mSearch/filter.do") 
     public ModelAndView submit(HttpServletRequest request,
    		 @ModelAttribute("marketFilter") MarketFilter marketFilter)
    		 throws Exception{
        System.out.println("#####################Controller");
        List<ItemModel> imList = marketService.searchItem(marketFilter); 
        return new ModelAndView("/market/mSearch", "mList", imList);
     }//◊ŸïÌÑ∞Í≤  Éâ
     
     @RequestMapping(value="/spetstore/market/mSearch.do") 
     public ModelAndView goToMarketView(HttpServletRequest request)
    		 throws Exception{
        System.out.println("#####################Controller");
        List<ItemModel> mList = marketService.getMarketList(); 
        return new ModelAndView("/market/mSearch", "mList", mList);
     }
     
     @RequestMapping("/spetstore/market/detail")
     public ModelAndView showMarketDetail(
           @RequestParam("itemId") int itemId) throws Exception{
        ItemModel iData = marketService.showInfo(itemId);
        System.out.println("##########detail controller");
        System.out.println(iData.getItemKind());
        return new ModelAndView("market/mDetail", "iData", iData);
     }
     
     @RequestMapping("/spetstore/market/delete/{itemId}")
     public String deleteMarket(
    		 @PathVariable int itemId, Model model) throws Exception{
    	 System.out.println("itemId :" + itemId);
    	 System.out.println(marketService.getCartCount(itemId).size());
    	 if(marketService.getCartCount(itemId).size() == 0) {
    		 marketService.deleteItem(itemId);
    		 System.out.println("if !!!!!!!!");
    		 }
    	 else {
    		 System.out.println("else !!!!!!!!");
    		 model.addAttribute("error", "Cannot be deleted");
    	 }
    	 return "redirect: /summerpetstore/spetstore/user/myPage.do";
     }//∏∂ƒœπ∞«∞ªË¡¶
     
    }