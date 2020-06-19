package summerpetstore.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import summerpetstore.model.CartModel;
import summerpetstore.service.CartService;


@Controller
@SessionAttributes("sessionCart")
public class CartController {
	
	private CartService cartService;
	
	//@Autowired
	public void setCartService(CartService cartService) {
		this.cartService = cartService;
	}
	
	@RequestMapping("/spetitem/addCart") 
	public String addCart(@RequestParam("itemId") int itemId,@RequestParam("userId") String userId, @RequestParam("price") int price, Model model) {
		CartModel cart;	
		
		if(cartService.containsItemId(itemId, userId))
			cartService.incrementQuantityByItemId(itemId, userId); 
		else
			cartService.addCart(userId, itemId);
			
		//model.addAttribute("cart", cart);
		return "spetitem/sListDetail"; 
		
	}

	@RequestMapping("/cart") 
	public String createCart(HttpSession sesseion) {
			if(cartService.is_item_exist())
		return "user/myPage/cart"; 
		
	}
	
	
	@RequestMapping("/mypage/cart/delete") 
	public String deleteItem(@RequestParam("userId") String userId, @RequestParam("itemId") int itemId) {
		cartService.deleteCart(userId, itemId);
		return "user/myPage/cart"; 
	}
	
	@RequestMapping("/mypage/cart/pay") 
	public String pay(@RequestParam("userId") String userId, @RequestParam("orderId") int orderId) {
		cartService.order(userId, orderId);
		return "user/myPage/sucPay"; 
	}
	
	@RequestMapping("/market/addcart") 
	public String addCart(@RequestParam("marketId") String marketId, @RequestParam("itemId") int itemId, @RequestParam("userId") String userId) {
		cartService.addCart(userId, itemId);
		return "market/mListDetail"; 
	}
}

