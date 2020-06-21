package summerpetstore.dao.repository.mapper;

import summerpetstore.model.CartModel;

public interface CartMapper {
	
	void deleteCart(String userId, int itemId);
	void deleteCartByUser(String userId);
	void addCart(int itemId, String name, int price, boolean inStock, int quantity, String userId);
	void order(CartModel cm);
	int countItem(String userId, int itemId);
	void incrementQuantity(String userId, int itemId); //장바구니에 같은물건을 담았을 경우 사용
	void updateQuantity(String userId, int itemId, int quantity); //장바구니에서 수량을 늘릴경우 (공식물품만 허용)
	
}
