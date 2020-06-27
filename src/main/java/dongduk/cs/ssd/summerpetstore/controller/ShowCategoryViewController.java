package dongduk.cs.ssd.summerpetstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import dongduk.cs.ssd.summerpetstore.model.ItemModel;
import dongduk.cs.ssd.summerpetstore.service.SProductService;

@Controller
public class ShowCategoryViewController {
	@Autowired
	private SProductService sproductservice;
	
	public void setSProductService(SProductService sproductitemservice) {
		this.sproductservice = sproductservice;
	}
	
	@RequestMapping("/spetstore/category/{cname}")	
	public String showCateView(@PathVariable("cname") String cname) {
		//sproductservice.viewItem(cname);
		return "spetitem/categoryView";
	}//카테고리별정보보기
}
