package summerpetstore.dao.repository;

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
import org.springframework.transaction.annotation.Transactional;

import summerpetstore.dao.MarketDAO;
import summerpetstore.dao.repository.mapper.MarketMapper;
import summerpetstore.model.ItemModel;

@Repository
public class MybatisMarketDao implements MarketDAO{
	
	@Autowired
	protected MarketMapper marketMapper;
	
	/*
	 * @Transactional public void registerItem(ItemModel im) throws
	 * DataAccessException{ SqlSession sqlSession = sqlSessionFactory.openSession();
	 * try { int result = sqlSession.insert(namespace + ".showInfo", im); if(result
	 * > 0) { sqlSession.commit(); } }finally { sqlSession.close(); } }
	 * 
	 * @Transactional public ItemModel showInfo(int itemId)throws
	 * DataAccessException{ SqlSession sqlSession = sqlSessionFactory.openSession();
	 * try { ItemModel result = sqlSession.selectOne(namespace + ".showInfo",
	 * itemId); return result; }finally { sqlSession.close(); } }
	 * 
	 * 
	 * @Transactional public void deleteItem(int itemId) throws DataAccessException{
	 * SqlSession sqlSession = sqlSessionFactory.openSession(); try { int result =
	 * sqlSession.delete(namespace + ".deleteItem", itemId); if(result > 0) {
	 * sqlSession.commit(); } }finally { sqlSession.close(); } }
	 * 
	 * 
	 * @Transactional public void updateItem(ItemModel im) throws
	 * DataAccessException{ SqlSession sqlSession = sqlSessionFactory.openSession();
	 * try { int result = sqlSession.update(namespace + ".updateItem", im);
	 * if(result > 0) { sqlSession.commit(); } }finally { sqlSession.close(); } }
	 * 
	 * 
	 * @Transactional public void updateItemStatus(int itemId) throws
	 * DataAccessException{ SqlSession sqlSession = sqlSessionFactory.openSession();
	 * try { int result = sqlSession.update(namespace + ".updateItemStatus",
	 * itemId); if(result > 0) { sqlSession.commit(); } }finally {
	 * sqlSession.close(); } }
	 * 
	 * @Transactional public List<ItemModel> searchItem(String itemname, String
	 * itemKind) throws DataAccessException{ SqlSession sqlSession =
	 * sqlSessionFactory.openSession(); try { List<ItemModel> result =
	 * sqlSession.selectList(namespace + ".searchMarket", itemname); return result;
	 * }finally { sqlSession.close(); } }
	 */

}
