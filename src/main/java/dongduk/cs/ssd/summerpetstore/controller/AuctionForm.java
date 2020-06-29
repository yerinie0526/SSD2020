package dongduk.cs.ssd.summerpetstore.controller;

import java.sql.Date;

public class AuctionForm {
	
	private int auctionId;
	private String name;
	private String deadline;
	private int dday;
	private String description;
	private int minPrice;
	private String sellerInfoId;
	private String cname;
	private String firstId;


	public AuctionForm() {
		
	}


	public AuctionForm(int auctionId, String name, String deadline, int dday, String description, int minPrice,
			String sellerInfoId, String cname, String firstId) {
		super();
		this.auctionId = auctionId;
		this.name = name;
		this.deadline = deadline;
		this.dday = dday;
		this.description = description;
		this.minPrice = minPrice;
		this.sellerInfoId = sellerInfoId;
		this.cname = cname;
		this.firstId= firstId;
	}




	public int getAuctionId() {
		return auctionId;
	}


	public void setAuctionId(int auctionId) {
		this.auctionId = auctionId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDeadline() {
		return deadline;
	}


	public void setDeadline(String deadline) {
		this.deadline = deadline;
	}


	public int getDday() {
		return dday;
	}


	public void setDday(int dday) {
		this.dday = dday;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public int getMinPrice() {
		return minPrice;
	}


	public void setMinPrice(int minPrice) {
		this.minPrice = minPrice;
	}
	
	
	public String getSellerInfoId() {
		return sellerInfoId;
	}


	public void setSellerInfoId(String sellerInfoId) {
		this.sellerInfoId = sellerInfoId;
	}


	public String getCname() {
		return cname;
	}


	public void setCname(String cname) {
		this.cname = cname;
	}


	public String getFirstId() {
		return firstId;
	}


	public void setFirstId(String firstId) {
		this.firstId = firstId;
	}
	
	
	
	

}
