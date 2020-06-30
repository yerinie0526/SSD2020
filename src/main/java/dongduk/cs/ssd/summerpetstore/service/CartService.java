package dongduk.cs.ssd.summerpetstore.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dongduk.cs.ssd.summerpetstore.controller.OrderForm;
import dongduk.cs.ssd.summerpetstore.controller.UpdateQuantity;
import dongduk.cs.ssd.summerpetstore.dao.CartDAO;
import dongduk.cs.ssd.summerpetstore.model.CartModel;

@Service
public class CartService {
	@Autowired
	private CartDAO cartdao;
	

	public List<CartModel> showCartList(String userId){
		return cartdao.showCartList(userId);
	}
	
	@Transactional 
	public void createOrder(OrderForm orderForm) {
		cartdao.createOrder(orderForm);
		cartdao.deleteCartByUser(orderForm);
	}
	
	public void updateQuantity(UpdateQuantity newQuantity) {
		cartdao.updateQuantity(newQuantity);
	}
	
	public void deleteCart(String userId, int itemId) { 
		cartdao.deleteCart(userId, itemId);
	}

	@Transactional
	public void addCart(String userId, int itemId) { 
		cartdao.addCart(userId, itemId);
	}

}
