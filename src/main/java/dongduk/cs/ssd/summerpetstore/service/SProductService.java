package dongduk.cs.ssd.summerpetstore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dongduk.cs.ssd.summerpetstore.dao.SProductDAO;
import dongduk.cs.ssd.summerpetstore.model.ItemModel;

@Service
public class SProductService {
	@Autowired
	private SProductDAO spRepository;
	
	@Transactional
	public ItemModel showInfo(int itemId) {
		return spRepository.showInfoSP(itemId);
	}

	public void registerSP(ItemModel im) {
		// TODO Auto-generated method stub
		spRepository.registerSP(im);
	}

	public ItemModel deleteSP(int itemId) {
		// TODO Auto-generated method stub
		return null;
	}

	public ItemModel updateSP(int itemId) {
		// TODO Auto-generated method stub
		return null;
	}
}
