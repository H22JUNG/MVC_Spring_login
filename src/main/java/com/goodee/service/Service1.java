package com.goodee.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.goodee.dao.DAO;
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
	
	public List<UserVO> getList() {
		dao.getList();
		
		return List<UserVO>;
	}
}
