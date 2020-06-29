package dongduk.cs.ssd.summerpetstore.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.WebUtils;

import dongduk.cs.ssd.summerpetstore.model.AuctionModel;
import dongduk.cs.ssd.summerpetstore.model.ItemModel;
import dongduk.cs.ssd.summerpetstore.service.AuctionService;

@Controller
public class AuctionController {
	private AuctionService auctionservice;
	
	@Autowired
	public void setAuctionService(AuctionService auctionservice) {
		this.auctionservice = auctionservice;
	}
	
	@ModelAttribute("categoryIds")       // select  깭洹몄씤 pKind  젙蹂     옣
	   public List<String> cData() throws Exception{
	      List<String> cKinds = new ArrayList<String>();
	      cKinds.add("dog");
	      cKinds.add("cat");
	      cKinds.add("rabbit");
	      cKinds.add("fish");
	      return cKinds;
	   }
	   
	@ModelAttribute("itemKinds")      // select  깭洹몄씤 pGenre  젙蹂     옣
	   public List<String> pGenreData() throws Exception{
	      List<String> iKinds = new ArrayList<String>();
	      iKinds.add("bath");
	      iKinds.add("home");
	      iKinds.add("feed");
	      iKinds.add("care");
	      iKinds.add("else");
	      return iKinds;
	   }
	   
	   @ModelAttribute("pMethods")      // select  깭洹몄씤 pGenre  젙蹂     옣
	   public List<String> mMethodData() throws Exception{
	      List<String> iKinds = new ArrayList<String>();
	      iKinds.add("parcel");
	      iKinds.add("in person");
	      return iKinds;
	   }
	   
	   @ModelAttribute("auctionForm")
	   public AuctionForm auctionFormData() {
	      return new AuctionForm();
	   }   
	
	
	@RequestMapping("/spetstore/auction/aregister") 
	public String moveToAuctionRegister(@ModelAttribute("auctionForm") AuctionForm auctionForm) {	
		return "auction/aRegister"; 	
	}//경매등록창으로 이동
	
	
	@RequestMapping("/spetstore/auction/aSearch/aRegisterSuc.do") 
	public String registerAuction(@ModelAttribute("auctionForm") AuctionForm auctionForm, 
			HttpServletRequest request, Model model) {	
		 UserSession userSession = 
					(UserSession) WebUtils.getSessionAttribute(request, "userSession");
	  	 auctionForm.setSellerInfoId(userSession.getUserId());
		 auctionservice.registerAuction(auctionForm);
	
	     return "auction/aRegisterSuc"; 	
	}//경매등록
	
	
    @RequestMapping(value="/spetstore/auction/aSearch/aSearch.do") 
    public ModelAndView submit(HttpServletRequest request, 
          @RequestParam("cname") String name, 
          @RequestParam("itemKind") String itemKind, 
          @RequestParam("keyword") String keyword) throws Exception{
        System.out.println("#####################Controller");
        List<AuctionModel> aList = auctionservice.searchAuction(name, itemKind, keyword); 
        return new ModelAndView("/auction/aSearch", "aList", aList);
    }//경매 검색
	
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
