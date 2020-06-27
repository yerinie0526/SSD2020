package dongduk.cs.ssd.summerpetstore.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;

import dongduk.cs.ssd.summerpetstore.dao.repository.mapper.UserMapper;
import dongduk.cs.ssd.summerpetstore.model.UserModel;

public class UserDAO {
	
	@Autowired
	private UserMapper umapper;
	
	public UserModel getAccount(String username) throws DataAccessException {
		return umapper.getUserByUsername(username);
	}

	public UserModel getAccount(String username, String password) 
			throws DataAccessException {
		return umapper.getUserByUsernameAndPassword(username, password);
	}

	public void insertUser(UserModel account) throws DataAccessException {
		umapper.insertUser(account);
		umapper.insertProfile(account);
		umapper.insertSignon(account);
	}

	public void updateUser(UserModel account) throws DataAccessException {
		umapper.updateUser(account);
		umapper.updateProfile(account);
		if (account.getPassword() != null && account.getPassword().length() > 0) 
		{
			umapper.updateSignon(account);
		}
	}
 
	public List<String> getUsernameList() throws DataAccessException {
		return umapper.getUsernameList();
	}

}
