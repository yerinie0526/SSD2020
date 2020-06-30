package dongduk.cs.ssd.summerpetstore.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.WebUtils;

import dongduk.cs.ssd.summerpetstore.model.CartModel;
import dongduk.cs.ssd.summerpetstore.model.ItemModel;
import dongduk.cs.ssd.summerpetstore.model.UserModel;
import dongduk.cs.ssd.summerpetstore.service.*;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@SessionAttributes("userSession")
public class UserController {

	@Autowired
	private UserService userService;	
	@Autowired
	private AuctionService auctionService;	
	@Autowired
	private MarketService marketService;
	@Autowired
	private GpService gpService;	
	
	@Autowired
	private CartService cartService;
	
	
	public void setCartService(CartService cartService) {
		this.cartService = cartService;
	}
		
	UserModel user;

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public void setAuctionService(AuctionService auctionService) {
		this.auctionService = auctionService;
	}
	public void setMarketService(MarketService marketService) {
		this.marketService = marketService;
	}
	public void setGpService(GpService gpService) {
		this.gpService = gpService;
	}
	
	@ModelAttribute("currentLogin")
	public currentLogin loginData() {
		return new currentLogin();
	}
	
	/*
	 * @RequestMapping("/spetstore/register.do") //register public String
	 * registerUser(@RequestParam("userId") String userId, Model model) { String
	 * name = userService.registerUser(userId); model.addAttribute("username",name);
	 * return "user/sucRegist"; }//�쉶�썝媛��엯
	 */	  
	 /* @RequestMapping("/main") public String deleteUser(@RequestParam("userId")
	 * String userId, Model model) { if(auctionService.is_auction_exist()){
	 * auctionService.cancelSBId(userId); }else if(marketService.is_market_exist())
	 * { marketService.deleteMarket(userId); }else if(gpService.is_gp_exist()){
	 * gpService.deleteGP(userId); }
	 * 
	 * return "main"; }//�쉶�썝�깉�눜
	 */	
	
	 
	/*
	 * @RequestMapping("/spetstore/logincheck") public ModelAndView
	 * logincheck(@ModelAttribute UserModel um, HttpSession session) { boolean
	 * result = userService.logincheck(um, session); ModelAndView mav = new
	 * ModelAndView(); if(result == true) { mav.setViewName("main");
	 * mav.addObject("msg", "success"); }//濡쒓렇�씤�꽦怨� else {
	 * mav.setViewName("user/login"); mav.addObject("msg", "fail"); }//濡쒓렇�씤�떎�뙣 return
	 * mav; }//濡쒓렇�씤泥섎━
	 */	
	
	//login
//	@RequestMapping("/spetstore/signon.do")
//	public ModelAndView handleRequest(HttpServletRequest request,
//			@RequestParam("userId") String userId,
//			@RequestParam("password") String password,
//			@RequestParam(value="forwardAction", required=false) String forwardAction,
//			Model model) {
//		UserModel usermodel = userService.getUser(userId, password);
//		if (usermodel == null) {
//			return new ModelAndView("Error", "message", 
//					"Invalid username or password.  Signon failed.");
//		}
//		else {
//			UserSession userSession = new UserSession(usermodel);
//			//PagedListHolder<Product> myList = new PagedListHolder<Product>(this.petStore.getProductListByCategory(account.getFavouriteCategoryId()));
//			//myList.setPageSize(4);
//			//userSession.setMyList(myList);
//			model.addAttribute("userSession", userSession);
//			if (forwardAction != null) 
//				return new ModelAndView("redirect:" + forwardAction);
//			else 
//				return new ModelAndView("index");
//		}
//	}
	
	  @RequestMapping("/spetstore/delete") 
	  public String deleteUser(@RequestParam("userId") String userId, HttpSession session, SessionStatus sessionStatus) {
		  userService.deleteUser(userId);
		  session.removeAttribute("userSession");
		  session.invalidate();
		  sessionStatus.setComplete();
		  return "redirect: /summerpetstore/index"; 
	  }//회원탈퇴	  
	
	@RequestMapping("/spetstore/signon.do")
	public ModelAndView handleRequest(HttpServletRequest request,
			@ModelAttribute("currentLogin") currentLogin loginData , Model model) {
		System.out.println("id:" + loginData.getUserId()+ " pw: " + loginData.getPassword());
		UserModel usermodel = userService.getUserById(loginData.getUserId(), loginData.getPassword());
		if (usermodel == null) {
			System.out.println("login fail.....");

			return new ModelAndView("/user/SignonForm", "message", 
					"Invalid username or password.  Signon failed.");
		}
		else {
			if (loginData.getPassword().equals(usermodel.getPassword())) {
				UserSession userSession = new UserSession(usermodel, loginData.getUserId());
				model.addAttribute("userSession", userSession);
				System.out.println("여기요!");
				//return new ModelAndView("index");
				return new ModelAndView("redirect: /summerpetstore/index"); 
			}
			else
				return new ModelAndView("redirect:" + "/spetstore/signon.do");
			
		}
	}
	
	  @RequestMapping("/spetstore/user/signoff.do") 
	  public String logout(HttpSession session, SessionStatus sessionStatus) {
		  session.removeAttribute("userSession");
		  session.invalidate();
		  sessionStatus.setComplete();
		  System.out.println("########logout");
		  return "redirect: /summerpetstore/index"; 
	  }//로그아웃
	  
	  
	  
	  @RequestMapping("/spetstore/user/myPage.do") 
	  public ModelAndView myPage(HttpServletRequest request) {
		  UserSession userSession = 
					(UserSession) WebUtils.getSessionAttribute(request, "userSession");
		  	List<ItemModel> imList = marketService.searchMarketByUser(userSession.getUserId()); 
		  	System.out.println("###################" + userSession.getUserId());
	        return new ModelAndView("/user/myPage", "mList", imList);
	   }//마이페이지로 이동
	  
	  @RequestMapping("/spetstore/listOrders.do") 
	  public ModelAndView myOrders(HttpServletRequest request) {
		  UserSession userSession = 
					(UserSession) WebUtils.getSessionAttribute(request, "userSession");
		  	List<ItemModel> imList = marketService.searchMarketByUser(userSession.getUserId()); 
	        return new ModelAndView("/user/myPage", "mList", imList);
	   }//주문내역으로 이동
	  
	  
		
	  
	  
	/*
	 * @RequestMapping("/mypage/update") public String
	 * updateUser(@RequestParam("userId") String userId) {
	 * userService.updateMyPage(userId); return "user/myPage"; }//�쉶�썝�젙蹂댁닔�젙
	 */	 
	
}
