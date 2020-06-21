package summerpetstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import summerpetstore.model.ItemModel;
import summerpetstore.service.SProductService;

@Controller
public class SproductController {
	@Autowired
	private SProductService sproductService;	
	private ItemModel sp;
	
	public void setCartService(SProductService sproductService) {
		this.sproductService = sproductService;
	}

	@RequestMapping("/spetitem/register") 
	public String registeritem(@RequestParam("itemId") int itemId, Model model) {
		sp = sproductService.registerSP(itemId);
		model.addAttribute("sp", sp);
		return "spetitem/categoryView"; 
	}//물품등록
	
	@RequestMapping("/spetitem/delete") 
	public String deleteitem(@RequestParam("itemId") int itemId, Model model) {
		sp = sproductService.deleteSP(itemId);
		model.addAttribute("sp", sp);
		return "spetitem/categoryView"; 
	}//물품삭제
	
	@RequestMapping("/spetitem/update") 
	public String updateitem(@RequestParam("itemId") int itemId, Model model) {
		sp = sproductService.updateSP(itemId);
		model.addAttribute("sp", sp);
		return "spetitem/sListDetail";
	}//물품수정
}
