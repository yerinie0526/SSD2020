package summerpetstore.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import summerpetstore.model.UserModel;
import summerpetstore.service.AuctionService;
import summerpetstore.service.GpService;
import summerpetstore.service.MarketService;
import summerpetstore.service.UserService;

@Controller
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
	
	
	@RequestMapping("/register") //register
	public String registerUser(@RequestParam("userId") String userId, Model model) {
		String name = userService.registerUser(userId); 	
		model.addAttribute("username", name);
		return "sucRegist";
	}//회원가입
	
	@RequestMapping("/main") 
	public String deleteUser(@RequestParam("userId") String userId, Model model) {
		if(auctionService.is_auction_exist()){
			auctionService.cancelSBId(userId);		
		}else if(marketService.is_market_exist()) {
			marketService.deleteMarket(userId);		
		}else if(gpService.is_gp_exist()){
			gpService.deleteGP(userId);
		}
		
		return "main";
	}//회원탈퇴
	
	
	@RequestMapping("/login") 
	public String login() {
		return "user/login";
	}//로그인페이지로 이동

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
	
	
	@RequestMapping("/logout") 
	public String logout(HttpSession sesseion) {
		userService.logout(sesseion);
		
		return "main";
	}//로그아웃

	@RequestMapping("/mypage/update")
	public String updateUser(@RequestParam("userId") String userId) {
		userService.updateMyPage(userId);
		return "user/myPage";
	}//회원정보수정
}
