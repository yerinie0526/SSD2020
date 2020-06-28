package dongduk.cs.ssd.summerpetstore.controller;

import java.io.Serializable;

import dongduk.cs.ssd.summerpetstore.model.UserModel;

@SuppressWarnings("serial")
public class UserSession implements Serializable {

	private UserModel usermodel;
	private String userId;

//	private PagedListHolder<Product> myList;
	
	public UserSession(UserModel usermodel) {
		this.usermodel = usermodel;
	}
	
	public UserSession(UserModel usermodel, String userId) {
		this.usermodel = usermodel;
		this.userId = userId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public void setUsermodel(UserModel usermodel) {
		this.usermodel = usermodel;
	}

	public UserModel getUserModel() {
		return usermodel;
	}

//	public void setMyList(PagedListHolder<Product> myList) {
//		this.myList = myList;
//	}
//
//	public PagedListHolder<Product> getMyList() {
//		return myList;
//	}
}
