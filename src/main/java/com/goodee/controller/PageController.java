package com.goodee.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	//---------3번-----------------------------------------------------
	
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
	
	//----------4번----------------------------------------------------
	@GetMapping("/Controller4")
	public String move4() {
		return "login/login4";
	}
	@PostMapping("/result4")
	public String login4_1(UserVO vo, Model model, HttpSession session) {
		if (service.login(vo)>0) {
			//리스트 가져오기
			service.getList(model);
			
			//getInfo에서 받아온 정보 넣어주기
			//vo.setId(service.getInfo(vo).getId());
			UserVO vo1 = service.getInfo(vo);
			//정보 세션에 저장
			session.setAttribute("session", vo1);
			return "result/result4";
		} 
		return "login/login4";
	}
	@GetMapping("/result4")//content2에서 뒤로가기 했을 때, 세션 다시 저장 안해도 됨
	public String login4_2(UserVO vo, Model model) {
		//리스트 가져오기
		service.getList(model);
	//	UserVO vo1 = service.getInfo(vo);
	//	정보 세션에 저장
	//	session.setAttribute("session", vo1);
		return "result/result4";
	}
	@GetMapping("/content2")	//제목 누르면 제목, 내용 띄우기
	public String content2(BbsVO vo, Model model) { //받아오는 매개변수
		//System.out.println(vo);
		//System.out.println(vo.getTitle());
		//System.out.println(vo.getContent());
		service.getContent(model, vo); //보내는 값

		return "content/content2";
	}
	
