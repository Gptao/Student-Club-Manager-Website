package com.nankai.app.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.nankai.app.dao.DepartmentDao;
import com.nankai.app.domain.Department;
import com.nankai.app.domain.Organization;

public class DepartmentDaoImpl extends HibernateDaoSupport implements DepartmentDao{

	@Override
	public List<Department> findAll() {
		//找出数据库里面的所有的部门
		// 在spring框架下，使用HibernateTemplate从数据库查询所有满足条件的记录，返回结果列表
		//在回调中进行了一次查询（用当前页和页size对查询进行了限制）
		List<Department> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException,SQLException {
				Query query  = session.createQuery("from Department");
				List<Department> list = query.list();
				return list;
			}
		});
		return list;				
	}

	@Override
	public Department findDepartmentByID(int departmentId) {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().get(Department.class,departmentId);
	}

}
