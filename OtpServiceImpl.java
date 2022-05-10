package com.xworkz.vaccine.service;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xworkz.vaccine.dao.OTPDAO;
import com.xworkz.vaccine.dao.WellcomeDAO;
import com.xworkz.vaccine.exception.InvalidOTPException;
@Component
public class OtpServiceImpl implements OtpService{

	@Autowired
	private OTPDAO otpDAO;
	
	public OtpServiceImpl() {
	System.out.println(this.getClass().getSimpleName() + "Bean is created");
	}
	
	@Override
	public boolean validateOTP(int otp) throws InvalidOTPException{
		System.out.println("Invoked validate OTP");
		boolean valid =false;
		if(otp!=0) {
			valid=true;
			System.out.println("OTP is valid");
		}else {
			InvalidOTPException invalidOTP=new InvalidOTPException();
		    throw invalidOTP;
		}
		return valid;
	}

	@Override
	public boolean verifyOTP(int otp) {
		System.out.println("Invoked verifyOTP");
	   int OTPFromDB=otpDAO.getOTPFromTable(otp);
		if(otp==OTPFromDB) {
			System.out.println("Verify OTP is valid");
			return true;
		}else {
			System.out.println("Verified OTP is Invalid");
			return false;
		}
		
	}

}
