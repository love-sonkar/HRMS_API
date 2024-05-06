package com.hrms.entity;

import jakarta.persistence.Entity;
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
	private Long candidateId;
	private String candidateName;
	private String candidateEmail;
	private String candidateCvPath;

}
