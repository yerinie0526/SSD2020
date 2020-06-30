package dongduk.cs.ssd.summerpetstore.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dongduk.cs.ssd.summerpetstore.controller.AuctionForm;
import dongduk.cs.ssd.summerpetstore.dao.repository.mapper.AuctionMapper;
import dongduk.cs.ssd.summerpetstore.model.AuctionJPModel;
import dongduk.cs.ssd.summerpetstore.model.AuctionModel;

@Repository
public class AuctionDAO {
	
	@Autowired
	private AuctionMapper amapper;
	

	public List<AuctionModel> searchAuction(String cname, String itemKind, String keyword) {
		return amapper.searchAuction(cname, itemKind, keyword);
	}
	
	public void registerAuction(AuctionForm af) {
		amapper.registerAuction(af);
	}

	public AuctionModel showInfo(int auctionId) {
		return amapper.showInfo(auctionId);
	}
	
	public List<AuctionModel> showAuctionList(){
		return amapper.showAuctionList();
	}
	
	public List<AuctionModel> showInfoAP(String cname){
		return amapper.showInfoAP(cname);
	}
	
	public void updateinfoBID(AuctionJPModel ajp) {
		amapper.updateinfoBID(ajp);
	}
	
	public void bid(String firstId, int price, int auctionId) {
		amapper.bid(firstId, price, auctionId);
	}
	
	public List<AuctionModel> searchAuctionByUser(String userId){
		return amapper.searchAuctionByUser(userId);
	}
	
	public void registerPriceAuction(AuctionJPModel ajp) {
		amapper.registerPriceAuction(ajp);
	}

	
	public int getFirstPrice(int auctionId) {
		return amapper.getFirstPrice(auctionId);
	}
	

}
