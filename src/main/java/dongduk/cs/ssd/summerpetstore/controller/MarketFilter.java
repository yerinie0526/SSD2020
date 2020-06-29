package dongduk.cs.ssd.summerpetstore.controller;

import java.io.Serializable;

@SuppressWarnings("serial")
public class MarketFilter implements Serializable {
	private String cname;
	private String itemKind;
	private String keyword;
	
	public MarketFilter() {
		
	}
	
	public MarketFilter(String cname, String itemKind, String keyword) {
		super();
		this.cname = cname;
		this.itemKind = itemKind;
		this.keyword = keyword;
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
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	
	
}
