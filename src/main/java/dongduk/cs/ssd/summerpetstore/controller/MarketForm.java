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

	public MarketForm(String categoryId, String itemKind, String pMethod, String description, String name) {
		super();
		this.categoryId = categoryId;
		this.itemKind = itemKind;
		this.pMethod = pMethod;
		this.description = description;
		this.name = name;
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
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
