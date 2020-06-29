package dongduk.cs.ssd.summerpetstore.model;

import java.io.Serializable;
import java.sql.Date;

public class AuctionModel implements Serializable{
	
	int auctionId;
	String name;
	String deadline;
	int dday;
	String description;
	int minprice;
	String astatus;	
	int sellerInfoId;
	String firstId;
	int currentCon;
	int curMaxPrice;
	String cname;
	
	public AuctionModel() {
		
	}
	public AuctionModel(int auctionId, String name, String deadline, int dday, String description, int minprice,
			String astatus, int sellerInfoId, String firstId, int currentCon, int curMaxPrice, String cname) {
		super();
		this.auctionId = auctionId;
		this.name = name;
		this.deadline = deadline;
		this.dday = dday;
		this.description = description;
		this.minprice = minprice;
		this.astatus = astatus;
		this.sellerInfoId = sellerInfoId;
		this.firstId = firstId;
		this.currentCon = currentCon;
		this.curMaxPrice = curMaxPrice;
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
	public int getMinprice() {
		return minprice;
	}
	public void setMinprice(int minprice) {
		this.minprice = minprice;
	}
	public String getAstatus() {
		return astatus;
	}
	public void setAstatus(String astatus) {
		this.astatus = astatus;
	}
	public int getSellerInfoId() {
		return sellerInfoId;
	}
	public void setSellerInfoId(int sellerInfoId) {
		this.sellerInfoId = sellerInfoId;
	}
	public String getFirstId() {
		return firstId;
	}
	public void setFirstId(String firstId) {
		this.firstId = firstId;
	}
	public int getCurrentCon() {
		return currentCon;
	}
	public void setCurrentCon(int currentCon) {
		this.currentCon = currentCon;
	}
	public int getCurMaxPrice() {
		return curMaxPrice;
	}
	public void setCurMaxPrice(int curMaxPrice) {
		this.curMaxPrice = curMaxPrice;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}

}
