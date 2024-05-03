package com.hrms.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Jobs {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String title;
	private String department;
	private String openings;
	private String qualification;
	private String skills;
	private String amount;
	private String experience;
	private LocalDate applyDate;
	private String type;
	private String responsibilities;
	private String requirements;
	private String location;

}
