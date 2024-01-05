package com.tap.vaccine.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.tap.vaccine.entity.AddMemberEntity;
import com.tap.vaccine.service.AddMemberService;

@Controller
public class AddMemberController {
	
	private AddMemberService addMemberService;
	@Autowired
	public AddMemberController(AddMemberService addMemberService) {
		this.addMemberService = addMemberService;
	}
	
	@RequestMapping(value="/addMemberPage")
	public String getAddMemberPage() 
	{
		return "/WEB-INF/addMember.jsp";
	}
	
	@RequestMapping(value="/getAddMemberData")
	public String getAddMemberDataRequestHandler(HttpServletRequest request, @RequestParam String name,@RequestParam String gender, @RequestParam String dateOfBirth,
			@RequestParam String idProof, @RequestParam String idProofNo, @RequestParam String vaccineType, @RequestParam String dose, Model model) throws Exception
	{
		System.out.println("Invoked getAddMemberDataRequestHandler()");
		HttpSession session = request.getSession();
        String email = (String) session.getAttribute("Email");
		System.out.println(email);
		if(addMemberService.checkMemberCount(email)) {
			if(!addMemberService.validateName(name)) {
				model.addAttribute("name","name should contain only alphabets");
			}
			if(!addMemberService.validateGender(gender)) {
				model.addAttribute("gender", "select your gender");
			}
			if(!addMemberService.validateDateofBirth(dateOfBirth)) {
				model.addAttribute("dateOfBirth", "select your date of birth");
			}
			if(!addMemberService.validateIdProof(idProof)) {
				model.addAttribute("idProof", "select an Id Proof");
			}
			if(!addMemberService.validateIdProofNo(idProof, idProofNo)) {
				model.addAttribute("idProofNo", "please enter correct Id Proof No.");
			}
			if(!addMemberService.validateVaccineType(vaccineType)) {
				model.addAttribute("vaccineType", "select a vaccine type");
			}
			if(!addMemberService.validateDose(dose)) {
				model.addAttribute("dose", "select a dose");
			}
			if(addMemberService.validateAddMemberData(name, gender, dateOfBirth, idProof, idProofNo, vaccineType, dose)) {
				if(addMemberService.saveAddMemberEntity(name, gender, dateOfBirth, idProof, idProofNo, vaccineType, dose, email)) {
					int memberCount = addMemberService.getMemberCount(email);
					addMemberService.updateMemberCount(email, memberCount);
					model.addAttribute("yes", "Member added Succesfully..");
					return "/WEB-INF/addMember.jsp";
				}else {
					model.addAttribute("no", "Something went wrong..");
					return "/WEB-INF/addMember.jsp";
				}
			}else {
				model.addAttribute("no", "Invalid Data...");
				return "/WEB-INF/addMember.jsp";
			}
		}else {
			model.addAttribute("no", "You have exceeded the maximum Add Members limit");
			return "/WEB-INF/addMember.jsp";
		}
	}
	
	@RequestMapping(value="/viewMemberDetails")
	public String viewMemberDetailsRequestHandler(HttpServletRequest request, Model model) 
	{
		System.out.println("Invoked viewMemberDetailsRequestHandler()");
		HttpSession session = request.getSession();
        String userEmail = (String) session.getAttribute("Email");
		System.out.println(userEmail);
		List<AddMemberEntity> resultList = addMemberService.viewMemberDetails(userEmail);
		if(resultList!=null) {
	        model.addAttribute("members", resultList);
	        return "/WEB-INF/addMember.jsp";
		}else {
			model.addAttribute("no1", "No Members are added");
		}
		return "/WEB-INF/addMember.jsp";	
	}
	
	@RequestMapping(value="/editMemberDetails/{id}")
	public String editMemberDetailsRequestHandler(@PathVariable int id, Model model)
	{
		System.out.println("Invoked editMemberDetailsRequestHandler()");
		AddMemberEntity entity = addMemberService.getAddMemberEntityById(id);
		model.addAttribute("ID", entity.getMemberID());
		model.addAttribute("NAME",entity.getMemberName());
		model.addAttribute("GENDER", entity.getMemberGender());
		model.addAttribute("DATE_OF_BIRTH", entity.getMemberDOB());
		model.addAttribute("ID_PROOF", entity.getIdProof());
		model.addAttribute("ID_PROOF_NO", entity.getIdProofNO());
		model.addAttribute("VACCINE_TYPE", entity.getVaccineType());
		model.addAttribute("DOSE", entity.getDose());
		
		return "/WEB-INF/addMemberEdit.jsp";	
	}
	
	
	@RequestMapping(value="/updateById/{id}")
	public String updateMemberDetailsRequestHandler(HttpServletRequest request,@PathVariable int id, @RequestParam String name,@RequestParam String gender, @RequestParam String dateOfBirth,
			@RequestParam String idProof, @RequestParam String idProofNo, @RequestParam String vaccineType, @RequestParam String dose, Model model) throws Exception
	{
		System.out.println("Invoked updateMemberDetailsRequestHandler()");
		if(!addMemberService.validateName(name)) {
			model.addAttribute("name","name should contain only alphabets");
		}
		if(!addMemberService.validateGender(gender)) {
			model.addAttribute("gender", "select your gender");
		}
		if(!addMemberService.validateDateofBirth(dateOfBirth)) {
			model.addAttribute("dateOfBirth", "select your date of birth");
		}
		if(!addMemberService.validateIdProof(idProof)) {
			model.addAttribute("idProof", "select an Id Proof");
		}
		if(!addMemberService.validateIdProofNo(idProof, idProofNo)) {
			model.addAttribute("idProofNo", "please enter correct Id Proof No.");
		}
		if(!addMemberService.validateVaccineType(vaccineType)) {
			model.addAttribute("vaccineType", "select a vaccine type");
		}
		if(!addMemberService.validateDose(dose)) {
			model.addAttribute("dose", "select a dose");
		}
		HttpSession session = request.getSession();
        String userEmail = (String) session.getAttribute("Email");
		if(addMemberService.validateAddMemberData(name, gender, dateOfBirth, idProof, idProofNo, vaccineType, dose)) {
			if(addMemberService.updateAddMemberData(id, name, gender, dateOfBirth, idProof, idProofNo, vaccineType, dose, userEmail)) {
				return "redirect:/viewMemberDetails";
            } else {
                model.addAttribute("no2", "Update failed. Please try again.");
                return "/WEB-INF/addMember.jsp";
            }
		}else {
			model.addAttribute("no", "Invalid Data...");
			return "/WEB-INF/addMember.jsp";
		}	
	}
	
	@RequestMapping(value="/deleteMemberByIdProofNo/{idProofNo}")
	public String deleteAddMemberRequestHandler(HttpServletRequest request,@PathVariable String idProofNo, Model model) throws Exception
	{
		System.out.println("Invoked deleteAddMemberRequestHandler()");
		if(addMemberService.deleteAddMemberEntity(idProofNo)) {
			HttpSession session = request.getSession();
	        String userEmail = (String) session.getAttribute("Email");
	        int memberCount = addMemberService.getMemberCount(userEmail);
			addMemberService.decreaseMemberCount(userEmail,memberCount);
				return "redirect:/viewMemberDetails";
		}else {
			model.addAttribute("no3", "delete failed. Please try again.");
		}
		return "/WEB-INF/addMember.jsp";
	}
}
