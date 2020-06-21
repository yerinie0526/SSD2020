package summerpetstore.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import summerpetstore.dao.AuctionDAO;
import summerpetstore.dao.CartDAO;
import summerpetstore.model.AuctionJPModel;
import summerpetstore.model.AuctionModel;


@Service
public class AuctionService {
	
	@Autowired
	private AuctionDAO adao;
	

	//카테코리, 종류 등으로도 검색이 가능해야하므로 모델 전체를 보내줘야할듯
	public List<AuctionModel> searchAuction(AuctionModel am) { 
		return adao.searchAuction(am);
	}
	

	public AuctionModel showInfo(int auctionId) { 
		return adao.showInfo(auctionId);
	}

	public List<AuctionJPModel> showJPList(int auctionId) {
		return adao.showJPList(auctionId);
	}


	public void registerAuction(AuctionModel am) { 
		adao.registerAuction(am);
	}
	

	public void updateAuction(AuctionModel am) {
		adao.updateAuction(am);
	}

	
	public void deleteAuction(int auctionId) {
		adao.deleteAuction(auctionId);
	}
	
	public void bid(AuctionJPModel jpm, AuctionModel am) {
		adao.bid(jpm, am);
	}
	
	
	public void updateBid(int auctionId, int price) {
		adao.updateBid(auctionId, price);
	}
	
	public void sucBid(AuctionModel am) {
		adao.sucBid(am);
	}
	
	public boolean isNewPrice(int price, int auctionId) {
		
	}

}
