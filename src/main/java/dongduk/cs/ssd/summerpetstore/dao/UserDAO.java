package dongduk.cs.ssd.summerpetstore.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import dongduk.cs.ssd.summerpetstore.dao.repository.mapper.UserMapper;
import dongduk.cs.ssd.summerpetstore.model.UserModel;

@Repository
public class UserDAO {
	
	@Autowired
	private UserMapper umapper;
	
	public UserModel getUser(String userId) throws DataAccessException {
		return umapper.getUserByUsername(userId);
	}

	public UserModel getUser(String username, String password) throws DataAccessException {
		return umapper.getUserByUsernameAndPassword(username, password);
	}
	
	public UserModel getUserById(String userId, String password) throws DataAccessException {
		return umapper.getUserById(userId, password);
	}

	public void insertUser(UserModel account) throws DataAccessException {
		umapper.insertUser(account);
		
	}

	public void updateUser(UserModel account) throws DataAccessException {
		umapper.updateUser(account);
	
	}
 
	public List<String> getUsernameList() throws DataAccessException {
		return umapper.getUsernameList();
	}
	
	public void deleteUser(String userId) {
		umapper.deleteUser(userId);
	}

	public String getUserIdtoPw(String userId) {
		return umapper.getUserIdtoPw(userId);
	}
}
