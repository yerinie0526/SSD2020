package dongduk.cs.ssd.summerpetstore.controller;

import java.io.Serializable;

@SuppressWarnings("serial")
public class MarketForm implements Serializable{
	private String categoryId;
	private String itemKind;
	private String pMethod;
	private String description;
	private String name;
	
	public MarketForm() {
		
	}
	
	public MarketForm(int categoryId, int itemKind, int pMethod, String description, String name) {
		super();
		this.categoryId = categoryId;
		this.itemKind = itemKind;
		this.pMethod = pMethod;
		this.description = description;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public int getItemKind() {
		return itemKind;
	}
	public void setItemKind(int itemKind) {
		this.itemKind = itemKind;
	}
	public int getpMethod() {
		return pMethod;
	}
	public void setpMethod(int pMethod) {
		this.pMethod = pMethod;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
		
}
