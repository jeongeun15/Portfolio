package com.min.edu.ctrl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.min.edu.dto.AnswerboardDto;
import com.min.edu.dto.MemberDto;
import com.min.edu.model.service.IServiceAnswerboard;

@Controller
public class BoardController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private IServiceAnswerboard service;
	
	/**
	 * 전체 글 조회
	 * @param Model model
	 * @return "boardList"
	 */
	@RequestMapping(value = "/boardList.do", method = RequestMethod.GET)
	public String boardList(Model model) {
		Map<String, String> map = new HashMap<String, String>();
		List<AnswerboardDto> list = service.selectDynamic(map);	// 전체 글 조회
		model.addAttribute("list", list);
		logger.info("===== Controller boardList.do 실행 =====");
		return "boardList";
	}
	
	/**
	 * 전체 글 목록 > 글쓰기 페이지
	 * @return "writeForm"
	 */
	@RequestMapping(value = "/writeForm.do", method = RequestMethod.GET)
	public String boardWrite() {
		logger.info("===== Controller writeForm.do 실행 =====");
		return "writeForm";
	}
	
	/**
	 * 글쓰기
	 * @param AnswerboardDto
	 * @param HttpSession session
	 * @return isc?"redirect:/boardList.do":"redirect:/writeForm.do"
	 */
	@RequestMapping(value = "/write.do", method = RequestMethod.POST)
	public String write(AnswerboardDto answerboardDto, HttpSession session) {
		MemberDto memeberDto = (MemberDto) session.getAttribute("mem");		// 회원 세션 dto에 저장
		answerboardDto.setId(memeberDto.getId());
		boolean isc = service.insertBoard(answerboardDto);					// 글 저장
		logger.info("===== Controller write.do 실행 =====");
		return isc?"redirect:/boardList.do":"redirect:/writeForm.do";
	}
	
	/**
	 * 상세글 조회
	 * @param String seq
	 * @param Model model
	 * @return "detailView"
	 */
	@RequestMapping(value = "/detailView.do", method = RequestMethod.GET)
	public String detailView(String seq, Model model) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("seq", seq);
		List<AnswerboardDto> dto = service.selectDynamic(map);		// 상세 글 조회
		model.addAttribute("detail", dto);
		logger.info("===== Controller detailView.do 실행 =====");
		return "detailView";
	}
	
	/**
	 * 상세글 > 수정 페이지
	 * @param String seq
	 * @param Model model
	 * @return "modifyForm"
	 */
	@RequestMapping(value = "/modifyForm.do", method = RequestMethod.GET)
	public String modifyForm(String seq,  Model model) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("seq", seq);
		List<AnswerboardDto> dto = service.selectDynamic(map);
		model.addAttribute("detail", dto);
		logger.info("===== Controller modifyForm.do 실행 =====");
		return "modifyForm";
	}
	
	/**
	 * 글 수정
	 * @param AnswerboardDto answerboardDto
	 * @return isc?"redirect:/boardList.do":"redirect:/modifyForm.do"
	 */
	@RequestMapping(value = "/modify.do", method = RequestMethod.POST)
	public String modify(AnswerboardDto answerboardDto) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("seq", answerboardDto.getSeq());
		map.put("content", answerboardDto.getContent());
		boolean isc = service.modifyBoard(map);		// 수정 글 저장
		logger.info("===== Controller modify.do 실행 =====");
		return isc?"redirect:/boardList.do":"redirect:/modifyForm.do";
	}
	
	/**
	 * 상세글 > 답글 입력 페이지
	 * @param String seq
	 * @param Model model
	 * @param HttpSession session
	 * @return "replyForm"
	 */
	@RequestMapping(value = "/replyForm.do", method = RequestMethod.GET)
	public String replyForm(String seq,  Model model, HttpSession session) {
		MemberDto memberDto = (MemberDto) session.getAttribute("mem");	// 회원 세션 dto에 저장
		Map<String, String> map = new HashMap<String, String>();
		map.put("seq", seq);
		List<AnswerboardDto> dto = service.selectDynamic(map);
		model.addAttribute("detail", dto);
		model.addAttribute("mem", memberDto);
		logger.info("===== Controller replyForm.do 실행 =====");
		return "replyForm";
	}
	
	/**
	 * 답글 입력
	 * @param AnswerboardDto answerboardDto
	 * @param HttpSession session
	 * @return isc?"redirect:/boardList.do":"redirect:/replyForm.do"
	 */
	@RequestMapping(value = "/reply.do", method = RequestMethod.POST)
	public String reply(AnswerboardDto answerboardDto, HttpSession session) {
		answerboardDto.setId(((MemberDto)session.getAttribute("mem")).getId());
		boolean isc = service.replyInsert(answerboardDto);		// 답글 입력
		logger.info("===== Controller reply.do 실행 =====");
		return isc?"redirect:/boardList.do":"redirect:/replyForm.do";
	}
	
	/**
	 * 해당 글 삭제
	 * @param String seq
	 * @return isc?"redirect:/boardList.do":"redirect:/detailView.do"
	 */
	@RequestMapping(value = "/del.do", method = RequestMethod.GET)
	public String del(String seq) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("seq", seq);
		boolean isc = service.multiDelete(seq);
		logger.info("===== Controller del.do 실행 =====");
		return isc?"redirect:/boardList.do":"redirect:/detailView.do";
	}
	
	/**
	 * 선택 글 다중 삭제
	 * @param ArrayList<String> chkVal
	 * @return isc?"redirect:/boardList.do":"redirect:/boardList.do"
	 */
	@RequestMapping(value = "/multiDel.do", method = RequestMethod.POST)
	public String multiDel(@RequestParam ArrayList<String> chkVal) {
		String[] seqs = chkVal.toArray(new String[chkVal.size()]);
		Map<String, String[]> map = new HashMap<String, String[]>();
		map.put("seqs", seqs);
		boolean isc = service.multiDelete2(map);
		logger.info("===== Controller multiDel.do 실행 =====");
		return isc?"redirect:/boardList.do":"redirect:/boardList.do";
	}
	
}
