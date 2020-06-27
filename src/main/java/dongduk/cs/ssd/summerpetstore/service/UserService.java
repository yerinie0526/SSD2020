package dongduk.cs.ssd.summerpetstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import dongduk.cs.ssd.summerpetstore.dao.UserDAO;
import dongduk.cs.ssd.summerpetstore.model.UserModel;

@Service
public class UserService {
	
	@Autowired
	private UserDAO udao;
	
	public UserModel getAccount(String username) {
		return udao.getAccount(username);
	}

	public UserModel getAccount(String username, String password) {
		return udao.getAccount(username, password);
	}

	public void insertUser(UserModel account) {
		udao.insertUser(account);
	}

	public void updateUser(UserModel account) {
		udao.updateUser(account);
	}
 
	public List<String> getUsernameList() {
		return udao.getUsernameList();
	}
	
//	UserModel getUserModel(String userId) {
//		
//	}

	public UserModel getUser(String userId, String password) {
		return null;
	}

//	void insertUserModel(UserModel UserModel) {
//		
//	}
//
//	void updateUserModel(UserModel UserModel) {
//		
//	}
//
//	List<String> getUsernameList(){
//		
//	}
}
