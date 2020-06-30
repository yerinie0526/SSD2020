package dongduk.cs.ssd.summerpetstore.dao;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import dongduk.cs.ssd.summerpetstore.controller.MarketFilter;
import dongduk.cs.ssd.summerpetstore.controller.MarketForm;
import dongduk.cs.ssd.summerpetstore.dao.repository.mapper.MarketMapper;
import dongduk.cs.ssd.summerpetstore.model.ItemModel;

@Repository
public class MarketDAO {
	
	
	
	@Autowired
	private MarketMapper mmapper;
		
	
	public List<ItemModel> getMarketList(){
		return mmapper.getMarketList();
	}
	
	public void registerItem(MarketForm im) throws DataAccessException{
		mmapper.registerItem(im);
	}
	public void updateItem(MarketForm im) throws DataAccessException{
		mmapper.updateItem(im);
	}
	public List<ItemModel> showInfoMP(String cname){
		return mmapper.showInfoMP(cname);
	}
	 
	public ItemModel showInfo(int itemId) throws DataAccessException{
		return mmapper.showInfo(itemId);	  
	}
		  
	public void deleteItem(int itemId) throws DataAccessException{
			  mmapper.deleteItem(itemId);
	}
	
	public List<ItemModel>  getCartCount(int itemId)throws DataAccessException {
		return mmapper.getCartCount(itemId);
	}

	
	public List<ItemModel> searchItem(MarketFilter marketFilter){
		return mmapper.searchItem(marketFilter);
	}
	
	public List<ItemModel> searchMarketByUser(String userId){
		return mmapper.searchMarketByUser(userId);
	}

}
