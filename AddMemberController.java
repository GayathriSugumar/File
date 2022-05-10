package com.xworkz.vaccine.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xworkz.vaccine.dto.AddMemberDTO;
import com.xworkz.vaccine.service.AddMemberService;

@Component
@RequestMapping("/")
public class AddMemberController {
	@Autowired
	private AddMemberService  addMember;

	public AddMemberController() {
		System.out.println(this.getClass().getSimpleName() + "Bean is created");
	}
//	@SuppressWarnings("unused")
	@RequestMapping("/AddMember.data")
	public String onAddMemberButtonClicked(@ModelAttribute AddMemberDTO dto,Model model) {
		System.out.println("Invoked onAddMemberClicked");
		boolean result=addMember.validateAddMemberDTO(dto);
		if (result) {
			boolean isDataSaved=addMember.saveAddMemberDTO(dto);
			if (isDataSaved) {
				model.addAttribute("message", "Data is Saved!...Register Successfully!...");
				System.out.println("AddMember Data saved to Database!....");
				List<Object>addMemberDetails=addMember.getAllAddMemberDTO();
				if (addMemberDetails!=null) {
					model.addAttribute("list", "Data is Saved!...Register Successfully!...");
					return "/WEB-INF/VaccineHomePage.jsp";
				} else {
					return "/WEB-INF/AddMember.jsp";
				}
				
			} else {
				model.addAttribute("message", "Data is not Saved!...Register is Failed!...");
				System.out.println("AddMember Data is not saved to Database!....");
				return "/WEB-INF/AddMember.jsp";
			}
		} else {
			System.out.println("Validation is Failed!...");
		}
		return "/AddMember.jsp";
	}
}
		
		
		
		
		
		
