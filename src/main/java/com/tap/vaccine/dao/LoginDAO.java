package com.tap.vaccine.dao;

import com.tap.vaccine.entity.RegisterEntity;

public interface LoginDAO {

	RegisterEntity getRegisterEntity(String email);
	
	int updateLoginAttemptCount(String email,int loginAttemptCount)throws Exception;
}
