package com.hrms.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.hrms.dto.ProjectsDTO;
import com.hrms.service.ProjectsService;

@CrossOrigin("*")
@RestController
@RequestMapping("/hr/projects")
public class ProjectsController {

	@Autowired
	private ProjectsService service;

//	add new project
	@PostMapping("/add")
	public ResponseEntity<ProjectsDTO> addProject(@RequestParam("file") MultipartFile file,
			@RequestParam("projectJson") String project) throws IOException {

		ObjectMapper obj = new ObjectMapper();
		obj.registerModule(new JavaTimeModule());
		obj.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
		ProjectsDTO projectsDto = obj.readValue(project, ProjectsDTO.class);
		ProjectsDTO addProject = this.service.addProject(file, projectsDto);
		return new ResponseEntity<ProjectsDTO>(addProject, HttpStatus.CREATED);
	}

//	get all projects details
	@GetMapping("/getAllProject")
	public ResponseEntity<List<ProjectsDTO>> getAllProject() {
		List<ProjectsDTO> allProjectDetails = this.service.getAllProjectDetails();
		return new ResponseEntity<List<ProjectsDTO>>(allProjectDetails, HttpStatus.OK);
	}

//	get single project details
	@GetMapping("/getProject/{id}")
	public ResponseEntity<ProjectsDTO> getProject(@PathVariable Long id) {
		ProjectsDTO project = this.service.getProject(id);
		return new ResponseEntity<ProjectsDTO>(project, HttpStatus.OK);
	}

}
