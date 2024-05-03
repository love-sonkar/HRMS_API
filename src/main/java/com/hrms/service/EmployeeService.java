package com.hrms.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.hrms.dto.EmployeeDTO;

public interface EmployeeService {
	EmployeeDTO createEmployee(MultipartFile profile, MultipartFile appoinmentLetter, MultipartFile relivingLetter,
			MultipartFile experienceLetter, EmployeeDTO dto) throws IOException;

	EmployeeDTO updateEmployee(EmployeeDTO dto, Long id);

	EmployeeDTO getEmployee(Long id);

	List<EmployeeDTO> getAllEmployee();

	EmployeeDTO getEmployeeByEmpId(String empId);
}
