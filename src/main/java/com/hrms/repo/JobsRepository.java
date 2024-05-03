package com.hrms.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hrms.entity.Jobs;

@Repository
public interface JobsRepository extends JpaRepository<Jobs, Long> {

}
