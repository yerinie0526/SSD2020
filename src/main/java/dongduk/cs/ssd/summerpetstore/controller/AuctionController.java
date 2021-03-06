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
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.WebUtils;

import dongduk.cs.ssd.summerpetstore.model.AuctionJPModel;
import dongduk.cs.ssd.summerpetstore.model.AuctionModel;
import dongduk.cs.ssd.summerpetstore.model.ItemModel;
import dongduk.cs.ssd.summerpetstore.service.AuctionService;

@Controller
@SessionAttributes("userSession")
public class AuctionController {
   private AuctionService auctionservice;
   
   @Autowired
   public void setAuctionService(AuctionService auctionservice) {
      this.auctionservice = auctionservice;
   }
   
   @ModelAttribute("categoryIds")       // select  ��그인 pKind  ���     ��
      public List<String> cData() throws Exception{
         List<String> cKinds = new ArrayList<String>();
         cKinds.add("dog");
         cKinds.add("cat");
         cKinds.add("rabbit");
         cKinds.add("fish");
         return cKinds;
      }
      
   @ModelAttribute("itemKinds")      // select  ��그인 pGenre  ���     ��
      public List<String> pGenreData() throws Exception{
         List<String> iKinds = new ArrayList<String>();
         iKinds.add("bath");
         iKinds.add("home");
         iKinds.add("feed");
         iKinds.add("care");
         iKinds.add("else");
         return iKinds;
      }
      
      @ModelAttribute("pMethods")      // select  ��그인 pGenre  ���     ��
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
      
      @ModelAttribute("prForm")
      public PriceRegisterForm prFormData() {
         return new PriceRegisterForm();
      }
      
      @ModelAttribute("auctionJPModel")
	   public AuctionJPModel newJPData() {
		   return new AuctionJPModel();
	   }
      
      @ModelAttribute("auctionModel")
	   public AuctionModel newData() {
		   return new AuctionModel();
	   }
   
   
   @RequestMapping("/spetstore/auction/aSearch.do") 
   public  ModelAndView moveToAuctionRegister() {   
      System.out.println("#####################Controller");
      List<AuctionModel> aList = auctionservice.showAuctionList();
      return new ModelAndView("auction/aSearch", "aList", aList);    
   }//��ŵ��â���� �̵�
      
   @RequestMapping("/spetstore/auction/aregister") 
   public String moveToAuctionRegister(@ModelAttribute("auctionForm") AuctionForm auctionForm,
         HttpServletRequest request) {   
      UserSession userSession = 
            (UserSession) WebUtils.getSessionAttribute(request, "userSession");
      if (userSession != null)
         return "auction/aRegister"; 
      else
         return "user/SignonForm";
   }//��ŵ��â���� �̵�
   
   
   @RequestMapping("/spetstore/auction/aSearch/aRegisterSuc.do") 
   public String registerAuction(@ModelAttribute("auctionForm") AuctionForm auctionForm, 
         HttpServletRequest request, Model model) {   
       UserSession userSession = 
               (UserSession) WebUtils.getSessionAttribute(request, "userSession");
         auctionForm.setSellerInfoId(userSession.getUserId());
       auctionservice.registerAuction(auctionForm);
   
        return "auction/aRegisterSuc";    
   }//��ŵ��
   
   
    @RequestMapping(value="/spetstore/auction/aSearch/aSearch.do") 
    public ModelAndView submit(HttpServletRequest request, 
          @RequestParam("cname") String name, 
          @RequestParam("itemKind") String itemKind, 
          @RequestParam("keyword") String keyword) throws Exception{
        System.out.println("#####################Controller");
        List<AuctionModel> aList = auctionservice.searchAuction(name, itemKind, keyword); 
        return new ModelAndView("/auction/aSearch", "aList", aList);
    }//��� �˻�
    
   
    
    @RequestMapping("/spetstore/auction/priceregister") 
   public String priceRegister(@ModelAttribute("prForm") PriceRegisterForm prForm,
		@RequestParam("curMaxPrice") int cmp, @RequestParam("firstId") String fId, @RequestParam("auctionId") int auctionId, Model model) {  
    	model.addAttribute("curMaxPrice", cmp);
    	model.addAttribute("firstId", fId);
    	model.addAttribute("auctionId", auctionId);
    	model.addAttribute("prForm", prForm);
       return "auction/priceRegister";
   }//����
   
    /*@RequestMapping("/spetstore/auction/aSearch/aPriceRegisterSuc.do") 
	public String registerAuction(@ModelAttribute("auctionModel") AuctionModel am, 
			@ModelAttribute("auctionJPModel") AuctionJPModel ajp, HttpServletRequest request) {	
    	UserSession userSession = 
                (UserSession) WebUtils.getSessionAttribute(request, "userSession");
    	ajp.setCurMaxPrice(100);
    	ajp.setAuctionId(am.getAuctionId());
    	ajp.setFirstId(am.getFirstId());
    	ajp.setUserId(userSession.getUserId());
    	System.out.print(ajp.getAuctionId());
    	System.out.print(ajp.getUserId());
    	System.out.print(ajp.getOfferPrice());
    	System.out.print("max" + ajp.getCurMaxPrice());
    	if (ajp.getOfferPrice() > ajp.getCurMaxPrice())
    		auctionservice.updateinfoBID(ajp);
	     return "auction/priceRegisterSuc"; 
    }
    */
    
    
//   @RequestMapping("/auction/search") 
//   public String select(@RequestParam("name") String name, @RequestParam("itemKind") String itemKind, @ModelAttribute("Auction")AuctionModel am) {   
//      //auctionservice.searchAuction(am);
//      //auctionservice.filterCategory();
//      auctionservice.searchAuctionByDday(am); //��¥ �˹��Ѽ�
//      auctionservice.searchAuctionByCon(am); //�α��
//      //auctionservice.filterProgress();
//      //auctionservice.filterCategory();
//      //auctionservice.filterProduct();
//      //�����ּ�ó���� �޼ҵ���� searchAuction�ӽñⰡ �Ѳ����� �˻����༭ �ּ�ó���� ������� ���ٰ� �����ϴ��� �𸣰ڴ�...
//      return "auction/aSearch";    
//   }//��Ű˻�
   
//   @RequestMapping("/auction/aupdate") 
//   public String updateAuction(@RequestParam("auctionId") int auctionId, @RequestParam("userId") String userId, @ModelAttribute("Auction")AuctionModel am) {   
//      if(auctionservice.is_sBid_exist())
//         auctionservice.updateAuction(am);
//      
//      return "auction/aRegister";    
//   }//��ż���
   
    @RequestMapping("/spetstore/auction/detail")
     public String showAuctionDetail(
           @RequestParam("auctionId") int aId, HttpServletRequest request,
           Model model) throws Exception{
    	UserSession userSession = 
                (UserSession) WebUtils.getSessionAttribute(request, "userSession");
    	if (userSession != null) {
	        AuctionModel am = auctionservice.showInfo(aId);
	        model.addAttribute("auctionModel", am);
	        return "auction/aListDetail";
    	}
    	 else
             return "user/SignonForm";
     }
}