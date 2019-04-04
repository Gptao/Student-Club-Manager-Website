package com.nankai.app.dao;

import java.util.List;

import com.nankai.app.domain.Member;
import com.nankai.app.domain.Register;

public interface RegisterDao {
	public void add(Register register);
	public List<Register> findAll(int currentPage,int pageSize,Member user);
	public Register findRegisterByID(int sid);
	public int findTotalCount();
	public void delete(Register register);
	
	public void update(Register register);
	public List<Register> managerSearchForAndroid(Member user,String position);
}

