package edu.sp5.javacafe.dao;

import edu.sp5.javacafe.domain.CafeMaster;

public interface CafeMasterDao {
	
	public CafeMaster findCafeMaster();
	
	public void update(String masterNumber, String phoneNumber, String passwd);
}
