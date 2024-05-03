package com.hrms.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hrms.entity.Projects;

@Repository
public interface ProjectsRepository extends JpaRepository<Projects, Long> {

}
