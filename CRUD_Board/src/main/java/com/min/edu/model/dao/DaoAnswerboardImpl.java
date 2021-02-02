package com.min.edu.model.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.min.edu.dto.AnswerboardDto;

@Repository
public class DaoAnswerboardImpl implements IDaoAnswerboard {
	
	private final String NS = "com.min.edu.model.dao.IDaoAnswerboard.";
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private SqlSessionTemplate session;
	
	@Override
	public List<AnswerboardDto> selectDynamic(Map<String, String> map) {
		List<AnswerboardDto> list = null;
		list = session.selectList(NS+"selectDynamic", map);
		logger.info("===== Dao selectDynamic 실행 =====");
		return list;
	}

	@Override
	public boolean replyInsert(AnswerboardDto dto) {
		int cnt = 0;
		cnt = session.insert(NS+"replyInsert", dto);
		logger.info("===== Dao replyInsert 실행 =====");
		return cnt>0?true:false;
	}

	@Override
	public boolean replyUpdate(AnswerboardDto dto) {
		int cnt = 0;
		cnt = session.update(NS+"replyUpdate", dto);
		logger.info("===== Dao replyUpdate 실행 =====");
		return cnt>0?true:false;
	}

	@Override
	public boolean modifyBoard(Map<String, Object> map) {
		int cnt = 0;
		cnt = session.update(NS+"modifyBoard", map);
		logger.info("===== Dao modifyBoard 실행 =====");
		return cnt>0?true:false;
	}

	@Override
	public boolean insertBoard(AnswerboardDto dto) {
		int cnt = 0;
		cnt = session.insert(NS+"insertBoard", dto);
		logger.info("===== Dao insertBoard 실행 =====");
		return cnt>0?true:false;
	}

	@Override
	public boolean multiDelete(String seq) {
		int cnt = 0;
		cnt = session.update(NS+"multiDelete", seq);
		logger.info("===== Dao multiDelete 실행 =====");
		return cnt>0?true:false;
	}

	@Override
	public boolean multiDelete2(Map<String, String[]> map) {
		int cnt = 0;
		cnt = session.update(NS+"multiDelete2", map);
		logger.info("===== Dao multiDelete2 실행 =====");
		return cnt>0?true:false;
	}

}
