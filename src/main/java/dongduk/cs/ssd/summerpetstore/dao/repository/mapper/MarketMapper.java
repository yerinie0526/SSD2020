package dongduk.cs.ssd.summerpetstore.dao.repository.mapper;

import java.util.List;

import dongduk.cs.ssd.summerpetstore.model.ItemModel;
import dongduk.cs.ssd.summerpetstore.controller.MarketFilter;
import dongduk.cs.ssd.summerpetstore.controller.MarketForm;

public interface MarketMapper {
	void registerItem(MarketForm im);
	
	void updateItem(MarketForm im);
	
	ItemModel showInfo(int itemId);
	
	void deleteItem(int itemId);
	
	
	ItemModel updateItemStatus(int istatus, int itemId);
	
	List<ItemModel> searchItem(MarketFilter marketFilter);
	
	List<ItemModel> searchMarketByUser(String userId);
	
	List<ItemModel> getMarketList();
	
	List<ItemModel> showInfoMP(String cname);
	
	List<ItemModel> getCartCount(int itemId);
}
