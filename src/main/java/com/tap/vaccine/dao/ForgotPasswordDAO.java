package com.tap.vaccine.dao;

public interface ForgotPasswordDAO {

	boolean resetPasswordByEmail(String email, String password) throws Exception;
}
