package com.xworkz.vaccine.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.xworkz.vaccine.service.WellcomeService;

@Component
@RequestMapping("/")
public class WellcomeController {
	@Autowired
	private WellcomeService service;

	public WellcomeController() {
		System.out.println(this.getClass().getSimpleName() + "Bean is created");
	}

	@RequestMapping("/wellcome.data")
	public String onSendOTPClicked(@RequestParam String email, Model model) {
		System.out.println("Invoked onSendOTPClicked");
		boolean valid = service.validateEmail(email);
		if (valid) {
			boolean verifyEmail = service.checkIsExistingEmail(email);
			if (verifyEmail) {
				System.out.println("Valid Email!....");
			} else {
				System.out.println("This Email is Already Exists!...Try Another Email!...");
				model.addAttribute("message", "Invalid Email !.");
				return "/WellcomePage.jsp";
			}
			int otp = service.getFourDigitOTP();
			System.out.println("OTP is generated Successfully!...." );
			if (otp != 0) {
				System.out.println("OTP saved in database");
				boolean isOtpSaved = service.saveOTPToDB(email, otp);
				if (isOtpSaved) {
					System.out.println("Otp send to EMail");
					boolean isEmailSendToUser = service.sendOTPToUserEmail(email, otp);
					if (isEmailSendToUser) {
						System.out.println("Email is send to User");
						return "/WEB-INF/otp.jsp";
					} else {
						return "/WellcomePage.jsp";
					}
				} else {
					System.out.println("Otp is not send to EMail");
				}
			} else {
				System.out.println("OTP is not saved in database");
			}
		} else {
			System.out.println("EMail is not Valid");
			return "/WellcomePage.jsp";
		}

		return "/WellcomePage.jsp";
	}
}
