package com.nankai.app.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.struts2.ServletActionContext;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.nankai.app.dao.RegisterDao;
import com.nankai.app.domain.Department;
import com.nankai.app.domain.Member;
import com.nankai.app.domain.Organization;
import com.nankai.app.domain.Register;



public class RegisterDaoImpl extends HibernateDaoSupport implements RegisterDao{

	@Override
	public void add(Register register) {
		this.getHibernateTemplate().save(register);	
		
	}

	@Override
	public List<Register> findAll(final int currentPage, final int pageSize,Member user) {
	//根据传进来的user，找到所有报了他部门的人
		String position = (String) ServletActionContext.getRequest().getSession().getAttribute("userPosition");
		if(position.equals("高层"))
		{
			//2.根据member对象，获取他的department对象
			Department dpt = user.getDepartment();
			//3.根据department对象，获取它的Organization对象
			Organization org = dpt.getOrganization();
			//4.根据Organization对象，获取他的下辖部门集合
			Set<Department> dptSet = org.getDepartments();
			//5.遍历部门集合，获取每个部门的报名人的集合
			Set<Register> registerSet = new HashSet();
			for (Department department : dptSet) {  
				Set<Register> registers1 = department.getRegistersForRegisterIntention1();
				Set<Register> registers2 = department.getRegistersForRegisterIntention2();
				//第一志愿需要register=0没有被拒绝过
				for(Register register:registers1)
				{
					if(register.getRegisterStatus()==0)
                        registerSet.add(register);
				}
				//第二志愿register=1可以被拒绝一次
                for(Register register:registers2)
				{
					if(register.getRegisterStatus()==1)
                        registerSet.add(register);
				}
			} 
//			//这里获取所有报名人的信息，要是该条报名信息的状态  statues=2&&intention1、2都不等于登录人的部门 ，那就显示
//            @SuppressWarnings("unchecked")
//			List<Register> allList= this.getHibernateTemplate().executeFind(new HibernateCallback() {
//					public Object doInHibernate(Session session) throws HibernateException,SQLException {
//					Query query  = session.createQuery("from Register");
//					List<Register> list = query.list();
//					return list;
//				}
//            });
//            for(Register register:allList)
//			{
//				if(register.getRegisterStatus()==2 && (register.getDepartmentByRegisterIntention1().getOrganization().getOrganizationId()!=org.getOrganizationId()) && (register.getDepartmentByRegisterIntention2().getOrganization().getOrganizationId()!=org.getOrganizationId()))
//				{
//					registerSet.add(register);
//				}
//			}
			//转化一下
			List<Register> list = new ArrayList(registerSet);
			return list;
		}
		else
		{
			if(position.equals("管理员"))
			{
				List list= this.getHibernateTemplate().executeFind(new HibernateCallback() {
						public Object doInHibernate(Session session) throws HibernateException,SQLException {
						Query query  = session.createQuery("from Register");
						List<Register> list = query.list();
						return list;
					}
				});
				return list;
			}
			else
			{
				if(position.equals("中层"))
				{
					Department dpt = user.getDepartment();
					Set<Register> registers1 = dpt.getRegistersForRegisterIntention1();
                    Set<Register> registers2 = dpt.getRegistersForRegisterIntention2();
                    
					Set<Register> registerSet = new HashSet();
					for(Register register:registers1)
					{
						if(register.getRegisterStatus()==0)
                            registerSet.add(register);
					}
                    for(Register register:registers2)
					{
						if(register.getRegisterStatus()==1)
                            registerSet.add(register);
					}
                    //这里获取所有报名人的信息，要是该条报名信息的状态  statues=2&&intention1、2都不等于登录人的部门 ，那就显示
//                    List<Register> allList= this.getHibernateTemplate().executeFind(new HibernateCallback() {
//							public Object doInHibernate(Session session) throws HibernateException,SQLException {
//							Query query  = session.createQuery("from Register");
//							List<Register> list = query.list();
//							return list;
//						}
//                    });
//                    for(Register register:allList)
//					{
//						if(register.getRegisterStatus()==2 && (register.getDepartmentByRegisterIntention1().getDepartmentId()!=dpt.getDepartmentId()) && (register.getDepartmentByRegisterIntention2().getDepartmentId()!=dpt.getDepartmentId()))
//						{
//							registerSet.add(register);
//						}
//					}
					//转化一下
					List<Register> list = new ArrayList(registerSet);
					return list;
				}
				else
				{
					return null;
				}
			}
		}
	}
	public List<Register> managerSearchForAndroid(Member user,String position){
		
		if(position.equals("高层"))
		{
			//2.根据member对象，获取他的department对象
			Department dpt = user.getDepartment();
			//3.根据department对象，获取它的Organization对象
			Organization org = dpt.getOrganization();
			//4.根据Organization对象，获取他的下辖部门集合
			Set<Department> dptSet = org.getDepartments();
			//5.遍历部门集合，获取每个部门的报名人的集合
			Set<Register> registerSet = new HashSet();
			for (Department department : dptSet) {  
				Set<Register> registers1 = department.getRegistersForRegisterIntention1();
				Set<Register> registers2 = department.getRegistersForRegisterIntention2();
				for(Register register:registers1)
				{
					if(register.getRegisterStatus()==0)
                        registerSet.add(register);
				}
                for(Register register:registers2)
				{
					if(register.getRegisterStatus()==1)
                        registerSet.add(register);
				}
			} 
			//这里获取所有报名人的信息，要是该条报名信息的状态  statues=2&&intention1、2都不等于登录人的部门 ，那就显示
            List<Register> allList= this.getHibernateTemplate().executeFind(new HibernateCallback() {
					public Object doInHibernate(Session session) throws HibernateException,SQLException {
					Query query  = session.createQuery("from Register");
					List<Register> list = query.list();
					return list;
				}
            });
            for(Register register:allList)
			{
				if(register.getRegisterStatus()==2 && (register.getDepartmentByRegisterIntention1().getOrganization().getOrganizationId()!=org.getOrganizationId()) && (register.getDepartmentByRegisterIntention2().getOrganization().getOrganizationId()!=org.getOrganizationId()))
				{
					registerSet.add(register);
				}
			}
			//转化一下
			List<Register> list = new ArrayList(registerSet);
			return list;
		}
		else
		{
			if(position.equals("管理员"))
			{
				List list= this.getHibernateTemplate().executeFind(new HibernateCallback() {
						public Object doInHibernate(Session session) throws HibernateException,SQLException {
						Query query  = session.createQuery("from Register");
						List<Register> list = query.list();
						return list;
					}
				});
				return list;
			}
			else
			{
				if(position.equals("中层"))
				{
					Department dpt = user.getDepartment();
					Set<Register> registers1 = dpt.getRegistersForRegisterIntention1();
                    Set<Register> registers2 = dpt.getRegistersForRegisterIntention2();
                    
					Set<Register> registerSet = new HashSet();
					for(Register register:registers1)
					{
						if(register.getRegisterStatus()==0)
                            registerSet.add(register);
					}
                    for(Register register:registers2)
					{
						if(register.getRegisterStatus()==1)
                            registerSet.add(register);
					}
                    //这里获取所有报名人的信息，要是该条报名信息的状态  statues=2&&intention1、2都不等于登录人的部门 ，那就显示
                    List<Register> allList= this.getHibernateTemplate().executeFind(new HibernateCallback() {
							public Object doInHibernate(Session session) throws HibernateException,SQLException {
							Query query  = session.createQuery("from Register");
							List<Register> list = query.list();
							return list;
						}
                    });
                    for(Register register:allList)
					{
						if(register.getRegisterStatus()==2 && (register.getDepartmentByRegisterIntention1().getDepartmentId()!=dpt.getDepartmentId()) && (register.getDepartmentByRegisterIntention2().getDepartmentId()!=dpt.getDepartmentId()))
						{
							registerSet.add(register);
						}
					}
					//转化一下
					List<Register> list = new ArrayList(registerSet);
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
	public Register findRegisterByID(int sid) {
		return this.getHibernateTemplate().get(Register.class, sid);
	}

	@Override
	public int findTotalCount() {
		Long count=(Long) this.getHibernateTemplate().find("select count(*) from Register").iterator().next();
		return count.intValue();
	}

	@Override
	public void delete(Register register) {
		this.getHibernateTemplate().delete(register);
	}

	@Override
	public void update(Register register) {
		this.getHibernateTemplate().update(register);
		
	}

}
