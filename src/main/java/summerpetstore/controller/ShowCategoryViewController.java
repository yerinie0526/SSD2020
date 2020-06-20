package summerpetstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import summerpetstore.model.ItemModel;
import summerpetstore.service.SProductService;
import summerpetstore.service.SpetItemService;

@Controller
public class ShowCategoryViewController {
	//@Autowired
	private SpetItemService spetitemservice;
	
	public void setSpetItemService(SpetItemService spetitemservice) {
		this.spetitemservice = spetitemservice;
	}
	
	@RequestMapping("/category")	
	public String showCateView(@RequestParam("productId") int productId, @RequestParam("categoryId") int categoryId) {
		spetitemservice.viewItem(productId, categoryId);
		return "spetitem/categoryView";
	}//카테고리별정보보기
}
