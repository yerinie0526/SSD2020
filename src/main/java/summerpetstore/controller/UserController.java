//package summerpetstore.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import summerpetstore.model.UserModel;
//import summerpetstore.service.GpService;
//import summerpetstore.service.MarketService;
//
//@Controller
//public class UserController {
//
//	//@Autowired
//	private UserService userService;	
//	//@Autowired
//	private AuctionService auctionService;	
//	//@Autowired
//	private MarketService marketService;
//	//@Autowired
//	private GpService gpService;	
//		
//	
//	UserModel user;
//
//	public void setUserService(UserService userService) {
//		this.userService = userService;
//	}
//	public void setAuctionService(AuctionService auctionService) {
//		this.auctionService = auctionService;
//	}
//	public void setMarketService(MarketService marketService) {
//		this.marketService = marketService;
//	}
//	public void setGpService(GpService gpService) {
//		this.gpService = gpService;
//	}
//	
//	
//	@RequestMapping("/register") //register
//	public String registerUser(@RequestParam("userId") String userId, Model model) {
//		String name = userService.registerUser(userId); 	//����������������占� �����쎌�� return ������������ username������������! 
//		model.addAttribute("username", name);
//		return "sucRegist";
//	}//����������������占�
//	
//	@RequestMapping("/main") 
//	public String deleteUser(@RequestParam("userId") String userId, Model model) {
//		if(auctionService.is_auction_exist()){
//			auctionService.cancelSBId(userId);		//����������占� ������������������ ��������占� �����������밸���� ������������獰���占� ����������怨ㅼ�� ��������占� ������������
//		}else if(marketService.is_market_exist()) {
//			marketService.deleteMarket(userId);		//��������������占� ���밸�源�������怨ㅼ�� �������� ��������占� ��������
//		}else if(gpService.is_gp_exist()){
//			gpService.deleteGP(userId);
//		}
//		
//		return "main";
//	}	//����������������
//	
//	
//	@RequestMapping("/login") //register�멨������ 
//	public String login(@RequestParam("username") String username, @RequestParam("password") String password) {
//		
//		return "main";
//	}//���멸���������
//	
//	@RequestMapping("/mypage/update") //register�멨������ 
//	public String updateUser(@RequestParam("userId") String userId) {
//		userService.updateMyPage(userId);
//		return "user/myPage";
//	}//��������������������������������
//}
