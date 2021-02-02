package com.min.edu.model.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import com.min.edu.dto.MemberDto;

@Repository
public class DaoMemberImpl implements IDaoMember {

	private final String NS = "com.min.edu.model.dao.IDaoMember.";
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public List<MemberDto> memList() {
		List<MemberDto> lists = sqlSession.selectList(NS+"memberList");
		logger.info("===== Dao memList 실행 =====");
		return lists;
	}

	@Override
	public boolean signUpMember(MemberDto dto) {
		String enPassword = passwordEncoder.encode(dto.getPw());
		dto.setPw(enPassword);
		int cnt = sqlSession.insert(NS+"signUpMember", dto);
		logger.info("===== Dao signUpMember 실행 =====");
		return (cnt>0)?true:false;
	}

	@Override
	public boolean idDuplicateCheck(String id) {
		int cnt = sqlSession.selectOne(NS+"idDuplicateCheck", id);
		logger.info("===== Dao idDuplicateCheck 실행 =====");
		return (cnt>0)?true:false;
	}

	@Override
	public MemberDto loginMember(Map<String, Object> map) {
		MemberDto dto = null;
		String dbPw = sqlSession.selectOne(NS+"selStringPw", map.get("id"));
		
		if(passwordEncoder.matches((String)map.get("pw"), dbPw)) {
			dto = sqlSession.selectOne(NS+"enLogin", map);
		}
		
		logger.info("===== Dao loginMember 실행 =====");
		return dto;
	}

}
