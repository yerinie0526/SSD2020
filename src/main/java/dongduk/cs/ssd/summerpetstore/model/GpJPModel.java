package dongduk.cs.ssd.summerpetstore.model;

import java.io.Serializable;

public class GpJPModel implements Serializable{
	private String itemId;
	private String userName;
	private int isEnd;
	
	public GpJPModel() {
		
	}

	public GpJPModel(String itemId, String userName, int isEnd) {
		super();
		this.itemId = itemId;
		this.userName = userName;
		this.isEnd = isEnd;
	}

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getIsEnd() {
		return isEnd;
	}
	public void setIsEnd(int isEnd) {
		this.isEnd = isEnd;
	}
}
