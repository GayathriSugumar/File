package com.xworkz.vaccine.controller;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@RequestMapping("/")
public class VaccineHomePageController {

	public VaccineHomePageController() {
		System.out.println(this.getClass().getSimpleName() + "Bean is created");
	}
	@RequestMapping("/Vaccine.data")
	public String onClickAddMember() {
		System.out.println("Invoke onClickAddMember");
		
		return "/WEB-INF/AddMember.jsp";
		
	}
	
}
