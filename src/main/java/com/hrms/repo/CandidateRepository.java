package com.hrms.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hrms.entity.Candidate;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate, Long> {
	List<Candidate> findAllByOrderByCandidateIdDesc();
}
