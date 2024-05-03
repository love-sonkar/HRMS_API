package com.hrms.service;

import java.util.List;

import com.hrms.dto.DepartmentDTO;

public interface DepartmentService {
	DepartmentDTO createDepartmant(DepartmentDTO departmentDto);

	List<DepartmentDTO> getAllDepartment();

	DepartmentDTO getDepartment(Long id);
}
