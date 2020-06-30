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

import dongduk.cs.ssd.summerpetstore.model.AuctionModel;
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

	
	  @RequestMapping("/spetstore/delete") 
	  public String deleteUser(@RequestParam("userId") String userId, HttpSession session, SessionStatus sessionStatus) {
		  userService.deleteUser(userId);
		  session.removeAttribute("userSession");
		  session.invalidate();
		  sessionStatus.setComplete();
		  return "redirect: /summerpetstore/index"; 
	  }//�쉶�썝�깉�눜	  
	
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
				System.out.println("�뿬湲곗슂!");
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
	  }
	  
	  
	  
	  @RequestMapping("/spetstore/user/myPage.do") 
	  public String myPage(HttpServletRequest request, Model model) {
		  UserSession userSession = 
					(UserSession) WebUtils.getSessionAttribute(request, "userSession");
		  	List<ItemModel> mList = marketService.searchMarketByUser(userSession.getUserId()); 
		  	List<AuctionModel> aList = auctionService.searchAuctionByUser(userSession.getUserId());
		  	model.addAttribute("mList", mList);
		  	model.addAttribute("aList", aList);
	        return"/user/myPage";
	   }
	  
	  @RequestMapping("/spetstore/listOrders.do") 
	  public ModelAndView myOrders(HttpServletRequest request) {
		  UserSession userSession = 
					(UserSession) WebUtils.getSessionAttribute(request, "userSession");
		  	List<ItemModel> imList = marketService.searchMarketByUser(userSession.getUserId()); 
	        return new ModelAndView("/user/myPage", "mList", imList);
	   }
	  
	  
		

}
