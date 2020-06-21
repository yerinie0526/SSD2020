package summerpetstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import summerpetstore.model.GpModel;
import summerpetstore.service.GpService;

@Controller
public class GpController {
	
	@Autowired
	private GpService gpService;
	GpModel gp;

	public void setGpService(GpService gpService) {
		this.gpService = gpService;
	}
	
	@RequestMapping("/spetitem/gpdelete")
	public String deleteGp(@RequestParam("itemId") int itemId, Model model) {
		if(gpService.is_GPJP_exist(gp))
			model.addAttribute("deleteok", 0);	
		else
			model.addAttribute("deleteok", 1);	
		
		return "spetitem/categoryView"; 
		
	}//공동구매?��?��
	
	@RequestMapping("/market") 
	public String deleteMgp(@RequestParam("itemId") int itemId, Model model) {
		if(gpService.is_GPJP_exist(gp))
			model.addAttribute("deleteok", 0);	
		else
			model.addAttribute("deleteok", 1);	
		
		return "market/mListDetail"; 
		
	}//?��?��공동구매?��?��
	
	@RequestMapping("/gp/search") 
	public String select(@RequestParam("name") String name, @RequestParam("itemKind") String itemKind) {
		gpService.filterGP();
		gpService.searchName(name);
		gpService.filterCategory();
		gpService.filterDate();
		gpService.filterPopular();
		gpService.filterProgress();
		gpService.filterCategory();
		gpService.filterProduct();	//filter?��?��?? 무엇?���???��??
		return "gp/gpSearch"; 
		
	}//공동구매�???��
	
	
}
