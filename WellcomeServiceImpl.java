package com.xworkz.vaccine.service;

import java.util.Random;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;

import com.xworkz.vaccine.dao.WellcomeDAO;
import com.xworkz.vaccine.dto.WellcomeDTO;
import com.xworkz.vaccine.entity.UserEntity;
import com.xworkz.vaccine.exception.InvalidEMailException;
@Component
public class WellcomeServiceImpl implements WellcomeService{
    @Autowired
	private WellcomeDAO wellcome;
    
    @Autowired
    private MailSender mailSender;
    
	public WellcomeServiceImpl() {
		System.out.println(this.getClass().getSimpleName() + "Bean is created");
		System.out.println("Invoked WellcomeServiceImpl ");
	}

	public boolean validateEmail(String email)throws InvalidEMailException  {
		System.out.println("Invoked validate Email");
		boolean valid = false;

		if (email!= null && !email.isEmpty() && email.contains(".com")) {
			valid = true;
			System.out.println("EMail is valid");
		} else {
			InvalidEMailException invalidEmail=new InvalidEMailException();
			throw invalidEmail;	
		}
		return valid;
	}

	@Override
	public int getFourDigitOTP() {
		System.out.println("Invoked getFourDigitOTP() ");
		Random random=new Random();
		int otp=random.nextInt(10000);
		if(otp!=0 && otp>=4) {
		System.out.println("OTP :" +otp);
		}else {
			System.out.println("OTP is Invalid");
		}
		return otp;
		
	}

	@Override
	public boolean saveOTPToDB(String email,int otp) {
		System.out.println("Invoked saveOTPToDB()");
		UserEntity userEntity=new UserEntity();
		userEntity.setEmail(email);	
		userEntity.setOTP(otp);
		boolean isOTPSaved=wellcome.saveUserEntity(userEntity);
		return isOTPSaved;
	}

	@Override
	public boolean sendOTPToUserEmail(String email,int otp) {
		System.out.println("Invoked sendOTPToUserEmail()");
		SimpleMailMessage message=new SimpleMailMessage();
		try {
		message.setTo(email);
		message.setSubject("OTP Generated");
		message.setText(email+otp);
		mailSender.send(message);
		System.out.println("Mail sent successfully");
		return true;
		}catch(Exception exception ) {
			System.out.println("Mail not sent successfully");
			exception.printStackTrace();
		}
		return false;
		
	}

	@Override
	public boolean checkIsExistingEmail(String email) {
	System.out.println("Invoked checkIsExistingEmail");
	String EmailFromDB=wellcome.getEmailFromTable(email);
	if (EmailFromDB==email) {
		System.out.println("Email is verified !...");
		return true;
	} else {
		System.out.println("It is Invalid Email!... Already Exists!..");
		return false;
	}
		
	}


			

}
