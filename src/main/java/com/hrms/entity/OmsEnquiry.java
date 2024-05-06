package com.hrms.entity;

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
public class OmsEnquiry {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long enqId;
	private String name;
	private String email;
	private String subject;
	private String description;

}
