package com.nankai.app.dao;

import java.util.List;

import com.nankai.app.domain.Member;

public interface MemberDao {
	public void update(Member member);
	public void add(Member member);
	public void delete(Member member);
	public List<Member> findAll(int currentPage,int pageSize);
	public Member findMemberByID(int memberId);
	public int findTotalCount();
	public List<Member> findMemberByDid(int did);
	public List<Member> findMemberByName(String name);
	public List<Member> findMemberByGender(String gender);
	public List<Member> findMemberByMajor(String major);
	public List<Member> findMemberByHometown(String hometown);
	public List<Member> findMemberByPosition(String position);
	public List<Member> findAllForManager(int currentPage, int pageSize);
	public List<Member> findAllForManagerAndroid(String position);
	public List<Member> findMemberByNameForAndroid(String name,int username);
}
