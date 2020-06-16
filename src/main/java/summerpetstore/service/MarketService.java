package summerpetstore.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import summerpetstore.dao.MarketDAO;
import summerpetstore.model.ItemModel;


public class MarketService {
	
	@Autowired
	private MarketDAO mdao;
	

	@Transactional
	public void registerItem(ItemModel im) { 
		mdao.registerItem(im);
	}
	

	@Transactional
	public ItemModel showInfo(ItemModel im) { 
		return mdao.showInfo(im.getItemId());
	}
	
	//���͹�ǰ ����
	@Transactional
	public void deleteItem(int itemId) { // �Ű����� ��� �ʿ�
		mdao.deleteItem(itemId);
	}
	
	//���͹�ǰ ����
	@Transactional
	public void updateItem(ItemModel im) { // �Ű����� ��� �ʿ�
		mdao.updateItem(im);
	}
	
	
	//���ͻ��� ���� ex) �ŷ��� -> �ŷ� �Ϸ�
	public void updateItemStatus(int itemId) {
		mdao.updateItemStatus(itemId);
	}
		
	//���� �˻�
	public List<ItemModel> searchItem(String itemname, String itemKind) {
		List<ItemModel> imList;
		imList = mdao.searchItem(itemname, itemKind);
		return imList;
	}

}
