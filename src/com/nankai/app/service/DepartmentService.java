package com.nankai.app.service;

import java.util.List;

import com.nankai.app.domain.Department;

public interface DepartmentService {
	public List<Department> findAll();
	public Department findDepartmentByID(int departmentId);
}
