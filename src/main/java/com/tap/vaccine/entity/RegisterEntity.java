package com.tap.vaccine.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="register")
public class RegisterEntity implements java.io.Serializable{

	@Id
	@Column(name="REGISTER_ID")
	private int registerId;
	
	@Column(name="USER_NAME")
	private String userName;
	
	@Column(name="PASSWORD")
	private String password;
	
	@Column(name="EMAIL")
	private String email;
	
	@Column(name="MOBILE_NUMBER")
	private String mobileNumber;
	
	@Column(name="GENDER")
	private String gender;
	
	@Column(name="DATE_OF_BIRTH")
	private String dateOfBirth;
	
	@Column(name="LOGIN_ATTEMPT")
	private int loginAttempt;
	
	@Column(name="MEMBER_COUNT")
	private int memberCount;
	
	public RegisterEntity() {
		super();
	}
	public RegisterEntity(int registerId, String userName, String password,String email,
			String mobileNumber, String gender, String dateOfBirth, int loginAttempt, int memberCount) {
		this.registerId = registerId;
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.mobileNumber = mobileNumber;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
		this.loginAttempt = loginAttempt;
		this.memberCount = memberCount;
	}
	public RegisterEntity(String userName, String password,String email, String mobileNumber,String gender, String dateOfBirth) {
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.mobileNumber = mobileNumber;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
	}
	public int getRegisterId() {
		return registerId;
	}
	public void setRegisterId(int registerId) {
		this.registerId = registerId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public int getLoginAttempt() {
		return loginAttempt;
	}
	public void setLoginAttempt(int loginAttempt) {
		this.loginAttempt = loginAttempt;
	}
	public int getMemberCount() {
		return memberCount;
	}
	public void setMemberCount(int memberCount) {
		this.memberCount = memberCount;
	}
}
