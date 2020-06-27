package dongduk.cs.ssd.summerpetstore.model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class ItemModel implements Serializable{
	private int itemId;
	private String istatus;
	private String itemKind;
	private String name;
	private int price;
	private String description;
	private int isGP;
	private String cname;
	public ItemModel() {
		
	}
	
	public ItemModel(int itemId, String istatus, String itemKind, String name, int price, String description, int isGP,
			String cname) {
		super();
		this.itemId = itemId;
		this.istatus = istatus;
		this.itemKind = itemKind;
		this.name = name;
		this.price = price;
		this.description = description;
		this.isGP = isGP;
		this.cname = cname;
	}

	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public String getIstatus() {
		return istatus;
	}
	public void setIstatus(String istatus) {
		this.istatus = istatus;
	}
	public String getItemKind() {
		return itemKind;
	}
	public void setItemKind(String itemKind) {
		this.itemKind = itemKind;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getIsGP() {
		return isGP;
	}
	public void setIsGP(int isGP) {
		this.isGP = isGP;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	
}
