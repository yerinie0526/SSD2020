package dongduk.cs.ssd.summerpetstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import dongduk.cs.ssd.summerpetstore.model.ItemModel;

@Controller
@SessionAttributes("itemModel")
public class MoveToMRegisterController {
	
	@ModelAttribute("itemModel")
	public ItemModel itemData() {
		return new ItemModel();
	}	
	
	@RequestMapping("/market/update") 
	public String moveToMarketUpdate(@RequestParam("itemId") int itemId, @RequestParam("userId") String userId) {	

		return "market/iRegister"; 	
	}//장터물품수정으로이동
	
	
	@RequestMapping("/spetstore/market/mSearch/mRegister.do") 
	public String moveToMarketRegister(@ModelAttribute("itemModel") ItemModel itemmodel) {	
//@RequestParam("userId") String userId
		System.out.println("################movetoMarketRegister");
		return "/market/mRegister"; 	
	}
}
