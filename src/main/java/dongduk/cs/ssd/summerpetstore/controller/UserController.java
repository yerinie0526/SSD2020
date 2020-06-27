package dongduk.cs.ssd.summerpetstore.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import dongduk.cs.ssd.summerpetstore.model.UserModel;
import dongduk.cs.ssd.summerpetstore.service.*;
import org.springframework.web.bind.annotation.SessionAttributes;

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
	
	
	/*
	 * @RequestMapping("/register") //register public String
	 * registerUser(@RequestParam("userId") String userId, Model model) { String
	 * name = userService.registerUser(userId); model.addAttribute("username",
	 * name); return "sucRegist"; }//회원가입
	 * 
	 * @RequestMapping("/main") public String deleteUser(@RequestParam("userId")
	 * String userId, Model model) { if(auctionService.is_auction_exist()){
	 * auctionService.cancelSBId(userId); }else if(marketService.is_market_exist())
	 * { marketService.deleteMarket(userId); }else if(gpService.is_gp_exist()){
	 * gpService.deleteGP(userId); }
	 * 
	 * return "main"; }//회원탈퇴
	 */	
	
	/*
	 * @RequestMapping("/spetstore/signon.do") public String login() { return
	 * "user/login"; }//로그인페이지로 이동
	 */
	@RequestMapping("/logincheck") 
	public ModelAndView logincheck(@ModelAttribute UserModel um, HttpSession session) {
		boolean result = userService.logincheck(um, session);
		ModelAndView mav = new ModelAndView();
		if(result == true) {
			mav.setViewName("main");
			mav.addObject("msg", "success");
		}//로그인성공
		else {
			mav.setViewName("user/login");
			mav.addObject("msg", "fail");
		}//로그인실패
		return mav;
	}//로그인처리
	
	
	//login
	@RequestMapping("/spetstore/signon.do")
	public ModelAndView handleRequest(HttpServletRequest request,
			@RequestParam("userId") String userId,
			@RequestParam("password") String password,
			@RequestParam(value="forwardAction", required=false) String forwardAction,
			Model model) {
		UserModel usermodel = userService.getUser(userId, password);
		if (usermodel == null) {
			return new ModelAndView("Error", "message", 
					"Invalid username or password.  Signon failed.");
		}
		else {
			UserSession userSession = new UserSession(usermodel);
			//PagedListHolder<Product> myList = new PagedListHolder<Product>(this.petStore.getProductListByCategory(account.getFavouriteCategoryId()));
			//myList.setPageSize(4);
			//userSession.setMyList(myList);
			model.addAttribute("userSession", userSession);
			if (forwardAction != null) 
				return new ModelAndView("redirect:" + forwardAction);
			else 
				return new ModelAndView("index");
		}
	}
	
	
	/*
	 * @RequestMapping("/logout") public String logout(HttpSession sesseion) {
	 * userService.logout(sesseion);
	 * 
	 * return "main"; }//로그아웃
	 * 
	 * @RequestMapping("/mypage/update") public String
	 * updateUser(@RequestParam("userId") String userId) {
	 * userService.updateMyPage(userId); return "user/myPage"; }//회원정보수정
	 */}
