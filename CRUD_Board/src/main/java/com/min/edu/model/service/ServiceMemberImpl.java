package com.min.edu.model.service;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.min.edu.dto.MemberDto;
import com.min.edu.model.dao.IDaoMember;

@Service
public class ServiceMemberImpl implements IServiceMember {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private IDaoMember dao;
	
	@Override
	public List<MemberDto> memList() {
		logger.info("===== Service memList 실행 =====");
		return dao.memList();
	}

	@Override
	public boolean signUpMember(MemberDto dto) {
		logger.info("===== Service signUpMember 실행 =====");
		return dao.signUpMember(dto);
	}

	@Override
	public boolean idDuplicateCheck(String id) {
		logger.info("===== Service idDuplicateCheck 실행 =====");
		return dao.idDuplicateCheck(id);
	}

	@Override
	public MemberDto loginMember(Map<String, Object> map) {
		logger.info("===== Service loginMember 실행 =====");
		return dao.loginMember(map);
	}

}
