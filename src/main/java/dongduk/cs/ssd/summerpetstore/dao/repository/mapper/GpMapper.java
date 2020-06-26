package dongduk.cs.ssd.summerpetstore.dao.repository.mapper;

import java.util.List;

import dongduk.cs.ssd.summerpetstore.model.CompleteOrderModel;
import dongduk.cs.ssd.summerpetstore.model.GpModel;

public interface GpMapper {
	
	void updateGp(GpModel gm);
	void deleteGp(int itemId);
	void cancelGp(int itemId); //보류
	List<GpModel> searchGp(String gpStatus, int productId, String name);
	
	//공동구매 참여
	void participateGp(int currentCon, int itemId);
	void addCompleteOrder(CompleteOrderModel com);
	void addGpJP(int itemId, String userId);
	
	boolean is_GPJP_exist(int itemId);
	void cancelGpJP(int itemId);

}
