package com.min.edu.model.service;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.min.edu.dto.AnswerboardDto;
import com.min.edu.model.dao.IDaoAnswerboard;

@Service
public class ServiceAnswerboardImpl implements IServiceAnswerboard {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private IDaoAnswerboard dao;

	@Override
	public List<AnswerboardDto> selectDynamic(Map<String, String> map) {
		logger.info("===== Service selectDynamic 실행 =====");
		return dao.selectDynamic(map);
	}
	
	@Transactional
	@Override
	public boolean replyInsert(AnswerboardDto dto) {
		boolean isc1 = dao.replyInsert(dto);
		boolean isc2 = dao.replyUpdate(dto);
		logger.info("===== Service replyInsert 실행 =====");
		return (isc1 || isc2)? true:false;
	}

	@Override
	public boolean modifyBoard(Map<String, Object> map) {
		logger.info("===== Service modifyBoard 실행 =====");
		return dao.modifyBoard(map);
	}

	@Override
	public boolean insertBoard(AnswerboardDto dto) {
		logger.info("===== Service insertBoard 실행 =====");
		return dao.insertBoard(dto);
	}

	@Override
	public boolean multiDelete(String seq) {
		logger.info("===== Service multiDelete 실행 =====");
		return dao.multiDelete(seq);
	}

	@Override
	public boolean multiDelete2(Map<String, String[]> map) {
		logger.info("===== Service multiDelete2 실행 =====");
		return dao.multiDelete2(map);
	}

}
