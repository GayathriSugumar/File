package com.xworkz.vaccine.service;

public interface WellcomeService{
	public boolean validateEmail(String email);
	
	public int getFourDigitOTP();
	
	public boolean saveOTPToDB(String email,int otp);
	
	public boolean sendOTPToUserEmail(String email,int otp);
	
	public boolean checkIsExistingEmail(String email);
	

}
