package com.hrms.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hrms.dto.LeavesDTO;
import com.hrms.service.EmployeeLeaveService;

@CrossOrigin("*")
@RestController
@RequestMapping("/hr/employee")
public class EmployeeLeaveController {

	@Autowired
	private EmployeeLeaveService leaveService;

	@PostMapping("/addLeave")
	public ResponseEntity<LeavesDTO> addLeave(@RequestParam("documents") MultipartFile document,
			@RequestParam("leaveJson") String leaveJson) throws IOException {
		ObjectMapper obj = new ObjectMapper();
		LeavesDTO employeeLeave = obj.readValue(leaveJson, LeavesDTO.class);
		employeeLeave.setAppliedDate(LocalDate.now());
		LeavesDTO addLeave = this.leaveService.addLeave(document, employeeLeave);
		return new ResponseEntity<LeavesDTO>(addLeave, HttpStatus.CREATED);
	}

	@GetMapping("/getAllLeave")
	public ResponseEntity<List<LeavesDTO>> getAllLeave() {
		List<LeavesDTO> allLeave = this.leaveService.getAllLeave();
		return new ResponseEntity<List<LeavesDTO>>(allLeave, HttpStatus.OK);
	}
}
