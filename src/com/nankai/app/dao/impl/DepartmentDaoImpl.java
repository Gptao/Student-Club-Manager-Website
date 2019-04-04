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
		//�ҳ����ݿ���������еĲ���
		// ��spring����£�ʹ��HibernateTemplate�����ݿ��ѯ�������������ļ�¼�����ؽ���б�
		//�ڻص��н�����һ�β�ѯ���õ�ǰҳ��ҳsize�Բ�ѯ���������ƣ�
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
