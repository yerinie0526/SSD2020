package dongduk.cs.ssd.summerpetstore.controller;

import java.io.Serializable;

@SuppressWarnings("serial")
public class MarketForm implements Serializable{
	private int itemId;
	private String cname;
	private String itemKind;
	private String pMethod;
	private String description;
	private String name;
	private int price;
	
	public MarketForm() {
		
	}

	public MarketForm(int itemId, String cname, String itemKind, String pMethod, String description, String name, int price) {
		super();
		this.itemId = itemId;
		this.cname = cname;
		this.itemKind = itemKind;
		this.pMethod = pMethod;
		this.description = description;
		this.name = name;
		this.price = price;
	}


	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getItemKind() {
		return itemKind;
	}

	public void setItemKind(String itemKind) {
		this.itemKind = itemKind;
	}

	public String getpMethod() {
		return pMethod;
	}

	public void setpMethod(String pMethod) {
		this.pMethod = pMethod;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

			
}
