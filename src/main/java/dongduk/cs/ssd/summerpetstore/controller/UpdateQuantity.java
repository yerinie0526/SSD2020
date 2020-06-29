package dongduk.cs.ssd.summerpetstore.controller;

public class UpdateQuantity {
	private int newQuantity;
	private String userId;
	private int itemId;
	
	public UpdateQuantity() {
		
	}

	public UpdateQuantity(int newQuantity, String userId, int itemId) {
		super();
		this.newQuantity = newQuantity;
		this.userId = userId;
		this.itemId = itemId;
	}

	public int getNewQuantity() {
		return newQuantity;
	}

	public void setNewQuantity(int newQuantity) {
		this.newQuantity = newQuantity;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	
	
}
