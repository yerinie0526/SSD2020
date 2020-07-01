package dongduk.cs.ssd.summerpetstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import dongduk.cs.ssd.summerpetstore.model.ItemModel;
import dongduk.cs.ssd.summerpetstore.service.SproductService;

@Controller
public class SproductController {
	@Autowired
	private SproductService sproductService;	
	private ItemModel sp;
	
	public void setSproductService(SproductService sproductService) {
		this.sproductService = sproductService;
	}

	
	@RequestMapping("/spetitem/delete") 
	public String deleteitem(@RequestParam("itemId") int itemId) {
		sproductService.deleteSP(itemId);
		return "spetitem/categoryView"; 
	}//물품삭제
	

}
