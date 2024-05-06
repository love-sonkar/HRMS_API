package com.hrms.dto;

import java.time.LocalDate;

import com.hrms.entity.Department;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {
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

	private Department department;

}
