package dongduk.cs.ssd.summerpetstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dongduk.cs.ssd.summerpetstore.dao.GpDAO;
import dongduk.cs.ssd.summerpetstore.model.GpModel;

@Service
public class GpService {
	
	@Autowired
	private GpDAO gpRepository;
	
/*
	@Transactional
	public int updateGP(GpModel gp) { 
		return gpRepository.updateGp(gp);
	}
	

	@Transactional
	public int deleteGP(GpModel gp) {
		return gpRepository.deleteGp(gp.getItemId());
	}
	

	@Transactional
	public int cancelGP(GpModel gp) {
		return gpRepository.cancelGp(gp.getItemId());
	}
	

	@Transactional
	public List<GpModel> searchGP(GpModel gp) {
		return gpRepository.searchGp(gp.getItemmodel().getName(), gp.getItemmodel().getItemKind());
	}
	

	@Transactional
	public int participateGP(GpModel gp) {
		return gpRepository.participateGp(gp.getItemmodel().getItemId(), gp.getGpjpmodel().getUserName());
	}
	
	@Transactional
	public boolean is_GPJP_exist(GpModel gp) {
		return gpRepository.is_GPJP_exist(gp.getItemId());
	}
	
	@Transactional
	public int cancelGpJPId(int itemId) {
		return gpRepository.cancelGpJPId(itemId);
	}*/
}
