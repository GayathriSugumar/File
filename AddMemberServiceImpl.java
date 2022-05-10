package com.xworkz.vaccine.service;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xworkz.vaccine.dao.AddMemberDAO;
import com.xworkz.vaccine.dto.AddMemberDTO;
import com.xworkz.vaccine.entity.AddMemberEntity;
import com.xworkz.vaccine.exception.AddMemberInvalidException;
import com.xworkz.vaccine.exception.InvalidDOBException;
import com.xworkz.vaccine.exception.InvalidDoseException;
import com.xworkz.vaccine.exception.InvalidGenderException;
import com.xworkz.vaccine.exception.InvalidIDNumberException;
import com.xworkz.vaccine.exception.InvalidNameException;
import com.xworkz.vaccine.exception.InvalidPhotoIdException;
import com.xworkz.vaccine.exception.InvalidVaccineTypeException;
@Component
public class AddMemberServiceImpl implements AddMemberService{
	
	@Autowired
	private AddMemberDAO addMemberDAO;
	
	public AddMemberServiceImpl() {
		System.out.println(this.getClass().getSimpleName() + "Bean is created");
		System.out.println("Invoked AddMemberServiceImpl ");
	}

	@Override
	public boolean validateAddMemberDTO(AddMemberDTO dto) {
		System.out.println("Invoked validateAddMemberDTO");
		boolean valid=false;
		if (dto.getName() !=null && !(dto.getName().isEmpty())) {
			System.out.println("Valid name!...");
			valid=true;
		} else {
			InvalidNameException invalidNameException = new InvalidNameException();
			throw invalidNameException;
		}
		if (dto.getGender()!=null) {
			System.out.println("Gender is valid!...");
		} else {
			InvalidGenderException invalidGenderException = new InvalidGenderException();
			throw invalidGenderException;
		}
		if (dto.getDob()!=0) {
			System.out.println("Valid DOB");
			valid=true;
		} else {
			InvalidDOBException invalidDOBException = new InvalidDOBException();
			throw invalidDOBException;
		}
		if (dto.getPhotoId()!=null) {
			System.out.println("Photo proof is verified");
			valid=true;
		} else {
			InvalidPhotoIdException invalidPhotoIdException = new InvalidPhotoIdException();
			throw invalidPhotoIdException;
		}
		if (dto.getIdNumber()!=null) {
			System.out.println("Id is valid!...");
			valid=true;
		} else {
			InvalidIDNumberException invalidIDNumberException = new InvalidIDNumberException();
			throw invalidIDNumberException;
		}
		if (dto.getVaccineType()!=null) {
			System.out.println("VaccineType is valid!...");
			valid=true;
		} else {
			InvalidVaccineTypeException invalidVaccineTypeException = new InvalidVaccineTypeException();
			throw invalidVaccineTypeException;
		}
		if (dto.getDose()!=0) {
			System.out.println("Dose is valid!...");
			valid=true;
		} else {
			InvalidDoseException invalidDoseException = new InvalidDoseException();
			throw invalidDoseException;
		}
		
		return valid;
	}

	@Override
	public boolean saveAddMemberDTO(AddMemberDTO addMemberDTO) {
		System.out.println("Invoked saveAddMemberDTO");
		AddMemberEntity MemberEntity = new AddMemberEntity();
		BeanUtils.copyProperties(addMemberDTO, MemberEntity);
		boolean isEntitySaved=addMemberDAO.saveAddMemberEntity(MemberEntity);
		return isEntitySaved;
		
	}

	@Override
	public List<Object> getAllAddMemberDTO() {
		System.out.println("Invoked getAllAddMemberDTO");
		List<Object> addMemberDetails=null;
		List<AddMemberEntity> AddMemberEntityDetails=this.addMemberDAO.getAllAddMemberDetails();
		if (AddMemberEntityDetails !=null) {
			return addMemberDetails=new ArrayList<Object>(AddMemberEntityDetails);
		} else {
			System.out.println("Invalid getAllAddMemberDTO()");
		}
		return addMemberDetails;
	}

}

