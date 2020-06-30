package dongduk.cs.ssd.summerpetstore.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import dongduk.cs.ssd.summerpetstore.dao.repository.mapper.SproductMapper;
import dongduk.cs.ssd.summerpetstore.model.ItemModel;

@Repository
public class SProductDAO {
	
	
	@Autowired
	private SproductMapper smapper;
		
	
	 
	public List<ItemModel> showInfoSP(String cname) throws DataAccessException{
		System.out.println("dao!!!!!!!!!!!!!");
	
		return smapper.showInfoSP(cname);	  
	}
	

	public ItemModel showdetailInfoSP(int itemId) throws DataAccessException{
		System.out.println("dao2222222222!!!!!!!!!!!!!");
	
		return smapper.showdetailInfoSP(itemId);	  
	}

}
