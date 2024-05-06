package com.hrms.service.impl;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.hrms.dto.CandidateDTO;
import com.hrms.entity.Candidate;
import com.hrms.repo.CandidateRepository;
import com.hrms.service.CandidateService;

@Service
public class CandidateServiceImpl implements CandidateService {

	@Autowired
	private CandidateRepository candiRepo;

	@Autowired
	private ModelMapper mapper;

	@Override
	public CandidateDTO newCandidate(MultipartFile resume, CandidateDTO dto) throws IOException {
		if (!resume.isEmpty()) {
			String fileUploadDir = "E:\\Railworld India\\HRMS_Backend\\src\\main\\resources\\static\\Candidates";
			try {
				String fileExtension = resume.getOriginalFilename()
						.substring(resume.getOriginalFilename().lastIndexOf(".") + 1);
				String filePath = fileUploadDir + File.separator + dto.getCandidateEmail() + "." + fileExtension;
				File destFile = new File(filePath);
				resume.transferTo(destFile);

				// Set the file path in the user DTO
				dto.setCandidateCvPath(dto.getCandidateEmail() + "." + fileExtension);

			} catch (IOException e) {
				e.printStackTrace();
				throw new IOException("Failed to save the cv: " + e.getMessage());
			}
		}

		Candidate candidate = this.mapper.map(dto, Candidate.class);
		candidate.setAppliedDate(LocalDate.now());
		Candidate savedCandidate = this.candiRepo.save(candidate);
		CandidateDTO mapped = this.mapper.map(savedCandidate, CandidateDTO.class);
		return mapped;
	}

	@Override
	public List<CandidateDTO> getAllCandidate() {
		List<Candidate> allCandidate = this.candiRepo.findAll();
		List<CandidateDTO> collectedCandidate = allCandidate.stream().map(candidate -> {
			CandidateDTO mapped = this.mapper.map(candidate, CandidateDTO.class);
			return mapped;
		}).collect(Collectors.toList());
		return collectedCandidate;
	}

}
