package dongduk.cs.ssd.summerpetstore.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dongduk.cs.ssd.summerpetstore.controller.AuctionForm;
import dongduk.cs.ssd.summerpetstore.dao.AuctionDAO;
import dongduk.cs.ssd.summerpetstore.dao.CartDAO;
import dongduk.cs.ssd.summerpetstore.model.AuctionJPModel;
import dongduk.cs.ssd.summerpetstore.model.AuctionModel;


@Service
public class AuctionService {
	
	@Autowired
	private AuctionDAO adao;
	
	public List<AuctionModel> searchAuction(String cname, String itemKind, String keyword) { 
		return adao.searchAuction(cname, itemKind, keyword);
	}
	
//	public List<AuctionModel> searchAuctionByDday(AuctionModel am) { 
//		return adao.searchAuctionByDday(am);
//	}
//	
//	public List<AuctionModel> searchAuctionByCon(AuctionModel am) { 
//		return adao.searchAuctionByDday(am);
//	}
	public List<AuctionModel> searchAuctionByUser(String userId){
		return adao.searchAuctionByUser(userId);
	}

	
	public void registerPriceAuction(AuctionJPModel ajp) {
		adao.registerPriceAuction(ajp);
	}
	
	public void updateinfoBID(AuctionJPModel ajp) {
		adao.updateinfoBID(ajp);
	}

	public AuctionModel showInfo(int auctionId) { 
		return adao.showInfo(auctionId);
	}
	
	public List<AuctionModel> showAuctionList(){
		return adao.showAuctionList();
	}
	
	public List<AuctionModel> showInfoAP(String cname){
		return adao.showInfoAP(cname);
	}

//	public List<AuctionJPModel> showJPList(int auctionId) {
//		return adao.showJPList(auctionId);
//	}


	public void registerAuction(AuctionForm am) { 
		adao.registerAuction(am);
	}
	

	

//	public void updateAuction(AuctionModel am) {
//		adao.updateAuction(am);
//	}
//
//	
//	public void deleteAuction(int auctionId) {
//		adao.deleteAuction(auctionId);
//	}
//	
	public void bid(String firstId, int price, int auctionId) {
		adao.bid(firstId, price, auctionId);
	}
//	
//	
//	public void updateBid(AuctionJPModel jpm) {
//		adao.updateBid(jpm);
//	}
	
//	public void sucBid(AuctionModel am) {
//		adao.sucBid(am);
//	}
	
	public boolean isNewPrice(int price, int auctionId) {
		if(adao.getFirstPrice(auctionId) < price) return true;
		else return false;
	}

}
