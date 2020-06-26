package dongduk.cs.ssd.summerpetstore.dao.repository.mapper;

import dongduk.cs.ssd.summerpetstore.model.ItemModel;

public interface SproductMapper {
	
	//검색과 옆에 카테고리 창 누르면 나오는 메소드를 만들어야 할듯
	ItemModel showInfoSp(int itemId);
	void registerSP(ItemModel im);
	void deleteSP(int itemId);
	void updateSP(ItemModel im);


}
