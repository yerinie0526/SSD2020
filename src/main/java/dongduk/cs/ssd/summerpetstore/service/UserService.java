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
	
	public UserModel getUser(String username) {
		return udao.getUser(username);
	}
	
	public UserModel getUserById(String userId, String password) {
		return udao.getUserById(userId, password);
	}

	public UserModel getUser(String username, String password) {
		return udao.getUser(username, password);
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
