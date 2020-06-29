package dongduk.cs.ssd.summerpetstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import dongduk.cs.ssd.summerpetstore.model.ItemModel;
import dongduk.cs.ssd.summerpetstore.service.SproductService;

@Controller
public class ShowCategoryViewController {
	@Autowired
	private SproductService sproductservice;
	
	public void setSproductService(SproductService sproductservice) {
		this.sproductservice = sproductservice;
	}
	
	@RequestMapping("/spetstore/category/{cname}")	
	public String showCateView(@PathVariable("cname") String cname, Model model) {
		System.out.println("controller in!!!!!!!!!!!!!!");
		List<ItemModel> cdata = sproductservice.showInfoSP(cname);
		//System.out.println("22222222222"+cname+"%%%%%%%%%%%"+cdata.get(0).getItemId());
		model.addAttribute("cdata", cdata);
		return "spetitem/categoryView";
	}//카테고리별정보보기
}
