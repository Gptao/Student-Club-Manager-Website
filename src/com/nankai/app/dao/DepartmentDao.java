package com.nankai.app.dao;

import java.util.List;

import com.nankai.app.domain.Department;

public interface DepartmentDao {
	public List<Department> findAll();
	public Department findDepartmentByID(int departmentId);
}
