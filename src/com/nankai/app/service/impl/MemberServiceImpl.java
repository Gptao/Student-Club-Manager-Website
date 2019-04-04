package com.nankai.app.service.impl;

import java.util.List;

import com.nankai.app.dao.MemberDao;
import com.nankai.app.domain.Member;
import com.nankai.app.service.MemberService;
import com.nankai.app.vo.RegisterPage;

public class MemberServiceImpl implements MemberService{
    private MemberDao memberDao;
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	@Override
	public void update(Member member) {
		memberDao.update(member);
		
	}
	@Override
	public void add(Member member) {
		memberDao.add(member);
	}

	@Override
	public void delete(Member member) {
		memberDao.delete(member);
	}

	@Override
	public RegisterPage findAll(int currentPage, int pageSize) {
		//查询所有
		RegisterPage registerPage = new RegisterPage();
		List<Member> list = memberDao.findAll(currentPage, pageSize);
		registerPage.setMemberList(list);
		registerPage.setCurrentPage(currentPage);
		registerPage.setPageSize(pageSize);
		int totalCount = memberDao.findTotalCount();
		registerPage.setTotalCount(totalCount);
		registerPage.setTotalPage(totalCount % pageSize ==0?totalCount/pageSize:totalCount/pageSize+1);
		return registerPage;
	}

	@Override
	public Member findMemberByID(int memberId) {
		//按学号
		return memberDao.findMemberByID(memberId);
	}

	@Override
	public List<Member> findMemberByDid(int did) {
		//按部门编号
		List<Member> list=memberDao.findMemberByDid(did);
		return list;
	}

	@Override
	public List<Member> findMemberByName(String name) {
		//按姓名
		List<Member> list=memberDao.findMemberByName(name);
		return list;
	}

	@Override
	public List<Member> findMemberByGender(String gender) {
		//按性别
		List<Member> list=memberDao.findMemberByGender(gender);
		return list;
	}

	@Override
	public List<Member> findMemberByMajor(String major) {
		// 按专业
		List<Member> list=memberDao.findMemberByMajor(major);
		return list;
	}

	@Override
	public List<Member> findMemberByHometown(String hometown) {
		//按籍贯查找
		List<Member> list=memberDao.findMemberByHometown(hometown);
		return list;
	}

	@Override
	public List<Member> findMemberByPosition(String position) {
		// 按职务查找
		List<Member> list=memberDao.findMemberByPosition(position);
		return list;
	}
	@Override
	public RegisterPage findAllForManager(int currentPage, int pageSize) {
		//根据dao层传来的人员表，放到分页类里面
		RegisterPage registerPage = new RegisterPage();
		List<Member> list = memberDao.findAllForManager(currentPage, pageSize);
		registerPage.setMemberList(list);
		registerPage.setCurrentPage(currentPage);
		registerPage.setPageSize(pageSize);
		int totalCount = memberDao.findTotalCount();
		registerPage.setTotalCount(totalCount);
		registerPage.setTotalPage(totalCount % pageSize ==0?totalCount/pageSize:totalCount/pageSize+1);
		return registerPage;
	}
	@Override
	public List<Member> fingAllForManagerAndroid(String username) {
		// TODO Auto-generated method stub
		return memberDao.findAllForManagerAndroid(username);//因为这个地方page那些参数都没用我就随便写了
	}
	@Override
	public List<Member> findMemberByNameForAndroid(String name, int username) {
		return memberDao.findMemberByNameForAndroid(name, username);
	}
	

}
