package dongduk.cs.ssd.summerpetstore.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dongduk.cs.ssd.summerpetstore.controller.MarketFilter;
import dongduk.cs.ssd.summerpetstore.controller.MarketForm;
import dongduk.cs.ssd.summerpetstore.dao.MarketDAO;
import dongduk.cs.ssd.summerpetstore.model.ItemModel;

@Service
public class MarketService {
	
	@Autowired
	private MarketDAO mdao;

	public List<ItemModel> getMarketList() {
		return mdao.getMarketList();
	}
	
	
	@Transactional 
	public void registerItem(MarketForm im) { 
		mdao.registerItem(im); 
	}
	@Transactional 
	public void updateItem(MarketForm im) { 
		mdao.updateItem(im); 
	}
	public List<ItemModel> showInfoMP(String cname) {
		return mdao.showInfoMP(cname);
	}
	  
	  @Transactional 
	  public ItemModel showInfo(int itemId) { 
		  return mdao.showInfo(itemId); 
	  }
	  
	  
	  @Transactional 
	  public void deleteItem(int itemId) { 
		  mdao.deleteItem(itemId);
	  }
	  @Transactional 
	  public List<ItemModel>  getCartCount(int itemId) {
		  return mdao.getCartCount(itemId);
	  }

	  
	  public List<ItemModel> searchItem(MarketFilter marketFilter) {
		  return mdao.searchItem(marketFilter);
	  }
	  
	  public List<ItemModel> searchMarketByUser(String userId) {
		  List<ItemModel> imList; 
		  imList = mdao.searchMarketByUser(userId); 
		  return imList; 
	}

}
