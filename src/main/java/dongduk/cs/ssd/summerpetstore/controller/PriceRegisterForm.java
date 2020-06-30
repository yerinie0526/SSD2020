package dongduk.cs.ssd.summerpetstore.controller;

public class PriceRegisterForm {
	
	private String userId;
	private int bidPrice;
	
	public PriceRegisterForm() {
		
	}
	public PriceRegisterForm(String userId, int bidPrice) {
		super();
		this.userId = userId;
		this.bidPrice = bidPrice;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public int getBidPrice() {
		return bidPrice;
	}
	public void setBidPrice(int bidPrice) {
		this.bidPrice = bidPrice;
	}
	
	

}
