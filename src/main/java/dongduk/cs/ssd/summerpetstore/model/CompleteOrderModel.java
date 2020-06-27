package dongduk.cs.ssd.summerpetstore.model;

import java.io.Serializable;

public class CompleteOrderModel implements Serializable{
	
	int itemId;
	String name;
	String status;
	int price;
	int orderId;
	
	public CompleteOrderModel() {
		
	}
	public CompleteOrderModel(int itemId, String name, String status, int price, int orderId) {
		super();
		this.itemId = itemId;
		this.name = name;
		this.status = status;
		this.price = price;
		this.orderId = orderId;
	}
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	
	

}
