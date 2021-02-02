package com.min.edu.ctrl;

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
import org.springframework.web.bind.annotation.ResponseBody;

import com.min.edu.dto.MemberDto;
import com.min.edu.model.service.IServiceMember;

@Controller
public class MemberContoller {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private IServiceMember service;
	
	/**
	 * 전체 회원 조회
	 * @param Model model
	 * @return "memberList"
	 */
	@RequestMapping(value = "/memberList.do", method = RequestMethod.GET)
	public String memberList(Model model) {
		List<MemberDto> list = service.memList();	// 전체 회원 조회
		model.addAttribute("list", list);
		logger.info("===== Controller memberList.do 실행 =====");
		return "memberList";
	}
	
	/**
	 * 로그인
	 * @param Map<String, Object> map
	 * @param HttpSession session
	 * @return "redirect:/boardList.do"
	 */
	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	public String login(@RequestParam Map<String, Object> map, HttpSession session) {
		MemberDto dto = service.loginMember(map);	// 로그인
		session.setAttribute("mem", dto);			// 해당 id의 MemberDto 세션에 저장
		logger.info("===== Controller login.do 실행 =====");
		return "redirect:/boardList.do";
	}
	
	/**
	 * 로그아웃
	 * @param HttpSession session
	 * @return "redirect:/"
	 */
	@RequestMapping(value = "/logout.do", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		MemberDto dto = (MemberDto) session.getAttribute("mem");	
		System.out.println(dto);
		if (dto != null) {							// 세션 확인 후
			session.removeAttribute("mem");			// 해당 id의 MemberDto 세션에서 삭제
		}
		logger.info("===== Controller logout.do 실행 =====");
		return "redirect:/";
	}
	
	/**
	 * index > 회원가입 페이지
	 * @return "registForm"
	 */
	@RequestMapping(value = "/registForm.do", method = RequestMethod.GET)
	public String registForm() {
		logger.info("===== Controller registForm.do 실행 =====");
		return "registForm";
	}
	
	/**
	 * Ajax로 id 중복확인
	 * @param String id
	 * @return Map<String, String> map
	 */
	@RequestMapping(value = "/idCheck.do", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, String> idCheck(String id){
		Map<String, String> map = new HashMap<String, String>();
		boolean isc = service.idDuplicateCheck(id);
		map.put("isc", String.valueOf(isc));
		logger.info("===== Controller idCheck.do 실행 =====");
		return map;		// Map 안에 boolean 결과값 넣어서 전달
	}
	
	/**
	 * 회원가입
	 * @param MemberDto memberDto
	 * @return
	 */
	@RequestMapping(value = "/regist.do", method = RequestMethod.POST)
	public String regist(MemberDto memberDto) {
		boolean isc = service.signUpMember(memberDto);	// 회원가입
		logger.info("===== Controller regist.do 실행 =====");
		return isc? "redirect:/":"redirect:/registForm.do";
	}
	
}