/*	@PostMapping("/write")	//글쓰기 버튼 눌렀을 때
	public String write(@SessionAttribute("session") UserVO vo, HttpSession session) {
		service.getInfo(vo);
		//세션에 들어있는 값 확인하기
		//UserVO list = (UserVO) session.getAttribute("session");
		//System.out.println(list.getId());
		return "content/write1";
	} */
	
	@PostMapping("/write")	//글쓰기 버튼 눌렀을 때
	public String write() {
	//	service.getInfo(vo);
		return "content/write1";
	}
	
	@PostMapping("/create") //글 쓰고 전송 눌렀을 때
	public String create(@SessionAttribute("session") UserVO uservo, BbsVO bbsvo) {
		service.create(uservo, bbsvo);
		return "redirect:/result4";
	}
	
	@PostMapping("/back2")	//글 내용에서 뒤로가기 누르면
	public String back2(HttpSession session) {
		if(session.getAttribute("session") == null) {
			//세션을 초기화하고 로그인 창으로 돌려보냄
			session.invalidate();
			return "login/login4";
		}
		return "redirect:/result4";	//리다이렉트로 보내면 get으로 변환됨
	}

	//------5번--------------------------------------------------------
	@GetMapping("/Controller5")
	public String move5() {
		return "login/login5";
	}
	@PostMapping("/result5")
	public String login5_1(UserVO vo, Model model, HttpSession session) {
		if (service.login(vo)>0) {
			//리스트 가져오기
			service.getList(model);
			
			//getInfo에서 받아온 정보 넣어주기
			//vo.setId(service.getInfo(vo).getId());
			UserVO vo1 = service.getInfo(vo);
			//정보 세션에 저장
			session.setAttribute("session", vo1);
			return "result/result5";
		} 
		return "login/login5";
	}
	@GetMapping("/result5")//content2에서 뒤로가기 했을 때, 세션 다시 저장 안해도 됨
	public String login5_2(UserVO vo, Model model) {
		//리스트 가져오기
		service.getList(model);
		//	UserVO vo1 = service.getInfo(vo);
		//	정보 세션에 저장
		//	session.setAttribute("session", vo1);
		return "result/result5";
	}
	@GetMapping("/content3")	//제목 누르면 제목, 내용 띄우기
	public String content3(@SessionAttribute("session") UserVO uservo,
							BbsVO vo, Model model) { //받아오는 매개변수
		service.getContent(model, vo); //보내는 값 //해당 vo를 쓰려면 인스턴스 생성해서 사용
	//	System.out.println("컨트롤러");
	//	System.out.println(vo.getOwnerId());
	//	System.out.println(uservo.getId());
		BbsVO vo1 = (BbsVO)model.getAttribute("vo");
		if(vo1.getOwnerId() == uservo.getId()) {
			//작성자, 세션값 일치하면 수정버튼
			return "/content/content3Update";		
		} else {
			return "content/content3";
		}
	}
	

	//세션에 들어있는 값 확인하기
	//UserVO list = (UserVO) session.getAttribute("session");
	//System.out.println(list.getId());

	@PostMapping("/write2")	//글쓰기 버튼 눌렀을 때
	public String write2() {
		//	service.getInfo(vo);
		return "content/write2";
	}
	
	@PostMapping("/create2") //글 쓰고 전송 눌렀을 때
	public String create2(@SessionAttribute("session") UserVO uservo, BbsVO bbsvo) {
		service.create(uservo, bbsvo);
		return "redirect:/result5";
	}
	
	@PostMapping("/back3")	//글 내용에서 뒤로가기 누르면
	public String back3(HttpSession session) {
		if(session.getAttribute("session") == null) {
			//세션 만료됐다면 초기화하고 로그인 창으로 돌려보냄
			session.invalidate();
			return "login/login5";
		}
		return "redirect:/result5";	//세션있으면 다시 게시판
	}
	
	@GetMapping("/update1")	//수정 버튼 눌렀을 때
	public String update(@ModelAttribute("bbsVO")BbsVO vo,
						@SessionAttribute("session") UserVO uservo, Model model) {
		vo = service.getContent1(vo);
		System.out.println(vo.getCategory());
		System.out.println(vo.getContent());
		System.out.println(vo.getTitle());
		System.out.println(vo.getId());
		model.addAttribute("vo",vo);
		return "content/update1";
	}
	
	@PostMapping("/update1/{id}") //수정 후 전송 눌렀을 때
	public String update1(@ModelAttribute("bbsVO")BbsVO bbsVO, @PathVariable int id) {
		bbsVO.setId(id);
		service.update1(bbsVO);
		
		return "redirect:/result5";
	}
	//------6번--------------------------------------------------------
	@GetMapping("/Controller6")
	public String move6() {
		return "login/login6";
	}
	@PostMapping("/result6")
	public String login6_1(UserVO vo, Model model, HttpSession session) {
		if (service.login(vo)>0) {
			//리스트 가져오기
			service.getList(model);
			
			//getInfo에서 받아온 정보 넣어주기
			//vo.setId(service.getInfo(vo).getId());
			UserVO vo1 = service.getInfo(vo);
			//정보 세션에 저장
			session.setAttribute("session", vo1);
			return "result/result6";
		} 
		return "login/login6";
	}
	@GetMapping("/result6")//content2에서 뒤로가기 했을 때, 세션 다시 저장 안해도 됨
	public String login6_2(UserVO vo, Model model) {
		//리스트 가져오기
		service.getList(model);
		//	UserVO vo1 = service.getInfo(vo);
		//	정보 세션에 저장
		//	session.setAttribute("session", vo1);
		return "result/result6";
	}
	@GetMapping("/content6")	//제목 누르면 제목, 내용 띄우기
	public String content6(@SessionAttribute("session") UserVO uservo,
							BbsVO vo, Model model) { //받아오는 매개변수
		service.getContent(model, vo); //보내는 값 //해당 vo를 쓰려면 인스턴스 생성해서 사용
	//	System.out.println("컨트롤러");
	//	System.out.println(vo.getOwnerId());
	//	System.out.println(uservo.getId());
		BbsVO vo1 = (BbsVO)model.getAttribute("vo");
		if(vo1.getOwnerId() == uservo.getId()) {
			//작성자, 세션값 일치하면 수정버튼
			return "/content/content6Update";		
		} else {
			return "content/content6";
		}
	}
	

	//세션에 들어있는 값 확인하기
	//UserVO list = (UserVO) session.getAttribute("session");
	//System.out.println(list.getId());

	@PostMapping("/write6")	//글쓰기 버튼 눌렀을 때
	public String write6() {
		return "content/write6";
	}
	
	@PostMapping("/create6") //글 쓰고 전송 눌렀을 때
	public String create6(@SessionAttribute("session") UserVO uservo, BbsVO bbsvo) {
		service.create(uservo, bbsvo);
		return "redirect:/result6";
	}
	
	@PostMapping("/back6")	//글 내용에서 뒤로가기 누르면
	public String back6(HttpSession session) {
		if(session.getAttribute("session") == null) {
			//세션 만료됐다면 초기화하고 로그인 창으로 돌려보냄
			session.invalidate();
			return "login/login6";
		}
		return "redirect:/result6";	//세션있으면 다시 게시판
	}
	
	@GetMapping("/update6")	//수정 버튼 눌렀을 때
	public String update6(BbsVO vo,
						@SessionAttribute("session") UserVO uservo, Model model) {
		vo = service.getContent1(vo);
	/*	System.out.println(vo.getCategory());
		System.out.println(vo.getContent());
		System.out.println(vo.getTitle());
		System.out.println(vo.getId()); */
		model.addAttribute("bbsVO",vo);	
		return "content/update6";
	}
	@PostMapping("/update6/{id}") //수정 후 전송 눌렀을 때
	public String update6(@ModelAttribute("bbsVO")BbsVO bbsVO, @PathVariable int id) {
		bbsVO.setId(id);
		service.update1(bbsVO);
		
		return "redirect:/result6";
	}
	@GetMapping("/delete/{id}")	//삭제 버튼 눌렀을 때
	public String delete(BbsVO vo, @PathVariable int id, Model model) {
		service.delete6(vo);
		return "redirect:/result6";
	}
}
