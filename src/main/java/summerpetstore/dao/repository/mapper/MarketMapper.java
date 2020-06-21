package summerpetstore.dao.repository.mapper;

import summerpetstore.model.Market;

public interface MarketMapper {
	Market registerItem(Market market);
	
	Market showInfo(int itemId);
	
	void deleteItem(int itemId);
	
	Market updateItem(Market market);
	
	Market updateItemStatus(int istatus, int itemId);
	
	Market searchItem(int productId, int itemKind);
}
