package com.nankai.app.service;

import java.util.List;

import com.nankai.app.domain.Member;
import com.nankai.app.vo.RegisterPage;

public interface MemberService {
	public void update(Member member);
	public void add(Member member);
	public void delete(Member member);
	public RegisterPage findAll(int currentPage,int pageSize);
	public Member findMemberByID(int memberId);
	public List<Member> findMemberByDid(int did);
	public List<Member> findMemberByName(String name);
	public List<Member> findMemberByGender(String gender);
	public List<Member> findMemberByMajor(String major);
	public List<Member> findMemberByHometown(String hometown);
	public List<Member> findMemberByPosition(String position);
	public RegisterPage findAllForManager(int currentPage, int pageSize);
	public List<Member> fingAllForManagerAndroid(String username);
	public List<Member> findMemberByNameForAndroid(String name,int username);
}
