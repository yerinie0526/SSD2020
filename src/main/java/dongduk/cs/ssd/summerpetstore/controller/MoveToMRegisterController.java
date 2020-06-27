package dongduk.cs.ssd.summerpetstore.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import dongduk.cs.ssd.summerpetstore.model.ItemModel;

@Controller
@SessionAttributes("marketForm")
public class MoveToMRegisterController {
	
	@ModelAttribute("categoryIds") 		// select 태그인 pKind 정보 저장
	public List<String> cData() throws Exception{
		List<String> cKinds = new ArrayList<String>();
		cKinds.add("dog");
		cKinds.add("cat");
		cKinds.add("rabbit");
		cKinds.add("fish");
		return cKinds;
	}
	
	@ModelAttribute("itemKinds")		// select 태그인 pGenre 정보 저장
	public List<String> pGenreData() throws Exception{
		List<String> iKinds = new ArrayList<String>();
		iKinds.add("bath");
		iKinds.add("feed");
		iKinds.add("care");
		return iKinds;
	}
	
	@ModelAttribute("pMethods")		// select 태그인 pGenre 정보 저장
	public List<String> mMethodData() throws Exception{
		List<String> iKinds = new ArrayList<String>();
		iKinds.add("parcel");
		iKinds.add("in person");
		return iKinds;
	}
	
	@ModelAttribute("marketForm")
	public MarketForm marketFormData() {
		return new MarketForm();
	}	
	
	@RequestMapping("/market/update") 
	public String moveToMarketUpdate(@RequestParam("itemId") int itemId, @RequestParam("userId") String userId) {	

		return "market/iRegister"; 	
	}//장터물품수정으로이동
	
	
	@RequestMapping("/spetstore/market/mSearch/mRegister.do") 
	public String moveToMarketRegister(@ModelAttribute("marketForm") MarketForm marketForm) {	
//@RequestParam("userId") String userId
		System.out.println("################movetoMarketRegister");
		return "/market/mRegister"; 	
	}
}
