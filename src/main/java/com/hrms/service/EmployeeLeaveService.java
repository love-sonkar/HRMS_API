package com.hrms.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.hrms.dto.LeavesDTO;

public interface EmployeeLeaveService {
	LeavesDTO addLeave(MultipartFile document, LeavesDTO dto) throws IOException;

	List<LeavesDTO> getAllLeave();
}
