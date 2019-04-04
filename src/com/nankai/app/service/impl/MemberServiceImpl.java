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
		//��ѯ����
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
		//��ѧ��
		return memberDao.findMemberByID(memberId);
	}

	@Override
	public List<Member> findMemberByDid(int did) {
		//�����ű��
		List<Member> list=memberDao.findMemberByDid(did);
		return list;
	}

	@Override
	public List<Member> findMemberByName(String name) {
		//������
		List<Member> list=memberDao.findMemberByName(name);
		return list;
	}

	@Override
	public List<Member> findMemberByGender(String gender) {
		//���Ա�
		List<Member> list=memberDao.findMemberByGender(gender);
		return list;
	}

	@Override
	public List<Member> findMemberByMajor(String major) {
		// ��רҵ
		List<Member> list=memberDao.findMemberByMajor(major);
		return list;
	}

	@Override
	public List<Member> findMemberByHometown(String hometown) {
		//���������
		List<Member> list=memberDao.findMemberByHometown(hometown);
		return list;
	}

	@Override
	public List<Member> findMemberByPosition(String position) {
		// ��ְ�����
		List<Member> list=memberDao.findMemberByPosition(position);
		return list;
	}
	@Override
	public RegisterPage findAllForManager(int currentPage, int pageSize) {
		//����dao�㴫������Ա���ŵ���ҳ������
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
		return memberDao.findAllForManagerAndroid(username);//��Ϊ����ط�page��Щ������û���Ҿ����д��
	}
	@Override
	public List<Member> findMemberByNameForAndroid(String name, int username) {
		return memberDao.findMemberByNameForAndroid(name, username);
	}
	

}
