package com.hrms.entity;

import java.time.LocalDate;

import com.hrms.enums.CandidateStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Candidate {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long candidateId;
	private String candidateName;
	private String candidateEmail;
	private String candidateContactNumber;
	private String appliedFor;
	private String candidateCvPath;
	private LocalDate appliedDate;
	private CandidateStatus status;
	

}
