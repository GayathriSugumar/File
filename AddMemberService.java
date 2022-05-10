package com.xworkz.vaccine.service;

import java.util.List;

import com.xworkz.vaccine.dto.AddMemberDTO;

public interface AddMemberService {
	public boolean validateAddMemberDTO(AddMemberDTO dto);

	public boolean saveAddMemberDTO(AddMemberDTO addMemberDTO);
	
	public List<Object> getAllAddMemberDTO();
}
