package dongduk.cs.ssd.summerpetstore.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.WebUtils;

import dongduk.cs.ssd.summerpetstore.model.CartModel;
import dongduk.cs.ssd.summerpetstore.model.ItemModel;
import dongduk.cs.ssd.summerpetstore.service.CartService;
import dongduk.cs.ssd.summerpetstore.service.MarketService;


@Controller
@SessionAttributes("sessionCart")
public class CartController {
	@Autowired
	private CartService cartService;
	
	@Autowired
	private MarketService ms;
	
	
	public void setCartService(CartService cartService) {
		this.cartService = cartService;
	}

	@ModelAttribute("sessionCart")
	   public CartModel cartList() {
	      return new CartModel();
	   }
	
	@RequestMapping("/spetstore/market/addCart/{itemId}") 
	public ModelAndView addCartMarket(@PathVariable int itemId, HttpServletRequest request) {
		UserSession userSession = 
				(UserSession) WebUtils.getSessionAttribute(request, "userSession");
		cartService.addCart(userSession.getUserId(), itemId);
		ItemModel iData = ms.showInfo(itemId);
		return new ModelAndView("market/mDetail", "iData", iData);
	}//장바구니 담기
	
	@RequestMapping("/spetstore/spetitem/addCart/{itemId}") 
	public ModelAndView addCartSpetitem(@PathVariable int itemId, HttpServletRequest request) {
		UserSession userSession = 
				(UserSession) WebUtils.getSessionAttribute(request, "userSession");
		cartService.addCart(userSession.getUserId(), itemId);
		ItemModel iData = ms.showInfo(itemId);
		System.out.println("addcart 성공은함");
		return new ModelAndView("market/mDetail", "iData", iData);

	}//장바구니 담기
	
	//이과정을 dao에서 하는 것으로 바꿈! 그게 나을것같아서 06.29 -예린-
/*	@RequestMapping("/spetstore/spetitem/addCart.do") 
	public String addCart(@RequestParam("itemId") int itemId,@RequestParam("userId") String userId, @RequestParam("price") int price, 
			@RequestParam("name") String name, @RequestParam("inStock") boolean inStock, @RequestParam("quantity") int quantity) {
		CartModel cart;	
		
		if(cartService.containsItemId(itemId, userId))
			cartService.incrementQuantityByItemId(userId, itemId); 	//장바구니에 존재하는 물품이면 수량만 증가시켜줌
		else
			cartService.addCart(itemId, name, price, inStock, quantity, userId);
			
		//model.addAttribute("cart", cart);
		return "spetitem/sListDetail"; 	
	}//장바구니 담기*/ 
	
//	@RequestMapping("/mypage/cart/delete") 
//	public String deleteItem(@RequestParam("userId") String userId, @RequestParam("itemId") int itemId) {
//		cartService.deleteCart(userId, itemId);
//		return "user/myPage/cart"; 
//	}//장바구니 물품 삭제
//	
//	@RequestMapping("/mypage/cart/pay") 
//	public String pay(@RequestParam("userId") String userId, @RequestParam("orderId") int orderId) {
//		cartService.order(userId, orderId);
//		return "user/myPage/sucPay"; 
//	}//장바구니 물품 결제
//	

}

