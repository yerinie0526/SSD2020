package summerpetstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import summerpetstore.model.ItemModel;
import summerpetstore.service.SProductService;

@Controller
public class ShowDetailController {
	
	@Autowired
	private SProductService sproductService;	//���������ㅻ��� ���깅��� ��������������������占�! ���밸��쇱���� ������������ ������������
	ItemModel item;
	
	public void setCartService(SProductService sproductService) {
		this.sproductService = sproductService;
	}
	
	@RequestMapping("/spetitem/detail")	//detail�멨������
	public String showSpetitem(@RequestParam("itemId") int itemId, Model model) {
		item = sproductService.showInfo(itemId);
		model.addAttribute("item", item);
		return "spetitem/sListDetail"; //���밸�源�������諭����������쎌�������������������� output view������ ����������������源���
	}//�쇰�援щℓ臾쇳�����명��蹂닿린

	@RequestMapping("/market/detail")	
	public String showMarketItem(@RequestParam("itemId") int itemId, Model model) {
		item = sproductService.showInfo(itemId);
		model.addAttribute("item", item);
		return "market/mListDetail"; 
	}//�ν�곕Ъ�����명��蹂닿린
	
	
	@RequestMapping("/auction/detail")	
	public String showAuction(@RequestParam("auctionId") int auctionId, Model model) {
		item = sproductService.showInfo(auctionId);
		model.addAttribute("item", item);
		return "auction/aListDetail"; 
	}//경매자세히보기
	

	@RequestMapping("/gp/detail")	
	public String showMarketItem(@RequestParam("itemId") int itemId) {
		if(market물품)
			return "market/mListDetail";
		return "spetitem/gListDetail";
	}//공동구매자세히보기

}
