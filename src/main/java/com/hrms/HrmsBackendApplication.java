package com.hrms;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.hrms.entity.Employee;
import com.hrms.repo.EmployeeRepository;
import com.hrms.repo.ProjectsRepository;

@SpringBootApplication
public class HrmsBackendApplication implements CommandLineRunner {

	@Autowired
	private EmployeeRepository empRepo;

	@Autowired
	private ProjectsRepository projectRepo;

	public static void main(String[] args) {
		SpringApplication.run(HrmsBackendApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		Employee employee = this.empRepo.findById(11L).get();
//
//		Employee employee2 = this.empRepo.findById(12L).get();
//
//		Employee employee3 = this.empRepo.findById(13L).get();
//
//		Projects projects = this.projectRepo.findById(1L).get();
//
//		Projects projects2 = this.projectRepo.findById(3L).get();
//
//		if (employee != null && employee2 != null && employee3 != null && projects != null && projects2 != null) {
//			List<Projects> projectList = new ArrayList<>();
//			projectList.add(projects);
//			projectList.add(projects2);
//
//			List<Employee> employeeList = new ArrayList<>();
//			employeeList.add(employee);
//			employeeList.add(employee2);
//			employeeList.add(employee3);
//
//			projects.setEmployee(employeeList);
//			projects2.setEmployee(employeeList);
//
//			employee.setProjects(projectList);
//			employee2.setProjects(projectList);
//			employee3.setProjects(projectList);
//
//			// Save the entities to the database
//			this.projectRepo.save(projects);
//			this.projectRepo.save(projects2);
//
//			this.empRepo.save(employee);
//			this.empRepo.save(employee2);
//			this.empRepo.save(employee3);
//		} else {
//			// Handle the case when entities are not found in the database
//			System.out.println("One or more entities not found in the database.");
//		}

	}

}
