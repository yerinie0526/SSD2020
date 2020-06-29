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
	
	public UserModel getUser(String username) throws DataAccessException {
		return umapper.getUserByUsername(username);
	}

	public UserModel getUser(String username, String password) throws DataAccessException {
		return umapper.getUserByUsernameAndPassword(username, password);
	}
	
	public UserModel getUserById(String userId, String password) throws DataAccessException {
		return umapper.getUserById(userId, password);
	}

	public void insertUser(UserModel account) throws DataAccessException {
		umapper.insertUser(account);
		//umapper.insertProfile(account);
		//umapper.insertSignon(account);
	}

	public void updateUser(UserModel account) throws DataAccessException {
		umapper.updateUser(account);
		//umapper.updateProfile(account);
		if (account.getPassword() != null && account.getPassword().length() > 0) 
		{
			umapper.updateSignon(account);
		}
	}
 
	public List<String> getUsernameList() throws DataAccessException {
		return umapper.getUsernameList();
	}

}
