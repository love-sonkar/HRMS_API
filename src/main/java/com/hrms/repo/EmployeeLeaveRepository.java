package com.hrms.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hrms.entity.Leaves;

public interface EmployeeLeaveRepository extends JpaRepository<Leaves, Long>{

}
