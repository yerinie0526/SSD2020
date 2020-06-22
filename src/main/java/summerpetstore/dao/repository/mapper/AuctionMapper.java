package summerpetstore.dao.repository.mapper;

import java.util.List;

import summerpetstore.model.AuctionJPModel;
import summerpetstore.model.AuctionModel;

public interface AuctionMapper {
	
	List<AuctionModel> searchAuction(AuctionModel am);
	List<AuctionModel> searchAuctionByDday(AuctionModel am);
	List<AuctionModel> searchAuctionByCon(AuctionModel am);
	AuctionModel showInfo(int auctionId);
	List<AuctionJPModel> showJPModel(int auctionId);
	void registerAuction(AuctionModel am);
	void updaeAuction(AuctionModel am);
	void deleteAuction(int auctionId);
	void bid(AuctionJPModel jpm);
	void changeFirstId(AuctionJPModel jpm); //여기서 userId와 offerPrice만 꺼내서쓰던가 아니면 그냥 그 두개를 보내주던가
	void updateBid(AuctionJPModel jpm);
	//void deleteBid 가격만 높여놓고 취소할 상황을 대비해 없애기로함 toss기능도 마찬가지
	void sucBid(AuctionModel am);
	int getFirstPrice(int auctionId); //현재 최고가 반환: 주로 입찰수정이나 입찰할때 입찰가가 최고가보다 가격이 커야하므로 비교할때 사용

}
