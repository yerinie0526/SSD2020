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
	
//	@Transactional
//	public int deleteCart(String userId, int itemId) { 
//		return cartdao.deleteCart(userId, itemId);
//	}
//	
//
//	@Transactional
//	public int deleteCartByUser(String userId) { 
//		return cartdao.deleteCartByUser(userId);
//	}
//	
//
//	@Transactional
//	public int order(String userId, int orderId) {
//		return cartdao.order(userId, orderId);
//	}
//	
//
	@Transactional
	public void addCart(String userId, int itemId) { 
		cartdao.addCart(userId, itemId);
	}
//	
//
//	@Transactional
//	public boolean containsItemId(int itemId, String userId) {
//		if(cartdao.getItemCount(itemId, userId) > 0) {
//			return true;
//		}
//		return false;
//	}
//	
//	@Transactional
//	public void incrementQuantityByItemId(int itemId, String userId) {
//		cartdao.incrementQuantityByItemId(itemId, userId);
//	}
}
