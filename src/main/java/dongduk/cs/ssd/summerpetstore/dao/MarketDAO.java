package dongduk.cs.ssd.summerpetstore.dao;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import dongduk.cs.ssd.summerpetstore.controller.MarketForm;
import dongduk.cs.ssd.summerpetstore.dao.repository.mapper.MarketMapper;
import dongduk.cs.ssd.summerpetstore.model.ItemModel;

@Repository
public class MarketDAO {
	
	
	
	@Autowired
	private MarketMapper mmapper;
		
	
	public void registerItem(MarketForm im) throws DataAccessException{
		mmapper.registerItem(im);
	}
	
	/* 
		 * public ItemModel showInfo(int itemId) throws DataAccessException;
		 * 
		 * public void deleteItem(int itemId) throws DataAccessException;
		 * 
		 * public void updateItem(ItemModel im) throws DataAccessException;
		 * 
		 * public void updateItemStatus(int itemId) throws DataAccessException;
		 */ 
	public List<ItemModel> searchItem(String cname, String itemKind, String keyword){
		return mmapper.searchItem(cname, itemKind, keyword);
	}
	

}
