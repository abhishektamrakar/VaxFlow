package com.tap.vaccine.dao;

import com.tap.vaccine.entity.RegisterEntity;

public interface RegisterDAO {

	boolean saveRegisterEntity(RegisterEntity entity) throws Exception;
}
