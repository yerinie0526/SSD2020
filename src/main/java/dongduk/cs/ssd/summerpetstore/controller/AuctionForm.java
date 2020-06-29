package dongduk.cs.ssd.summerpetstore.controller;

import java.sql.Date;

public class AuctionForm {
	
	private int auctionId;
	private String name;
	private Date deadline;
	private int dday;
	private String description;
	private int minPrice;
	private String cname;


	public AuctionForm() {
		
	}
	
	


	public AuctionForm(int auctionId, String name, Date deadline, int dday, String description, int minPrice,
			String cname) {
		super();
		this.auctionId = auctionId;
		this.name = name;
		this.deadline = deadline;
		this.dday = dday;
		this.description = description;
		this.minPrice = minPrice;
		this.cname = cname;
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


	public Date getDeadline() {
		return deadline;
	}


	public void setDeadline(Date deadline) {
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


	public String getCname() {
		return cname;
	}


	public void setCname(String cname) {
		this.cname = cname;
	}
	
	

}
