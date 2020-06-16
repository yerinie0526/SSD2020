package summerpetstore.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import summerpetstore.dao.CartDAO;

@Service
public class CartService {
	@Autowired
	private CartDAO cartdao;
	

	@Transactional
	public int deleteCart(String userId, int itemId) { 
		return cartdao.deleteCart(userId, itemId);
	}
	

	@Transactional
	public int deleteCartByUser(String userId) { 
		return cartdao.deleteCartByUser(userId);
	}
	

	@Transactional
	public int order(String userId, int orderId) {
		return cartdao.order(userId, orderId);
	}
	

	@Transactional
	public void addCart(String userId, int itemId, int price) { 
		
		
	}
	

	@Transactional
	public boolean containsItemId(int itemId, String userId) {
		if(cartdao.getItemCount(itemId, userId) > 0) {
			return true;
		}
		return false;
	}
	
	@Transactional
	public void incrementQuantityByItemId(int itemId, String userId) {
		cartdao.incrementQuantityByItemId(itemId, userId);
	}
}
