package com.tap.vaccine.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="member")
public class AddMemberEntity implements java.io.Serializable {
	
	@Id
	@Column(name="MEMBER_ID")
	private int memberID;
	
	@Column(name="MEMBER_NAME")
	private String memberName;
	
	@Column(name="MEMBER_GENDER")
	private String memberGender;
	
	@Column(name="MEMBER_DOB")
	private String memberDOB;
	
	@Column(name="ID_PROOF")
	private String idProof;
	
	@Column(name="ID_PROOF_NO")
	private String idProofNO;
	
	@Column(name="VACCINE_TYPE")
	private String vaccineType;
	
	@Column(name="DOSE")
	private String dose;
	
	@Column(name="USER_EMAIL")
	private String email;
	
	public AddMemberEntity() {
		super();
	}

	public AddMemberEntity(int memberID, String memberName, String memberGender, String memberDOB, String idProof,
			String idProofNO, String vaccineType, String dose, String email) {
		this.memberID = memberID;
		this.memberName = memberName;
		this.memberGender = memberGender;
		this.memberDOB = memberDOB;
		this.idProof = idProof;
		this.idProofNO = idProofNO;
		this.vaccineType = vaccineType;
		this.dose = dose;
		this.email = email;
	}

	public AddMemberEntity(int memberID,String memberName, String memberGender, String memberDOB, String idProof,
			String idProofNO, String vaccineType, String dose) {
		this.memberID = memberID;
		this.memberName = memberName;
		this.memberGender = memberGender;
		this.memberDOB = memberDOB;
		this.idProof = idProof;
		this.idProofNO = idProofNO;
		this.vaccineType = vaccineType;
		this.dose = dose;
	}
	public AddMemberEntity(String memberName, String memberGender, String memberDOB, String idProof, String idProofNO,
			String vaccineType, String dose, String email) {
		this.memberName = memberName;
		this.memberGender = memberGender;
		this.memberDOB = memberDOB;
		this.idProof = idProof;
		this.idProofNO = idProofNO;
		this.vaccineType = vaccineType;
		this.dose = dose;
		this.email = email;
	}

	public int getMemberID() {
		return memberID;
	}

	public void setMemberID(int memberID) {
		this.memberID = memberID;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getMemberGender() {
		return memberGender;
	}

	public void setMemberGender(String memberGender) {
		this.memberGender = memberGender;
	}

	public String getMemberDOB() {
		return memberDOB;
	}

	public void setMemberDOB(String memberDOB) {
		this.memberDOB = memberDOB;
	}

	public String getIdProof() {
		return idProof;
	}

	public void setIdProof(String idProof) {
		this.idProof = idProof;
	}

	public String getIdProofNO() {
		return idProofNO;
	}

	public void setIdProofNO(String idProofNO) {
		this.idProofNO = idProofNO;
	}

	public String getVaccineType() {
		return vaccineType;
	}

	public void setVaccineType(String vaccineType) {
		this.vaccineType = vaccineType;
	}

	public String getDose() {
		return dose;
	}

	public void setDose(String dose) {
		this.dose = dose;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
