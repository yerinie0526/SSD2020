package dongduk.cs.ssd.summerpetstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import dongduk.cs.ssd.summerpetstore.model.AuctionModel;
import dongduk.cs.ssd.summerpetstore.model.ItemModel;
import dongduk.cs.ssd.summerpetstore.service.AuctionService;
import dongduk.cs.ssd.summerpetstore.service.MarketService;
import dongduk.cs.ssd.summerpetstore.service.SproductService;

@Controller
public class ShowCategoryViewController {
	@Autowired
	private SproductService sproductservice;
	
	@Autowired
	private MarketService marketservice;
	
	@Autowired
	private AuctionService auctionservice;
	
	public void setSproductService(SproductService sproductservice) {
		this.sproductservice = sproductservice;
	}
	
	public void setMarketservice(MarketService marketservice) {
		this.marketservice = marketservice;
	}



	@RequestMapping("/spetstore/category/{cname}")	
	public String showCateView(@PathVariable("cname") String cname, Model model) {
		System.out.println("controller in!!!!!!!!!!!!!!");
		List<ItemModel> cdata = sproductservice.showInfoSP(cname);
		List<ItemModel> mdata = marketservice.showInfoMP(cname);
		List<AuctionModel> adata = auctionservice.showInfoAP(cname);
		model.addAttribute("cdata", cdata);
		model.addAttribute("mdata", mdata);
		model.addAttribute("adata", adata);
		return "spetitem/categoryView";
	}//카테고리별정보보기
}
