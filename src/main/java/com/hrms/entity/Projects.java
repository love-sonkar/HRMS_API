package com.hrms.entity;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Projects {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String clientName;
	private String companyName;
	private String phoneNumber;
	private String emailId;
	private String countryName;
	private String projectStatus;

	private String projectTitle;
	private String projectId;
	private String projectManager;
	private int teamSize;
	private String usedFor;
	private LocalDate startDate;
	private LocalDate endDate;

	private String description;
	private String technologyUsed;
	private String skillsRequired;

	private String filePath;

	@ManyToMany(mappedBy = "projects", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Employee> employee;
}
