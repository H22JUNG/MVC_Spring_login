package com.goodee.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.goodee.dao.DAO;
import com.goodee.vo.BbsVO;
import com.goodee.vo.UserVO;

@Service
public class Service1 {
	
	private DAO dao;
	public Service1(DAO dao) {
		super();
		this.dao = dao;
	}
	
	public int login(UserVO vo) {
		return dao.count(vo);
	}
	
	public List<UserVO> getList(Model model) {
		model.addAttribute("list", dao.getList());
		return dao.getList();
	}
	
	public void getContent(Model model, BbsVO vo) {
	//	BbsVO vo2 = dao.getContent(vo); //BbsVO 잘 받아와지나 확인
	//	System.out.println("서비스");
	//	System.out.println(vo2.getOwnerId());
		model.addAttribute("vo", dao.getContent(vo));
	}

	
	public UserVO getInfo(UserVO vo) {
		//System.out.println("서비스");
		//System.out.println(vo.getUserid());
		return dao.getInfo(vo);
	}

	public int create(@SessionAttribute("session") UserVO uservo, BbsVO bbsvo) {
		//세션에서 userid 받아와서 bbsvo에 넣어주기
		bbsvo.setOwnerId(uservo.getId());
		bbsvo.setOwner(uservo.getUsername());
		
		return dao.insert(bbsvo);
	}
	public BbsVO getContent1(BbsVO vo) {
		return dao.getContent(vo);
	}
	public int update1(BbsVO vo) {
		return dao.update1(vo);
	}
}
