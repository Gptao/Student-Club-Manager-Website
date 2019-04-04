package com.nankai.app.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.nankai.app.dao.MemberDao;
import com.nankai.app.domain.Department;
import com.nankai.app.domain.Member;
import com.nankai.app.domain.Organization;

import org.apache.struts2.ServletActionContext;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class MemberDaoImpl extends HibernateDaoSupport implements MemberDao{

	@Override
	public void update(Member member) {
		this.getHibernateTemplate().update(member);	
	}

	@Override
	public void add(Member member) {
		this.getHibernateTemplate().save(member);
	}

	@Override
	public void delete(Member member) {
		this.getHibernateTemplate().delete(member);
	}

	@Override
	public List<Member> findAll(final int currentPage, final int pageSize) {
		List list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException,SQLException {
				Query query  = session.createQuery("from Member");
				query.setFirstResult((currentPage-1)*pageSize);
				query.setMaxResults(pageSize);
				List<Member> list = query.list();
				return list;
			}
		});
		return list;
	}

	@Override
	public Member findMemberByID(int memberId) {
		return this.getHibernateTemplate().get(Member.class,memberId);
	}

	@Override
	public int findTotalCount() {
		Long count=(Long) this.getHibernateTemplate().find("select count(*)from Member").iterator().next();
		return count.intValue();
	}

	@Override
	public List<Member> findMemberByDid(int did) {
		List<Member> list = this.getHibernateTemplate().find("from Member where department.departmentId=?",did);
		return list;
	}

	@Override
	public List<Member> findMemberByName(String name) {
		String str = "from Member where memberName like '%"+name+"%'";
		List<Member> list = this.getHibernateTemplate().find(str);
		return list;
	}

	@Override
	public List<Member> findMemberByGender(String gender) {
		List<Member> list = this.getHibernateTemplate().find("from Member where memberGender=?",gender);
		return list;
	}

	@Override
	public List<Member> findMemberByMajor(String major) {
		List<Member> list = this.getHibernateTemplate().find("from Member where memberMajor=?",major);
		return list;
	}

	@Override
	public List<Member> findMemberByHometown(String hometown) {
		List<Member> list = this.getHibernateTemplate().find("from Member where memberHometown=?",hometown);
		return list;
	}

	@Override
	public List<Member> findMemberByPosition(String position) {
		List<Member> list = this.getHibernateTemplate().find("from Member where memberPosition=?",position);
		return list;
	}
	@Override
	public List<Member> findAllForManager(int currentPage, int pageSize) {
		//根据登录的身份，列出所属部门的所有人
		//String position = (String) ServletActionContext.getRequest().getAttribute("userPosition");
		//Integer username = (Integer)ServletActionContext.getRequest().getAttribute("username");
		//1.首先获得登录的member对象
		Member user = (Member) ServletActionContext.getRequest().getSession().getAttribute("user");
		String position = user.getMemberPosition();
		if(position.equals("高层"))
		{
			//2.根据member对象，获取他的department对象
			Department dpt = user.getDepartment();
			//3.根据department对象，获取它的Organization对象
			Organization org = dpt.getOrganization();
			//4.根据Organization对象，获取他的下辖部门集合
			Set<Department> dptSet = org.getDepartments();
			//5.遍历部门集合，获取每个部门的成员集合
			Set<Member> memSet = new HashSet();
			for (Department department : dptSet) {  
				Set<Member> temp = department.getMembers();
				for(Member mem:temp)
				{
					memSet.add(mem);
				}
			} 
			//List<Member> list = this.getHibernateTemplate().find("from Member where department.departmentId=?",did);
			//转化一下
			List<Member> list = new ArrayList(memSet);
			return list;
		}
		else
		{
			if(position.equals("管理员"))
			{
				return findAll(currentPage, pageSize);
			}
			else
			{
				if(position.equals("中层"))
				{
					Department dpt = user.getDepartment();
					Set<Member> mems = dpt.getMembers();
					Set<Member> memSet = new HashSet();
					for(Member mem:mems)
					{
						memSet.add(mem);
					}
					//转化一下
					List<Member> list = new ArrayList(memSet);
					return list;
				}
				else
				{
					return null;
				}
			}
		}
		
	}
	@Override
	public List<Member> findMemberByNameForAndroid(String name,int username) {
		String str = "from Member where memberName like '%"+name+"%'"
				+"AND memberDepartment =  "+username;
		List<Member> list = this.getHibernateTemplate().find(str);
		return list;
	}
	@Override
	public List<Member> findAllForManagerAndroid(String username) {
		// TODO Auto-generated method stub
		Member mem=findMemberByID(Integer.parseInt(username));
		if(mem.getMemberPosition().equals("高层"))
		{
			//2.根据member对象，获取他的department对象
			Department dpt = mem.getDepartment();
			//3.根据department对象，获取它的Organization对象
			Organization org = dpt.getOrganization();
			//4.根据Organization对象，获取他的下辖部门集合
			Set<Department> dptSet = org.getDepartments();
			//5.遍历部门集合，获取每个部门的成员集合
			Set<Member> memSet = new HashSet();
			for (Department department : dptSet) {  
				Set<Member> temp = department.getMembers();
				for(Member mem1:temp)
				{
					memSet.add(mem1);
				}
			} 
			//List<Member> list = this.getHibernateTemplate().find("from Member where department.departmentId=?",did);
			//转化一下
			List<Member> list = new ArrayList(memSet);
			return list;
		}
		else
		{
			if(mem.getMemberPosition().equals("管理员"))
			{
				List list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
					public Object doInHibernate(Session session) throws HibernateException,SQLException {
						Query query  = session.createQuery("from Member");
						List<Member> list = query.list();
						return list;
					}
				});
				return list;
			}
			else
				
			{
				if(mem.getMemberPosition().equals("中层"))
				{
					Department dpt = mem.getDepartment();
					Set<Member> mems = dpt.getMembers();
					Set<Member> memSet = new HashSet();
					for(Member mem1:mems)
					{
						memSet.add(mem1);
					}
					//转化一下
					List<Member> list = new ArrayList(memSet);
					return list;
				}
				else
				{
					return null;
				}
			}
		}
	}

}
