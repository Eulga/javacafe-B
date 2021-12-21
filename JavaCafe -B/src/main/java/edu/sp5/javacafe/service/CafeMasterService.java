package edu.sp5.javacafe.service;

import org.springframework.beans.factory.annotation.Autowired;

import edu.sp5.javacafe.dao.derby.CafeMasterDaoDerby;
import edu.sp5.javacafe.domain.CafeMaster;

public class CafeMasterService {
	
	@Autowired
	private CafeMasterDaoDerby cafeMasterDao;
	
	public CafeMaster findCafeMaster() {
		return cafeMasterDao.findCafeMaster();
	}
	
	public void update(String masterNumber, String phoneNumber, String passwd) {
		cafeMasterDao.update(masterNumber, phoneNumber, passwd);
	}
}