package com.goodee.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.goodee.service.Service1;
import com.goodee.vo.BbsVO;
import com.goodee.vo.UserVO;

@Controller
public class PageController {
	
	private Service1 service;
	

	public PageController(Service1 service) {
		super();
		this.service = service;
	}

	@GetMapping("/Controller1")
	public String move() {
		return "login/login1";
	}

	@PostMapping("/result1")
	public String login(UserVO vo) {
		if (service.login(vo)>0) {
			return "result/result1";
		}
		return "login/login1";
	}
	
	@GetMapping("/Controller2")
	public String move1() {
		return "login/login2";
	}
	
	@PostMapping("/result2")
	public String login2(UserVO vo, Model model) {
		if (service.login(vo)>0) {
			//리스트 가져오기
			service.getList(model);
			
			return "result/result2";
		}
		return "login/login2";
	}
	
	//--------------------------------------------------------------
	
	@GetMapping("/Controller3")
	public String move2() {
		return "login/login3";
	}
	
	//로그인 했을 때 띄우는 리스트
	@PostMapping("/result3")
	public String login3(UserVO vo, Model model, HttpSession session) {
		if (service.login(vo)>0) {
			//리스트 가져오기
			service.getList(model);
			session.setAttribute("session", vo);
			return "result/result3";
		} 
		return "login/login3";
	}
	
	//뒤로가기 했을 때 띄우는 리스트
	@GetMapping("/result3")
	public String login4(UserVO vo, Model model, HttpSession session) {
		//리스트 가져오기
		service.getList(model);
		session.setAttribute("session", vo);
		return "result/result3";
	}
	
	@GetMapping("/content1")
	public String content1(BbsVO vo, Model model) { //받아오는 매개변수
		//System.out.println(vo);
		//System.out.println(vo.getTitle());
		//System.out.println(vo.getContent());
		service.getContent(model, vo); //보내는 값

		return "content/content1";
	}
	
	@PostMapping("/back1")
	public String back(HttpSession session) {
		if(session.getAttribute("session") == null) {
			//세션을 초기화하고 로그인 창으로 돌려보냄
			session.invalidate();
			return "login/login3";
		}
		return "redirect:/result3";	//리다이렉트로 보내면 get으로 변환됨
	}
	
	//--------------------------------------------------------------
	@GetMapping("/Controller4")
	public String move4() {
		return "login/login4";
	}
	@PostMapping("/result4")
	public String login4_1(UserVO vo, Model model, HttpSession session) {
		if (service.login(vo)>0) {
			//리스트 가져오기
			service.getList(model);
			session.setAttribute("session", vo);
			return "result/result4";
		} 
		return "login/login4";
	}
	@GetMapping("/result4")//content2에서 뒤로가기 했을 때
	public String login4_2(UserVO vo, Model model, HttpSession session) {
		//리스트 가져오기
		service.getList(model);
		session.setAttribute("session", vo);
		return "result/result4";
	}
	@GetMapping("/content2")
	public String content2(BbsVO vo, Model model) { //받아오는 매개변수
		//System.out.println(vo);
		//System.out.println(vo.getTitle());
		//System.out.println(vo.getContent());
		service.getContent(model, vo); //보내는 값

		return "content/content2";
	}
	
	@PostMapping("/write")
	public String write(@SessionAttribute("session") UserVO vo, HttpSession session) {
		service.getInfo(vo);
		System.out.println(vo.getUserid());
		System.out.println(vo.getUsername());
		vo.getId();
		System.out.println(vo.getId());
		return "content/write1";
	}
	
	/*@PostMapping("/create")
	public String create(BbsVO bbsvo,) {
		service.create(vo);
		session.
		return "redirect:/result4";
	}*/
	
	@PostMapping("/back2")
	public String back2(HttpSession session) {
		if(session.getAttribute("session") == null) {
			//세션을 초기화하고 로그인 창으로 돌려보냄
			session.invalidate();
			return "login/login4";
		}
		return "redirect:/result4";	//리다이렉트로 보내면 get으로 변환됨
	}
}
