package com.hrms.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.hrms.dto.EmployeeDTO;
import com.hrms.dto.EmployeeForLeaveDTO;
import com.hrms.dto.EmployeeProjectDTO;
import com.hrms.entity.Employee;
import com.hrms.exception.ResourceNotFoundException;
import com.hrms.repo.EmployeeRepository;
import com.hrms.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository repo;

	@Autowired
	private ModelMapper mapper;

	@Override
	public EmployeeDTO createEmployee(MultipartFile profile, MultipartFile appoinmentLetter,
			MultipartFile relivingLetter, MultipartFile experienceLetter, EmployeeDTO dto) throws IOException {

		if (!profile.isEmpty()) {
			String profileUploadDir = "E:\\Railworld India\\HRMS_Backend\\src\\main\\resources\\static\\Profile";
			try {
				String fileExtension = profile.getOriginalFilename()
						.substring(profile.getOriginalFilename().lastIndexOf(".") + 1);
				String filePath = profileUploadDir + File.separator + dto.getEmployeeId() + "_profile" + "."
						+ fileExtension;
				File destFile = new File(filePath);
				profile.transferTo(destFile);

				// Set the image path in the user DTO
				dto.setProfilePath(dto.getEmployeeId() + "_profile" + "." + fileExtension);

			} catch (IOException e) {
				e.printStackTrace();
				throw new IOException("Failed to save the profile: " + e.getMessage());
			}
		}

		if (!appoinmentLetter.isEmpty()) {
			String appointmentUploadDir = "E:\\Railworld India\\HRMS_Backend\\src\\main\\resources\\static\\Appoinment Letter";
			try {
				String fileExtension = appoinmentLetter.getOriginalFilename()
						.substring(appoinmentLetter.getOriginalFilename().lastIndexOf(".") + 1);
				String filePath = appointmentUploadDir + File.separator + dto.getEmployeeId() + "_appoinmentLetter"
						+ "." + fileExtension;
				File destFile = new File(filePath);
				appoinmentLetter.transferTo(destFile);

				// Set the image path in the user DTO
				dto.setAppoinmentLetterPath(dto.getEmployeeId() + "_appoinmentLetter" + "." + fileExtension);

			} catch (IOException e) {
				e.printStackTrace();
				throw new IOException("Failed to save the appointment letter: " + e.getMessage());
			}
		}

		if (!relivingLetter.isEmpty()) {
			String relivingUploadDir = "E:\\Railworld India\\HRMS_Backend\\src\\main\\resources\\static\\Reliving Letter";
			try {
				String fileExtension = relivingLetter.getOriginalFilename()
						.substring(relivingLetter.getOriginalFilename().lastIndexOf(".") + 1);
				String filePath = relivingUploadDir + File.separator + dto.getEmployeeId() + "_relivingLetter" + "."
						+ fileExtension;
				File destFile = new File(filePath);
				relivingLetter.transferTo(destFile);

				// Set the image path in the user DTO
				dto.setRelivingLetterPath(dto.getEmployeeId() + "_relivingLetter" + "." + fileExtension);

			} catch (IOException e) {
				e.printStackTrace();
				throw new IOException("Failed to save the reliving letter: " + e.getMessage());
			}
		}

		if (!experienceLetter.isEmpty()) {
			String experienceUploadDir = "E:\\Railworld India\\HRMS_Backend\\src\\main\\resources\\static\\Experience Letter";
			try {
				String fileExtension = experienceLetter.getOriginalFilename()
						.substring(experienceLetter.getOriginalFilename().lastIndexOf(".") + 1);
				String filePath = experienceUploadDir + File.separator + dto.getEmployeeId() + "_experienceLetter" + "."
						+ fileExtension;
				File destFile = new File(filePath);
				experienceLetter.transferTo(destFile);

				// Set the image path in the user DTO
				dto.setExperienceLetterPath(dto.getEmployeeId() + "_experienceLetter" + "." + fileExtension);

			} catch (IOException e) {
				e.printStackTrace();
				throw new IOException("Failed to save the experience letter: " + e.getMessage());
			}
		}

		Employee mapedEmployee = this.mapper.map(dto, Employee.class);
		mapedEmployee.setPassword(mapedEmployee.getEmployeeId() + "@" + mapedEmployee.getFirstName());
		Employee savedEmp = this.repo.save(mapedEmployee);
		EmployeeDTO map = this.mapper.map(savedEmp, EmployeeDTO.class);

		return map;
	}

	@Override
	public EmployeeDTO updateEmployee(EmployeeDTO emp, Long id) {
		return null;
	}

	@Override
	public EmployeeDTO getEmployee(Long id) {
		Employee employee = this.repo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee", "id", id));
		EmployeeDTO mapDto = this.mapper.map(employee, EmployeeDTO.class);
		return mapDto;
	}

	@Override
	public List<EmployeeDTO> getAllEmployee() {
		List<Employee> allEmployee = this.repo.findAll();
		List<EmployeeDTO> collectedList = allEmployee.stream().map(emp -> {
			EmployeeDTO mapDto = this.mapper.map(emp, EmployeeDTO.class);
			return mapDto;
		}).collect(Collectors.toList());
		return collectedList;
	}

	@Override
	public EmployeeDTO getEmployeeByEmpId(String empId) {
		Employee employee = this.repo.findByEmployeeId(empId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee", "id", empId));
		EmployeeDTO dto = this.mapper.map(employee, EmployeeDTO.class);
		return dto;
	}

	@Override
	public EmployeeProjectDTO getSingleEmployeeWithProject(Long id) {
		Employee employee = this.repo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee", "id", id));
		EmployeeProjectDTO mapped = this.mapper.map(employee, EmployeeProjectDTO.class);
		return mapped;
	}

	@Override
	public List<EmployeeForLeaveDTO> getAllEmployeeDetailsForLeave() {
		List<Employee> findAllEmp = this.repo.findAll();
		List<EmployeeForLeaveDTO> collectted = findAllEmp.stream().map(empLeave -> {
			EmployeeForLeaveDTO mapped = this.mapper.map(empLeave, EmployeeForLeaveDTO.class);
			return mapped;
		}).collect(Collectors.toList());
		return collectted;
	}

	@Override
	public EmployeeForLeaveDTO getEmployeeDetailsForLeave(Long id) {
		Employee employee = this.repo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee", "id", id));
		EmployeeForLeaveDTO mapped = this.mapper.map(employee, EmployeeForLeaveDTO.class);
		return mapped;
	}

	@Override
	public EmployeeDTO updatePassword(Long id, String password) {
		Employee emp = this.repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee", "id", id));
		emp.setPassword(password);
		this.repo.save(emp);
		EmployeeDTO mapped = this.mapper.map(emp, EmployeeDTO.class);
		return mapped;
	}

}
