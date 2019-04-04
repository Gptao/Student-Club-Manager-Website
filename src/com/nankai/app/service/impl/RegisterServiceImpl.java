package com.nankai.app.service.impl;

import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.springframework.transaction.annotation.Transactional;

import com.nankai.app.dao.MemberDao;
import com.nankai.app.dao.RegisterDao;
import com.nankai.app.dao.impl.MemberDaoImpl;
import com.nankai.app.domain.Member;
import com.nankai.app.domain.Register;
import com.nankai.app.service.RegisterService;
import com.nankai.app.vo.RegisterPage;



@Transactional
public class RegisterServiceImpl implements RegisterService{
    private RegisterDao registerDao;
    private MemberDao memberDao;

	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}


	public void setRegisterDao(RegisterDao registerDao) {
		this.registerDao = registerDao;
	}


	@Override
	public void add(Register register) {
		registerDao.add(register);
	}


	@Override
	public RegisterPage findAll(int currentPage, int pageSize) {
		RegisterPage registerPage = new RegisterPage();
		//这里，不能直接用登录时传过来的user，否则数据库被修改后，数据不会被同步更新
		Member loginUser = (Member) ServletActionContext.getRequest().getSession().getAttribute("user");
		if(loginUser==null)return null;
		Member newUser = memberDao.findMemberByID(loginUser.getMemberId());
		List<Register> list = registerDao.findAll(currentPage, pageSize,newUser);
		registerPage.setDataList(list);
		registerPage.setCurrentPage(currentPage);
		registerPage.setPageSize(pageSize);
		int totalCount = registerDao.findTotalCount();
		registerPage.setTotalCount(totalCount);
		registerPage.setTotalPage(totalCount % pageSize ==0?totalCount/pageSize:totalCount/pageSize+1);
		return registerPage;
	}

	public List<Register> managerSearchForAndroid(Member mem,String position){
		return registerDao.managerSearchForAndroid(mem, position);
	}
	@Override
	public void delete(Register register) {
		registerDao.delete(register);
	}


	@Override
	public Register findRegisterByID(int sid) {
		return registerDao.findRegisterByID(sid);
	}


	@Override
	public void update(Register register) {
		registerDao.update(register);
	}

}
