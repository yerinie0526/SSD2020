package summerpetstore.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import summerpetstore.dao.MarketDAO;
import summerpetstore.model.Market;

@Service
public class MarketService {
	
	@Autowired
	private MarketDAO mdao;

	public List<Market> getMarketList() {
		// TODO Auto-generated method stub
		return null;
	}
	

	/*
	 * @Transactional public void registerItem(Market im) { mdao.registerItem(im); }
	 * 
	 * 
	 * @Transactional public Market showInfo(Market im) { return
	 * mdao.showInfo(im.getItemId()); }
	 * 
	 * 
	 * @Transactional public void deleteItem(int itemId) { mdao.deleteItem(itemId);
	 * }
	 * 
	 * 
	 * @Transactional public void updateItem(Market im) { mdao.updateItem(im); }
	 * 
	 * 
	 * 
	 * public void updateItemStatus(int itemId) { mdao.updateItemStatus(itemId); }
	 * 
	 * 
	 * public List<Market> searchItem(String itemname, String itemKind) {
	 * List<Market> imList; imList = mdao.searchItem(itemname, itemKind); return
	 * imList; }
	 */

}
