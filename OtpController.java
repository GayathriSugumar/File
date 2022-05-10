package com.xworkz.vaccine.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.xworkz.vaccine.service.OtpService;

@Component
@RequestMapping("/")
public class OtpController {
	@Autowired
	private OtpService otpService;

	public OtpController() {
		System.out.println(this.getClass().getSimpleName() + "Bean is created");
	}

	@RequestMapping("/OTP.data")
	public String onVerifyButtonClicked(@RequestParam int otp,Model model) {
		System.out.println("Invoked onVerifyButtonClicked");
		boolean valid = otpService.validateOTP(otp);
		if (valid) {
			boolean verify = otpService.verifyOTP(otp);
			if (verify) {
				System.out.println("Verification is Done!....");
			return "/WEB-INF/VaccineHomePage.jsp";
		} else {
			System.out.println("Verification is Invalid!....");
			model.addAttribute("message", "Invalid OTP");
			return "/WEB-INF/otp.jsp";
		}

	}
		return "/WEB-INF/otp.jsp";

	}
}
