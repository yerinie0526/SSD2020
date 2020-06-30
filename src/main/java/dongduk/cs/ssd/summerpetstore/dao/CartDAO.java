package dongduk.cs.ssd.summerpetstore.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import dongduk.cs.ssd.summerpetstore.controller.OrderForm;
import dongduk.cs.ssd.summerpetstore.controller.UpdateQuantity;
import dongduk.cs.ssd.summerpetstore.dao.repository.mapper.CartMapper;
import dongduk.cs.ssd.summerpetstore.model.GpModel;
import dongduk.cs.ssd.summerpetstore.model.ItemModel;
import dongduk.cs.ssd.summerpetstore.model.CartModel;
@Repository
public class CartDAO {
	
	@Autowired
	private CartMapper cmapper;
	
	public List<CartModel> showCartList(String userId){
		return cmapper.showCartList(userId);
	}
	
	public void createOrder(OrderForm orderForm) {
		cmapper.createOrder(orderForm);
	}
	public void deleteCartByUser(OrderForm orderForm) {
		cmapper.deleteCartByUser(orderForm);
	}
	
	public void updateQuantity(UpdateQuantity newQuantity) {
		cmapper.updateQuantity(newQuantity);
	}
	
//	private String namespace = "summerpetstore.repository.mapper.CartMapper";
//	private SqlSessionFactory sqlSessionFactory = createSqlSessionFactory();
//	private SqlSessionFactory createSqlSessionFactory() {
//		String resource = "mybatis-config.xml";
//		InputStream inputStream;
//		try {
//			inputStream = Resources.getResourceAsStream(resource);
//		} catch (IOException e) {
//			throw new IllegalArgumentException(e);
//		}
//		return new SqlSessionFactoryBuilder().build(inputStream);
//	}
//	
//	
//
//	public int deleteCart(String userId, int itemId) {
//		SqlSession sqlSession = sqlSessionFactory.openSession();
//		try {
//			int result = sqlSession.delete(namespace + ".deleteCart", itemId);
//			if(result > 0) { sqlSession.commit(); }
//			return result;
//		}finally { sqlSession.close(); }
//	}
//	
//
//	public int deleteCartByUser(String userId) {
//		SqlSession sqlSession = sqlSessionFactory.openSession();
//		try {
//			int result = sqlSession.delete(namespace + ".deleteCartByUser",userId);
//			if(result > 0) { sqlSession.commit(); }
//			return result;
//		}finally { sqlSession.close(); }
//	}
//	
//	
//
//	public int order(String userId, int orderId){
//		SqlSession sqlSession = sqlSessionFactory.openSession();
//		try {
//			int result = sqlSession.delete(namespace + ".cancelGp", userId); 
//			if(result > 0) { sqlSession.commit(); }
//			return result;
//		}finally { sqlSession.close(); }
//	}
//	
//
	public void addCart(String userId, int itemId) {
		if(cmapper.countItemId(userId, itemId) > 0) {
			int q = cmapper.getQuantity(itemId, userId);
			ItemModel im = cmapper.findItembyitemId(itemId);
			if(im.getStock() < q) {
				cmapper.updateInStock(0, itemId, userId);
			}
			cmapper.incrementQuantity(userId, itemId);
		}
		else {
			ItemModel im = cmapper.findItembyitemId(itemId);
			int inStock;
			int quantity = 1;
			if(im.getStock() >= quantity) {
				inStock = 1;
			}else {
				inStock = 0;
			}
			cmapper.addCart(itemId, im.getName(), im.getPrice(), inStock, quantity, userId);
		}
	}
	
	public void deleteCart(String userId, int itemId) {
		cmapper.deleteCart(userId, itemId);
	}
//	
//	
//
//	public int getItemCount(int itemId, String userId) {
//		SqlSession sqlSession = sqlSessionFactory.openSession();
//		try {
//			int result = sqlSession.selectOne(namespace + ".containsItemId", userId); 
//			return result;
//		}finally { sqlSession.close(); }
//	}
//	
//	//quantity + 1
//	public void incrementQuantityByItemId(int itemId, String userId) {
//		SqlSession sqlSession = sqlSessionFactory.openSession();
//		try {
//			sqlSession.update(namespace + ".incrementQuantityByItemId", userId); 
//		}finally { sqlSession.close(); }
//	}
	
	
}
