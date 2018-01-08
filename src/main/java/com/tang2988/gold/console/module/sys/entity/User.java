package com.tang2988.gold.console.module.sys.entity;

public class User {
	
	public Long userId;
	public String realName;
	public String password;
	public String transactionPwd;
	public String mobilePhone;
	public Integer userStatus;
	public String idcardNo;
	public User() {
	}
	
	

	public Long getUserId() {
		return userId;
	}



	public void setUserId(Long userId) {
		this.userId = userId;
	}



	public String getRealName() {
		return realName;
	}



	public void setRealName(String realName) {
		this.realName = realName;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getTransactionPwd() {
		return transactionPwd;
	}



	public void setTransactionPwd(String transactionPwd) {
		this.transactionPwd = transactionPwd;
	}



	public String getMobilePhone() {
		return mobilePhone;
	}



	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}



	public Integer getUserStatus() {
		return userStatus;
	}



	public void setUserStatus(Integer userStatus) {
		this.userStatus = userStatus;
	}



	public String getIdcardNo() {
		return idcardNo;
	}



	public void setIdcardNo(String idcardNo) {
		this.idcardNo = idcardNo;
	}



	public String toString() {
		return "User [userId=" + userId + ", realName=" + realName
				+ ", password=" + password + ", transactionPwd="
				+ transactionPwd + ", mobilePhone=" + mobilePhone
				+ ", userStatus=" + userStatus + ", idcardNo=" + idcardNo + "]";
	}



	
	
	
	
	 
	

}
