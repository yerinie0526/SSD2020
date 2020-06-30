package dongduk.cs.ssd.summerpetstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import dongduk.cs.ssd.summerpetstore.service.AuctionService;

@Controller
public class MoveToSucController {
	@Autowired
	private AuctionService auctionservice;
	
	
	public void setAuctionService(AuctionService auctionservice) {
		this.auctionservice = auctionservice;
	}
	
}
