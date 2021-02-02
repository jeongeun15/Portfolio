package com.min.edu.model.dao;

import java.util.List;
import java.util.Map;

import com.min.edu.dto.AnswerboardDto;

public interface IDaoAnswerboard {
	
	public List<AnswerboardDto> selectDynamic(Map<String, String> map);

	public boolean replyInsert(AnswerboardDto dto);

	public boolean replyUpdate(AnswerboardDto dto);

	public boolean modifyBoard(Map<String, Object> map);

	public boolean insertBoard(AnswerboardDto dto);

	public boolean multiDelete(String seq);

	public boolean multiDelete2(Map<String, String[]> map);
	
}
