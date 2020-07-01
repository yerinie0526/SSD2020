package dongduk.cs.ssd.summerpetstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import dongduk.cs.ssd.summerpetstore.service.SproductService;

@Controller
public class SearhAllProductController {
	@Autowired
	private SproductService sproductService;
	
	public void setSproductService(SproductService sproductService) {
		this.sproductService = sproductService;
	}
	
}
