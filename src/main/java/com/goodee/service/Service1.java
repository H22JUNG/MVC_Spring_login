package com.goodee.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

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
	
	public List<BbsVO> getContent(Model model) {
		//dao.getContent();
		//System.out.println(dao.getContent().get(0).getContent());
		//BbsVO vo = new BbsVO();
	//	System.out.println(vo.getContent());
		return dao.getContent();
	}
}
