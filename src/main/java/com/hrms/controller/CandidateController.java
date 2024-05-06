package com.hrms.controller;

import java.io.IOException;
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
import com.hrms.dto.CandidateDTO;
import com.hrms.service.CandidateService;

@CrossOrigin("*")
@RestController
@RequestMapping("/oms")
public class CandidateController {
	@Autowired
	private CandidateService service;

//	new candidate request
	@PostMapping("/newcandidate")
	public ResponseEntity<CandidateDTO> addCandidate(@RequestParam("resume") MultipartFile resume,
			@RequestParam("jsonFile") String candidateJson) throws IOException {
		ObjectMapper obj = new ObjectMapper();
		CandidateDTO candidateDto = obj.readValue(candidateJson, CandidateDTO.class);
		CandidateDTO newCandidate = this.service.newCandidate(resume, candidateDto);
		return new ResponseEntity<CandidateDTO>(newCandidate, HttpStatus.CREATED);
	}

//	get all candidates
	@GetMapping("/allCandidate")
	public ResponseEntity<List<CandidateDTO>> allCandidates() {
		List<CandidateDTO> allCandidate = this.service.getAllCandidate();
		return new ResponseEntity<List<CandidateDTO>>(allCandidate, HttpStatus.OK);

	}
}
