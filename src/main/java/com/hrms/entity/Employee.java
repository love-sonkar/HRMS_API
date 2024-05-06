package com.hrms.entity;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String employeeId;
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	private LocalDate dob;
	private String maritalStatus;
	private String address;
	private String city;
	private String state;
	private String zipCode;
	private String gender;
	private String nationality;
	private String ctc;
	private String employeeType;
	private String designation;
	private String officeLocation;
	private int days;
	private LocalDate joiningDate;
	private String status;
	private String type;

	private String profilePath;
	private String appoinmentLetterPath;
	private String relivingLetterPath;
	private String experienceLetterPath;

	@ManyToOne
	@JsonBackReference
	private Department department;

	@ManyToMany(cascade = CascadeType.ALL)
	@JsonBackReference
	private List<Projects> projects;
}
