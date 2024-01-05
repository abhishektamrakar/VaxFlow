package com.tap.vaccine.dao;

import java.util.List;

import com.tap.vaccine.entity.AddMemberEntity;
import com.tap.vaccine.entity.RegisterEntity;

public interface AddMemberDAO {

	boolean saveAddMemberEntity(AddMemberEntity entity);

	int getMemberCount(String email);

	int updateMemberCount(String email, int memberCount) throws Exception;

	List<AddMemberEntity> viewAllMemberDetails(String userEmail);

	AddMemberEntity getAddMemberEntityById(int id);

	boolean updateAddMemberEntity(AddMemberEntity entity);

	boolean deleteAddMemberEntity(String idProofNo) throws Exception;

	int decreaseMemberCount(String email, int memberCount);
}
