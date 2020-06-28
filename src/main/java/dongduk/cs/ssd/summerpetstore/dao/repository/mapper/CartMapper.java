package dongduk.cs.ssd.summerpetstore.dao.repository.mapper;

import java.util.List;

import dongduk.cs.ssd.summerpetstore.model.CartModel;
import dongduk.cs.ssd.summerpetstore.model.ItemModel;

public interface CartMapper {
	
	void deleteCart(String userId, int itemId);
	void deleteCartByUser(String userId);
	void addCart(int itemId, String name, int price, int inStock, int qunatity, String userid);
	ItemModel findItembyitemId(int itemId);
	void order(CartModel cm);
	int countItemId(String userId, int itemId);
	void incrementQuantity(String userId, int itemId); //장바구니에 같은물건을 담았을 경우 사용
	void updateQuantity(String userId, int itemId, int quantity); //장바구니에서 수량을 늘릴경우 (공식물품만 허용)
	List<CartModel> showCartList(String userId);
}
