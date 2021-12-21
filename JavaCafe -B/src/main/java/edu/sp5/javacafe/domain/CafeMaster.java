package edu.sp5.javacafe.domain;

public class CafeMaster {
	private long masterNumber;
	private String passwd;
	private String phoneNumber;
	
	public CafeMaster() {
		
	}
	
	public CafeMaster(long masterNumber, String passwd, String phoneNumber) {
		super();
		this.masterNumber = masterNumber;
		this.passwd = passwd;
		this.phoneNumber = phoneNumber;
	}
	public long getMasterNumber() {
		return masterNumber;
	}
	public void setMasterNumber(long masterNumber) {
		this.masterNumber = masterNumber;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	
	
}
