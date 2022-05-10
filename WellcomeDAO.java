package com.xworkz.vaccine.dao;

import com.xworkz.vaccine.entity.UserEntity;

public interface WellcomeDAO {
	
	public boolean saveUserEntity(Object userEntity);
	
	public String getEmailFromTable(String email);
	


}
