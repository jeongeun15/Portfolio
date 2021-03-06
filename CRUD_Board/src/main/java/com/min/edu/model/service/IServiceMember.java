package com.min.edu.model.service;

import java.util.List;
import java.util.Map;

import com.min.edu.dto.MemberDto;

public interface IServiceMember {

	public List<MemberDto> memList();
	
	public boolean signUpMember(MemberDto dto);
	
	public boolean idDuplicateCheck(String id);
	
	public MemberDto loginMember(Map<String, Object> map);

}
