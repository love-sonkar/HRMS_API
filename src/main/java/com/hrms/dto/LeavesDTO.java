package com.hrms.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LeavesDTO {
	private Long id;
	private String subject;
	private String leaveDetails;
	private String attachedDocuments;
	private LocalDate appliedDate;
}
