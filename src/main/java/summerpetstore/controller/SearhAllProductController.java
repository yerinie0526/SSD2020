package summerpetstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import summerpetstore.service.SProductService;

@Controller
public class SearhAllProductController {
	@Autowired
	private SProductService sproductService;
	
	public void setSProductService(SProductService sproductService) {
		this.sproductService = sproductService;
	}
	
	@RequestMapping("/spetitem/search") 
	public String select(@RequestParam("name") String name) {
		sproductService.searchName(name);
		sproductService.filterCategory();
		sproductService.filterDate();
		sproductService.filterPopular();
		sproductService.filterProgress();
		sproductService.filterCategory();
		sproductService.filterProduct();	//filter역할은 무엇인가요??		
		return "spetitem/categoryView"; 
		
	}//물품검색
}
