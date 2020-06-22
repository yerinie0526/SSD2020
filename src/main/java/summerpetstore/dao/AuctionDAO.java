package summerpetstore.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;

import summerpetstore.dao.repository.mapper.AuctionMapper;
import summerpetstore.model.AuctionJPModel;
import summerpetstore.model.AuctionModel;

public class AuctionDAO {
	
	@Autowired
	private AuctionMapper amapper;
	
	private String namespace = "summerpetstore.repository.mapper.AuctionMapper";
	private SqlSessionFactory sqlSessionFactory = createSqlSessionFactory();
	private SqlSessionFactory createSqlSessionFactory() {
		String resource = "mybatis-config.xml";
		InputStream inputStream;
		try {
			inputStream = Resources.getResourceAsStream(resource);
		} catch (IOException e) {
			throw new IllegalArgumentException(e);
		}
		return new SqlSessionFactoryBuilder().build(inputStream);
	}
	
	

	public List<AuctionModel> searchAuction(AuctionModel am) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			List<AuctionModel> result = sqlSession.selectList(namespace + ".searchAuction", am);//매개변수 수정해야함
			return result;
		}finally { sqlSession.close(); }
	}
	

	public AuctionModel showInfo(int auctionId) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			AuctionModel result = sqlSession.selectOne(namespace + ".showInfo", auctionId);
			return result;
		}finally { sqlSession.close(); }
	}
	
	

	public List<AuctionJPModel> showJPList(int auctionId){
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			List<AuctionJPModel> result = sqlSession.selectList(namespace + ".showJPList", auctionId);
			return result;
		}finally { sqlSession.close(); }
	}
	

	public int registerAuction(AuctionModel am) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			int result = sqlSession.insert(namespace + ".registerAuction", am); 
			if(result > 0) { sqlSession.commit(); }
			return result;
		}finally { sqlSession.close(); }
		//return GpMapper.searchGp(name, itemKind);
	}
	
	
	public int updateAuction(AuctionModel am) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			int result = sqlSession.update(namespace + ".updateAuction", am); 
			return result;
		}finally { sqlSession.close(); }
	}
	

	public int deleteAuction(int auctionId) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			int result = sqlSession.delete(namespace + ".deleteAuction", am); 
			return result;
		}finally { sqlSession.close(); }
	}
	
	public int bid(AuctionJPModel jpm, AuctionModel am) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			int result = sqlSession.insert(namespace + ".bid", jpm); 
			if(am.getCurMaxPrice() < jpm.getOfferPrice()) {
				int u_result = sqlSession.update(namespace + ".changeFirstId", am);//필히 java형식으로 바꿔줘야함 
			}
			if(result > 0) { sqlSession.commit(); }
			return result;
		}finally { sqlSession.close(); }
		//return GpMapper.searchGp(name, itemKind);
	}
	
	public void updateBid(AuctionJPModel jpm) {
		amapper.updateBid(jpm);
	}
	
//	public int deleteBid(int auctionId, int userId) {
//		SqlSession sqlSession = sqlSessionFactory.openSession();
//		try {
//			int result = sqlSession.delete(namespace + ".deleteBid", auctionId, userId); 
//			return result;
//		}finally { sqlSession.close(); }
//	}
//생각해보니 입찰 취소가 되면 안될 것 같기도함 이유: 가격을 높여놓기만 하고 취소할수도있음	
	
	public int sucBid(AuctionModel am) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			int result = sqlSession.insert(namespace + ".sucBid", am); 
			if(result > 0) { sqlSession.commit(); }
			return result;
		}finally { sqlSession.close(); }
		//return GpMapper.searchGp(name, itemKind);
	}
	
	public int getFirstPrice(int auctionId) {
		return amapper.getFirstPrice(auctionId);
	}
	

}
