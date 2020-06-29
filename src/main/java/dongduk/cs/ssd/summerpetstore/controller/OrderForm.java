package dongduk.cs.ssd.summerpetstore.controller;

import java.util.Date;

public class OrderForm {
	private String cardCompany;
	private String cardNum;
	private String cardMonth;
	private String cardYear;
	private String cardCVC;
	private String zip;
	private String name;
	private String address;
	private String phone;
	private Date orderDate;
	private String userId;
	private String totalPrice;
	
	public OrderForm() {
		
	}
	public OrderForm(String cardCompany, String cardNum, String cardMonth, String cardYear, String cardCVC, String zip,
			String name, String address, String phone, Date orderDate, String userId, String totalPrice) {
		super();
		this.cardCompany = cardCompany;
		this.cardNum = cardNum;
		this.cardMonth = cardMonth;
		this.cardYear = cardYear;
		this.cardCVC = cardCVC;
		this.zip = zip;
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.orderDate = orderDate;
		this.userId = userId;
		this.totalPrice = totalPrice;
	}


	public String getZip() {
		return zip;
	}


	public void setZip(String zip) {
		this.zip = zip;
	}


	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(String totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public String getCardCompany() {
		return cardCompany;
	}

	public void setCardCompany(String cardCompany) {
		this.cardCompany = cardCompany;
	}

	public String getCardNum() {
		return cardNum;
	}
	public void setCardNum(String cardNum) {
		this.cardNum = cardNum;
	}
	public String getCardMonth() {
		return cardMonth;
	}
	public void setCardMonth(String cardMonth) {
		this.cardMonth = cardMonth;
	}
	public String getCardYear() {
		return cardYear;
	}
	public void setCardYear(String cardYear) {
		this.cardYear = cardYear;
	}
	public String getCardCVC() {
		return cardCVC;
	}
	public void setCardCVC(String cardCVC) {
		this.cardCVC = cardCVC;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
}
