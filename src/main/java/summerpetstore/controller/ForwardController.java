package summerpetstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import summerpetstore.service.GpService;

@Controller
public class ForwardController {
	
	ForwardService forwardService;
	
	public void setForwardService(ForwardService forwardService) {
		this.forwardService = forwardService;
	}
	
	@RequestMapping("/mypage")
	public String showMyPage(@RequestParam("userId") String userId) {
		if(forwardService.is_admin())
			return "user/summerPage"; 
		else
			return"user/myPage"; 
	}
	
	@RequestMapping("/market") 
	public String moveMarketSearch() {
			return"market/mSearch"; 
	}
	
	@RequestMapping("/market/register") 
	public String moveMarketRegister(@RequestParam("userId") String userId) {
			return"market/iRegister"; 
	}
	
	@RequestMapping("/auction") 
	public String moveAuctionSearch(@RequestParam("userId") String userId) {
			return"auction/aSearch"; 
	}
}
