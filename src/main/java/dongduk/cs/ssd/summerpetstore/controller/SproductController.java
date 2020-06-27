package dongduk.cs.ssd.summerpetstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import dongduk.cs.ssd.summerpetstore.model.ItemModel;
import dongduk.cs.ssd.summerpetstore.service.SProductService;

@Controller
public class SproductController {
	@Autowired
	private SProductService sproductService;	
	private ItemModel sp;
	
	public void setCartService(SProductService sproductService) {
		this.sproductService = sproductService;
	}

	@RequestMapping("/spetitem/register") 
	public String registeritem(Model model, @ModelAttribute("item")ItemModel item) {
		sp = sproductService.registerSP(item);
		model.addAttribute("sp", sp);
		return "spetitem/categoryView"; 
	}//물품등록
	
	@RequestMapping("/spetitem/delete") 
	public String deleteitem(@RequestParam("itemId") int itemId) {
		sproductService.deleteSP(itemId);
		return "spetitem/categoryView"; 
	}//물품삭제
	
	@RequestMapping("/spetitem/update") 
	public String updateitem(@ModelAttribute("item")ItemModel item) {
		sproductService.updateSP(item);
		return "spetitem/sListDetail";
	}//물품수정
}
