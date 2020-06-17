package summerpetstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import summerpetstore.model.ItemModel;
import summerpetstore.service.SProductService;

@Controller
public class SproductController {
	//@Autowired
	private SProductService sproductService;	//���������ㅻ��� ���깅��� ��������������������占�! ���밸��쇱���� ������������ ������������
	private ItemModel sp;
	
	public void setCartService(SProductService sproductService) {
		this.sproductService = sproductService;
	}

	@RequestMapping("/spetitem/register") //register�멨������ 
	public String registeritem(@RequestParam("itemId") int itemId, Model model) {
		sp = sproductService.registerSP(itemId);
		model.addAttribute("sp", sp);
		return "spetitem/categoryView"; //����������������占� output view������ ����������������源���
	}
	
	@RequestMapping("/spetitem/delete") //delete�멨������ 
	public String deleteitem(@RequestParam("itemId") int itemId, Model model) {
		sp = sproductService.deleteSP(itemId);
		model.addAttribute("sp", sp);
		return "spetitem/categoryView"; //�������������������� output view������ ����������������源���
	}
	
	@RequestMapping("/spetitem/update") //update�멨������ 
	public String updateitem(@RequestParam("itemId") int itemId, Model model) {
		sp = sproductService.updateSP(itemId);
		model.addAttribute("sp", sp);
		return "spetitem/sListDetail"; //�������������������� output view������ ����������������源���
	}
}
