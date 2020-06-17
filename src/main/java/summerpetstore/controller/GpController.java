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
	
	//@Autowired
	private GpService gpService;	//���������ㅻ��� ���깅��� ��������������������占�! gp������������ ������������
	GpModel gp;

	public void setGpService(GpService gpService) {
		this.gpService = gpService;
	}
	
	@RequestMapping("/spetitem/gpdelete") //gpdelete�멨������ 
	public String deleteGp(@RequestParam("itemId") int itemId, Model model) {
		if(gpService.is_GPJP_exist(gp))
			model.addAttribute("deleteok", 0);	//����������������怨ㅼ��
		else
			model.addAttribute("deleteok", 1);	//������������������������
		
		return "spetitem/categoryView"; //������������������������ output view������ ����������������源���
		
	}//�����������������������쇱��������
	
	@RequestMapping("/market") 
	public String deleteMgp(@RequestParam("itemId") int itemId, Model model) {
		if(gpService.is_GPJP_exist(gp))
			model.addAttribute("deleteok", 0);	//����������������怨ㅼ��
		else
			model.addAttribute("deleteok", 1);	//������������������������
		
		return "market/mListDetail"; 
		
	}//���������띔낀�������������������쇱��������--���깃낀�� �����쎌�����깅��� ������������ �����������������������쇱�������������� ������移������� 泥����������뀀��������� �����������������댁�� ���밸���� ���뀀��������� ���リ낀��移������� ���깅��������� ���깅��������� ��������������������占�
		//�ν�곌났��援щℓ����
	
	
}
