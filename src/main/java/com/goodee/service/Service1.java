package com.goodee.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

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
		System.out.println("111");
		System.out.println(vo.getTitle());
		System.out.println(vo.getContent());
		
		//BbsVO vo2 = new BbsVO(); 
		//vo2=dao.getContent(vo); BbsVO 잘 받아와지나 확인
		//System.out.println(vo2.getContent());
		
		model.addAttribute("vo", dao.getContent(vo));
	}
}
