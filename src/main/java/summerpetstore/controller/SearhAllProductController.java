package summerpetstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import summerpetstore.service.SpetItemService;

@Controller
public class SearhAllProductController {
	//@Autowired
	private SpetItemService spetitemservice;
	
	public void setSpetItemService(SpetItemService spetitemservice) {
		this.spetitemservice = spetitemservice;
	}
	
	@RequestMapping("/spetitem/search") 
	public String select(@RequestParam("name") String name) {
		spetitemservice.searchName(name);
		spetitemservice.filterCategory();
		spetitemservice.filterDate();
		spetitemservice.filterPopular();
		spetitemservice.filterProgress();
		spetitemservice.filterCategory();
		spetitemservice.filterProduct();	//filter역할은 무엇인가요??		
		return "spetitem/categoryView"; 
		
	}//물품검색
}
