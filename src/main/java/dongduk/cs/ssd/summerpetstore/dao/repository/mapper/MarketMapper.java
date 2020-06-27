package dongduk.cs.ssd.summerpetstore.dao.repository.mapper;

import java.util.List;

import dongduk.cs.ssd.summerpetstore.model.ItemModel;
import dongduk.cs.ssd.summerpetstore.controller.MarketForm;

public interface MarketMapper {
	void registerItem(MarketForm im);
	
	ItemModel showInfo(int itemId);
	
	void deleteItem(int itemId);
	
	ItemModel updateItem(ItemModel im);
	
	ItemModel updateItemStatus(int istatus, int itemId);
	
	List<ItemModel> searchItem(String cname, String itemKind, String keyword);
}
