package com.hrms.entity;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Candidate {
	private Long candidateId;
	private String candidateName;
	private String candidateEmail;
	private String candidateCvPath;

}
