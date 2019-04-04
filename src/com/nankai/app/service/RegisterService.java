package com.nankai.app.service;

import java.util.List;

import com.nankai.app.domain.Member;
import com.nankai.app.domain.Register;
import com.nankai.app.vo.RegisterPage;


public interface RegisterService {
	public void add(Register register);
	public RegisterPage findAll(int currentPage,int pageSize);
	public void delete(Register register);
	public Register findRegisterByID(int sid);
	public void update(Register register);
	public List<Register> managerSearchForAndroid(Member mem,String position);
}
