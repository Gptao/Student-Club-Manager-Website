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
	//���ݴ�������user���ҵ����б��������ŵ���
		String position = (String) ServletActionContext.getRequest().getSession().getAttribute("userPosition");
		if(position.equals("�߲�"))
		{
			//2.����member���󣬻�ȡ����department����
			Department dpt = user.getDepartment();
			//3.����department���󣬻�ȡ����Organization����
			Organization org = dpt.getOrganization();
			//4.����Organization���󣬻�ȡ������Ͻ���ż���
			Set<Department> dptSet = org.getDepartments();
			//5.�������ż��ϣ���ȡÿ�����ŵı����˵ļ���
			Set<Register> registerSet = new HashSet();
			for (Department department : dptSet) {  
				Set<Register> registers1 = department.getRegistersForRegisterIntention1();
				Set<Register> registers2 = department.getRegistersForRegisterIntention2();
				//��һ־Ը��Ҫregister=0û�б��ܾ���
				for(Register register:registers1)
				{
					if(register.getRegisterStatus()==0)
                        registerSet.add(register);
				}
				//�ڶ�־Ըregister=1���Ա��ܾ�һ��
                for(Register register:registers2)
				{
					if(register.getRegisterStatus()==1)
                        registerSet.add(register);
				}
			} 
//			//�����ȡ���б����˵���Ϣ��Ҫ�Ǹ���������Ϣ��״̬  statues=2&&intention1��2�������ڵ�¼�˵Ĳ��� ���Ǿ���ʾ
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
			//ת��һ��
			List<Register> list = new ArrayList(registerSet);
			return list;
		}
		else
		{
			if(position.equals("����Ա"))
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
				if(position.equals("�в�"))
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
                    //�����ȡ���б����˵���Ϣ��Ҫ�Ǹ���������Ϣ��״̬  statues=2&&intention1��2�������ڵ�¼�˵Ĳ��� ���Ǿ���ʾ
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
					//ת��һ��
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
		
		if(position.equals("�߲�"))
		{
			//2.����member���󣬻�ȡ����department����
			Department dpt = user.getDepartment();
			//3.����department���󣬻�ȡ����Organization����
			Organization org = dpt.getOrganization();
			//4.����Organization���󣬻�ȡ������Ͻ���ż���
			Set<Department> dptSet = org.getDepartments();
			//5.�������ż��ϣ���ȡÿ�����ŵı����˵ļ���
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
			//�����ȡ���б����˵���Ϣ��Ҫ�Ǹ���������Ϣ��״̬  statues=2&&intention1��2�������ڵ�¼�˵Ĳ��� ���Ǿ���ʾ
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
			//ת��һ��
			List<Register> list = new ArrayList(registerSet);
			return list;
		}
		else
		{
			if(position.equals("����Ա"))
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
				if(position.equals("�в�"))
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
                    //�����ȡ���б����˵���Ϣ��Ҫ�Ǹ���������Ϣ��״̬  statues=2&&intention1��2�������ڵ�¼�˵Ĳ��� ���Ǿ���ʾ
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
					//ת��һ��
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
