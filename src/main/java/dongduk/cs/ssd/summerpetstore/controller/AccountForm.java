package dongduk.cs.ssd.summerpetstore.controller;

import java.io.Serializable;

import dongduk.cs.ssd.summerpetstore.model.UserModel;

/**
 * @author Juergen Hoeller
 * @since 01.12.2003
 */
@SuppressWarnings("serial")
public class AccountForm implements Serializable {

	private UserModel account;

	private boolean newAccount;

	private String repeatedPassword;

	public AccountForm(UserModel account) {
		this.account = account;
		this.newAccount = false;
	}

	public AccountForm() {
		this.account = new UserModel();
		this.newAccount = true;
	}

	public UserModel getAccount() {
		return account;
	}

	public boolean isNewAccount() {
		return newAccount;
	}

	public void setRepeatedPassword(String repeatedPassword) {
		this.repeatedPassword = repeatedPassword;
	}

	public String getRepeatedPassword() {
		return repeatedPassword;
	}
}
