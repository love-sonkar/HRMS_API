package com.hrms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hrms.dto.DepartmentDTO;
import com.hrms.service.DepartmentService;

@RestController
@RequestMapping("/hr/department")
public class DepartmentController {

	@Autowired
	private DepartmentService service;

	@PostMapping("/add")
	public ResponseEntity<DepartmentDTO> addDepartment(@RequestBody DepartmentDTO departmentDto) {
		DepartmentDTO createDepartmant = this.service.createDepartmant(departmentDto);
		return new ResponseEntity<>(createDepartmant, HttpStatus.CREATED);
	}

}
