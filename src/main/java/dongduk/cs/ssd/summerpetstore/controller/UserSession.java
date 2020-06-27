package dongduk.cs.ssd.summerpetstore.controller;

import java.io.Serializable;

import dongduk.cs.ssd.summerpetstore.model.UserModel;

@SuppressWarnings("serial")
public class UserSession implements Serializable {

	private UserModel usermodel;

//	private PagedListHolder<Product> myList;

	public UserSession(UserModel usermodel) {
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
