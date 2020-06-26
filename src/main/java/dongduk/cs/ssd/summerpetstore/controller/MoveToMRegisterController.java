package dongduk.cs.ssd.summerpetstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MoveToMRegisterController {
	@RequestMapping("/market/update") 
	public String moveToMarketUpdate(@RequestParam("itemId") int itemId, @RequestParam("userId") String userId) {	

		return "market/iRegister"; 	
	}//장터물품수정으로이동
	
	
	
	
	@RequestMapping("/spetstore/market/mSearch/mRegister.do") 
	public String moveToMarketRegister() {	
//@RequestParam("userId") String userId
		System.out.println("################movetoMarketRegister");
		return "/market/mRegister"; 	
	}//장터물품수정으로이동
}
