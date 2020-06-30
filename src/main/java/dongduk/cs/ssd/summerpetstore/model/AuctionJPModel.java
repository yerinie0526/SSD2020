package dongduk.cs.ssd.summerpetstore.model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class AuctionJPModel implements Serializable{
	
	int auctionId; //물품번호
	String userId; //예시: yerinie0526'
	int offerPrice;
	int curMaxPrice;
	String firstId;
	
	public AuctionJPModel() {
		
	}
	
	public int getCurMaxPrice() {
		return curMaxPrice;
	}

	public void setCurMaxPrice(int curMaxPrice) {
		this.curMaxPrice = curMaxPrice;
	}

	public String getFirstId() {
		return firstId;
	}

	public void setFirstId(String firstId) {
		this.firstId = firstId;
	}

	public AuctionJPModel(int auctionId, String userId, int offerPrice, int curMaxPrice, String firstId) {
		super();
		this.auctionId = auctionId;
		this.userId = userId;
		this.offerPrice = offerPrice;
		this.curMaxPrice = curMaxPrice;
		this.firstId = firstId;
	}

	public int getAuctionId() {
		return auctionId;
	}
	public void setAuctionId(int auctionId) {
		this.auctionId = auctionId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public int getOfferPrice() {
		return offerPrice;
	}
	public void setOfferPrice(int offerPrice) {
		this.offerPrice = offerPrice;
	} 
	
	
	

}

