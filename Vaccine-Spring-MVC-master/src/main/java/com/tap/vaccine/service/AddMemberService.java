package com.tap.vaccine.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

import com.tap.vaccine.controller.LoginController;
import com.tap.vaccine.dao.AddMemberDAO;
import com.tap.vaccine.entity.AddMemberEntity;
import com.tap.vaccine.entity.RegisterEntity;

@Component
public class AddMemberService {
	
	private AddMemberDAO addMemberDAO;
	
	@Autowired
	public AddMemberService(AddMemberDAO addMemberDAO) {
		this.addMemberDAO = addMemberDAO;
	}

	//total Validation
	public boolean validateAddMemberData(String name,String gender,String dateOfBirth,String idProof,String idProofNo,
										 String vaccineType, String dose)
	{
		boolean flag = true;
		if(name=="" || name.isBlank() || name.isEmpty()){
			flag = false;
			System.out.println("Invalid name");
		}
		if(gender=="" || gender.isBlank() || gender.isEmpty()){
			flag = false;
			System.out.println("Invalid Gender");
		}
		if(dateOfBirth==" " || dateOfBirth.isBlank() || dateOfBirth.isEmpty()) {
			flag = false;
			System.out.println("Invalid Date of Birth");
		}
		if(idProof==" " || idProof.isBlank() || idProof.isEmpty()) {
			flag = false;
			System.out.println("Invalid Id Proof");
		}
		if(idProofNo=="" || idProofNo.isBlank() || idProofNo.isEmpty()){
			flag = false;
		}
		else {
			if(idProof.equals("aadharCard")) {
				if(idProofNo.length()!=12) {
					flag = false;
					System.out.println("Invalid Aadhar Number");
				}
			}
			if(idProof.equals("panCard")) {
				if(idProofNo.length()!=10) {
					flag = false;
					System.out.println("Invalid Pan Card Number");
				}
			}
			if(idProof.equals("drivingLicense")) {
				if(idProofNo.length()!=15) {
					flag = false;
					System.out.println("Invalid Driving License");
				}
			}
			if(idProof.equals("voterId")) {
				if(idProofNo.length()!=10) {
					flag = false;
					System.out.println("Invalid Voter Id");
				}
			}
		}
		if(vaccineType=="" || vaccineType.isBlank() || vaccineType.isEmpty()) {
			flag = false;
			System.out.println("Invalid Vaccine Type");
		}
		if(dose=="" || dose.isBlank() || dose.isEmpty()) {
			flag = false;
			System.out.println("Invalid Dose");
		}
		return flag;
	}
	
	//single Validations
	public boolean validateName(String name) {
		boolean flag = true;
		if(name=="" || name.isBlank() || name.isEmpty()){
			flag = false;
			System.out.println("Invalid name");
		}
		return flag;
	}
	public boolean validateGender(String gender) {
		boolean flag =  true;
		if(gender=="" || gender.isBlank() || gender.isEmpty()){
			flag = false;
			System.out.println("Invalid Gender");
		}
		return flag;
	}
	public boolean validateDateofBirth(String dateOfBirth) {
		boolean flag = true;
		if(dateOfBirth==" " || dateOfBirth.isBlank() || dateOfBirth.isEmpty()) {
			flag = false;
			System.out.println("Invalid Date of Birth");
		}
		return flag;
	}
	public boolean validateIdProof(String idProof) {
		boolean flag = true;
		if(idProof==" " || idProof.isBlank() || idProof.isEmpty()) {
			flag = false;
			System.out.println("Invalid Id Proof");
		}
		return flag;
	}
	public boolean validateIdProofNo(String idProof, String idProofNo) {
		boolean flag = true;
		if(idProofNo=="" || idProofNo.isBlank() || idProofNo.isEmpty()){
			flag = false;
		}
		else {
			if(idProof.equals("aadharCard")) {
				if(idProofNo.length()!=12) {
					flag = false;
					System.out.println("Invalid Aadhar Number");
				}
			}
			if(idProof.equals("panCard")) {
				if(idProofNo.length()!=10) {
					flag = false;
					System.out.println("Invalid Pan Card Number");
				}
			}
			if(idProof.equals("drivingLicense")) {
				if(idProofNo.length()!=15) {
					flag = false;
					System.out.println("Invalid Driving License");
				}
			}
			if(idProof.equals("voterId")) {
				if(idProofNo.length()!=10) {
					flag = false;
					System.out.println("Invalid Voter Id");
				}
			}
		}
		return flag;
	}
	public boolean validateVaccineType(String vaccineType) {
		boolean flag = true;
		if(vaccineType=="" || vaccineType.isBlank() || vaccineType.isEmpty()) {
			flag = false;
			System.out.println("Invalid Vaccine Type");
		}
		return flag;
	}
	public boolean validateDose(String dose) {
		boolean flag = true;
		if(dose=="" || dose.isBlank() || dose.isEmpty()) {
			flag = false;
			System.out.println("Invalid Dose");
		}
		return flag;
	}
	
	//DAO
	public boolean saveAddMemberEntity(String name,String gender,String dateOfBirth,String idProof,String idProofNo,
										 String vaccineType, String dose, String email)
	{
		AddMemberEntity entity = new AddMemberEntity(name,gender,dateOfBirth,idProof,idProofNo,vaccineType,dose,email);
		return addMemberDAO.saveAddMemberEntity(entity);
	}
	public int getMemberCount(String email)
	{
		return addMemberDAO.getMemberCount(email);		
	}
	public boolean checkMemberCount(String email) {
		boolean flag = false;
		final int maxMemberCount = 4;
		int memberCount = addMemberDAO.getMemberCount(email);
		if(memberCount<maxMemberCount)
		{
			flag = true;
		}
		return flag;		
	}

	public int updateMemberCount(String email, int memberCount) throws Exception {
		return addMemberDAO.updateMemberCount(email, memberCount);
	}

	public List<AddMemberEntity> viewMemberDetails(String userEmail)
	{
		if(addMemberDAO.viewAllMemberDetails(userEmail).size()==0) {
			return null;
		}else {
			return addMemberDAO.viewAllMemberDetails(userEmail);
		}
	}
	
	public AddMemberEntity getAddMemberEntityById(int id)
	{
		return addMemberDAO.getAddMemberEntityById(id);
	}

	public boolean updateAddMemberData(int id,String name, String gender, String dateOfBirth, String idProof, String idProofNo,
			String vaccineType, String dose, String email) {
		AddMemberEntity entity = new AddMemberEntity(id,name,gender,dateOfBirth,idProof,idProofNo,vaccineType,dose,email);
		return addMemberDAO.updateAddMemberEntity(entity);
	}
	
	public boolean deleteAddMemberEntity(String idProofNo) throws Exception {
		return addMemberDAO.deleteAddMemberEntity(idProofNo);			
	}

	public int decreaseMemberCount(String email, int memberCount) {
		return addMemberDAO.decreaseMemberCount(email, memberCount);
	}
}
