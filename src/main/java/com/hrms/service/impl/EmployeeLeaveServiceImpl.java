package com.hrms.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.hrms.dto.LeavesDTO;
import com.hrms.entity.Leaves;
import com.hrms.repo.EmployeeLeaveRepository;
import com.hrms.service.EmployeeLeaveService;

@Service
public class EmployeeLeaveServiceImpl implements EmployeeLeaveService {

	@Autowired
	private EmployeeLeaveRepository leaveRepo;

	@Autowired
	private ModelMapper mapper;

	@Override
	public List<LeavesDTO> getAllLeave() {
		return this.leaveRepo.findAll().stream()
				.map(employeeLeave -> this.mapper.map(employeeLeave, LeavesDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	public LeavesDTO addLeave(MultipartFile document, LeavesDTO dto) throws IOException {
		if (!document.isEmpty()) {
			String fileUploadDir = "E:\\Railworld India\\HRMS_Backend\\src\\main\\resources\\static\\Leave Documents";
			try {
				String fileExtension = document.getOriginalFilename()
						.substring(document.getOriginalFilename().lastIndexOf(".") + 1);
				String filePath = fileUploadDir + File.separator + dto.getSubject() + "." + fileExtension;
				File destFile = new File(filePath);
				document.transferTo(destFile);

				// Set the file path in the user DTO
				dto.setAttachedDocuments(dto.getSubject() + "." + fileExtension);

			} catch (IOException e) {
				e.printStackTrace();
				throw new IOException("Failed to save the file: " + e.getMessage());
			}
		}
		Leaves employeeLeave = this.mapper.map(dto, Leaves.class);
		Leaves saved = this.leaveRepo.save(employeeLeave);
		LeavesDTO mapped = this.mapper.map(saved, LeavesDTO.class);
		return mapped;
	}

}
