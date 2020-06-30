package dongduk.cs.ssd.summerpetstore.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
@SessionAttributes("userSession")
public class CartController {
	@Autowired
	private CartService cartService;
	
	@Autowired
	private MarketService ms;
	
	private Date nowTime;
		
	
	public void setCartService(CartService cartService) {
		this.cartService = cartService;
	}

	@ModelAttribute("sessionCart")
	   public CartModel cartList() {
	      return new CartModel();
	   }
	
	@ModelAttribute("newOrder")
	   public Order newOrder() {
	      return new Order();
	   }
	
	@ModelAttribute("orderForm")
	   public OrderForm newOrderForm() {
	      return new OrderForm();
	   }
	
	@ModelAttribute("updateQuantity")
	   public UpdateQuantity updateQuantityNum() {
	      return new UpdateQuantity();
	   }
	
	@ModelAttribute("creditCardTypes") 
	   public List<String> cardData() throws Exception{
	      List<String> cKinds = new ArrayList<String>();
	      cKinds.add("VISA");
	      cKinds.add("MasterCard");
	      cKinds.add("American Express");
	      return cKinds;
	   }
	
	@RequestMapping("/spetstore/user/order/PaidForm.do")
	public String makeOrder(@ModelAttribute("sessionCart") CartModel cartmodel, 
			@ModelAttribute("newOrder") Order order, 
			@ModelAttribute("orderForm") OrderForm orderForm, HttpServletRequest request,
			@RequestParam("totalPrice") int totalPrice) {
		nowTime = new Date();
		DateFormat format = new SimpleDateFormat("yyMMdd");
		UserSession userSession = 
				(UserSession) WebUtils.getSessionAttribute(request, "userSession");
		orderForm.setName(userSession.getUserModel().getUsername());
		orderForm.setAddress(userSession.getUserModel().getAddress());
		orderForm.setPhone(userSession.getUserModel().getPhone());
		orderForm.setUserId(userSession.getUserId());
		orderForm.setOrderDate(format.format(nowTime));
		orderForm.setTotalPrice(totalPrice);
		System.out.println(orderForm.getTotalPrice());
		return "user/PayForm";
	}
	
	@RequestMapping("/spetstore/user/myPage/cart/updatequantity")
	public ModelAndView changeQuantity(@ModelAttribute("updateQuantity") UpdateQuantity uQuantity, 
		@RequestParam("itemId") int itemId ,HttpServletRequest request) {
		UserSession userSession = 
				(UserSession) WebUtils.getSessionAttribute(request, "userSession");
		uQuantity.setItemId(itemId);
		uQuantity.setUserId(userSession.getUserId());
		System.out.println(uQuantity.getNewQuantity());
		cartService.updateQuantity(uQuantity);
		List<CartModel> cartList = cartService.showCartList(userSession.getUserId());
		return new ModelAndView("/user/myPage/Cart", "cartList", cartList);
	}
	
	@RequestMapping("/spetstore/user/order/PaidSuc.do")
	public String finishOrder(@ModelAttribute("newOrder") Order order,
			@ModelAttribute("orderForm") OrderForm orderForm, Model model, HttpServletRequest request) {
		UserSession userSession = 
				(UserSession) WebUtils.getSessionAttribute(request, "userSession");
		orderForm.setUserId(userSession.getUserId());
		cartService.createOrder(orderForm);
		return "user/PaidSuc";
	}
	
	@RequestMapping("/spetstore/market/addCart/{itemId}") 
	public ModelAndView addCartMarket(@PathVariable int itemId, HttpServletRequest request) {
		UserSession userSession = 
				(UserSession) WebUtils.getSessionAttribute(request, "userSession");
		if(userSession == null) {
			return new ModelAndView("user/SignonForm");}
		else {
			cartService.addCart(userSession.getUserId(), itemId);
			ItemModel iData = ms.showInfo(itemId);
			System.out.println("add cart at market  @item id" + itemId);
			return new ModelAndView("market/mDetail", "iData", iData);
		}
	}//장바구니 담기
	
	@RequestMapping("/spetstore/spetitem/addCart/{itemId}") 
	public ModelAndView addCartSpetitem(@PathVariable int itemId, HttpServletRequest request) {
		UserSession userSession = 
				(UserSession) WebUtils.getSessionAttribute(request, "userSession");
		if(userSession == null) {
			return new ModelAndView("user/SignonForm");} 
		else {
		cartService.addCart(userSession.getUserId(), itemId);
		ItemModel iData = ms.showInfo(itemId);
		System.out.println("add cart  @item id " + itemId);
		return new ModelAndView("spetitem/sListDetail", "di", iData);
		}
	}//장바구니 담기
	
	@RequestMapping("/spetstore/user/myPage/cart.do") 
	public ModelAndView showCart(HttpServletRequest request) {
		System.out.println("#####################Cart Controller");
		UserSession userSession = 
				(UserSession) WebUtils.getSessionAttribute(request, "userSession");
		if (userSession != null) {
	        List<CartModel> cartList = cartService.showCartList(userSession.getUserId()); 
	        return new ModelAndView("/user/myPage/Cart", "cartList", cartList);
		}
		else 
			return new ModelAndView("redirect: /summerpetstore/spetstore/user/signonForm.do"); 
		
	}//장바구니로 이동
	
	@RequestMapping("/spetstore/user/myPage/cart/remove") 
	public ModelAndView deleteItem(@RequestParam("itemId") int itemId, HttpServletRequest request) {
		UserSession userSession = 
				(UserSession) WebUtils.getSessionAttribute(request, "userSession");
		cartService.deleteCart(userSession.getUserId(), itemId);
		List<CartModel> cartList = cartService.showCartList(userSession.getUserId()); 
        return new ModelAndView("/user/myPage/Cart", "cartList", cartList);
	}//장바구니 물품 삭제
	
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

