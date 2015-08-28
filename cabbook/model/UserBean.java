package com.verizon.cabbook.model;

public class UserBean {

	String vzId;
	String emerContact;
	public String getEmerContact() {
		return emerContact;
	}
	public void setEmerContact(String emerContact) {
		this.emerContact = emerContact;
	}
	public String getStrGender() {
		return strGender;
	}
	public void setStrGender(String strGender) {
		this.strGender = strGender;
	}
	String strGender;
	public String getVzId() {
		return vzId;
	}
	public void setVzId(String vzId) {
		this.vzId = vzId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getManagerName() {
		return managerName;
	}
	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}
	public String getStrAddress() {
		return strAddress;
	}
	
	int userId;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public void setStrAddress(String strAddress) {
		this.strAddress = strAddress;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}
	String userName;
	String managerName;
	String strAddress;
	String location;
	String mobileNumber;
	String deviceId;
	
}
