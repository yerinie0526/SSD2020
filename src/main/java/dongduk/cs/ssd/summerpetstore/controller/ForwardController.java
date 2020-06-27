package dongduk.cs.ssd.summerpetstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import dongduk.cs.ssd.summerpetstore.model.UserModel;
import dongduk.cs.ssd.summerpetstore.service.GpService;

@Controller
public class ForwardController {
/*	@Autowired
	ForwardService forwardService;
	
	public void setForwardService(ForwardService forwardService) {
		this.forwardService = forwardService;
	}
	*/
	@RequestMapping("/spetstore/user/myPage.do")
	public String showMyPage() {
		//if(forwardService.is_admin())
			//return "user/summerPage"; 
		//else
			return"user/myPage"; 
	}//마이페이지로 이동
	
	@RequestMapping("/spetstore/user/signonForm.do")
	public String showLogin() {
		
			return"user/SignonForm"; 
	}//로그인 이동
	
	@RequestMapping("/spetstore/user/newAccount.do")
	public String showRegister(Model model) {
		  model.addAttribute("user", new UserModel());

			return"user/register"; 
	}//회원가입 이동
/*
	@RequestMapping("/market") 
	public String moveMarketSearch() {
		return"market/mSearch"; 
	}//장터검색으로 이동
	
	@RequestMapping("/market/register") 
	public String moveMarketRegister(@RequestParam("userId") String userId) {
			return"market/iRegister"; 
	}//장터물품등록창으로 이동
	
	@RequestMapping(value = "/auction",  method = RequestMethod.GET) 
	public String moveAuctionSearch(@RequestParam("userId") String userId) {
		System.out.println("경매창에 들어왔다!!!");
			return"auction/aSearch"; 
	}//경매검색창으로 이동

	@RequestMapping("/gp") 
	public String moveGPSearch() {
			return""; 
	}//공동구매 검색창으로이동
	*/	
}
