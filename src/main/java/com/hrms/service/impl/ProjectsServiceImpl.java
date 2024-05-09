package com.hrms.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.hrms.dto.ProjectsDTO;
import com.hrms.entity.Projects;
import com.hrms.exception.ResourceNotFoundException;
import com.hrms.repo.ProjectsRepository;
import com.hrms.service.ProjectsService;

@Service
public class ProjectsServiceImpl implements ProjectsService {

	@Autowired
	private ProjectsRepository projectRepo;
	@Autowired
	private ModelMapper mapper;

	@Override
	public ProjectsDTO addProject(MultipartFile file, ProjectsDTO projectDto) throws IOException {
		if (!file.isEmpty()) {
			String fileUploadDir = "E:\\Railworld India\\HRMS_Backend\\src\\main\\resources\\static\\Projects File";
			try {
				String fileExtension = file.getOriginalFilename()
						.substring(file.getOriginalFilename().lastIndexOf(".") + 1);
				String filePath = fileUploadDir + File.separator + projectDto.getProjectId() + "." + fileExtension;
				File destFile = new File(filePath);
				file.transferTo(destFile);

				// Set the file path in the user DTO
				projectDto.setFilePath(projectDto.getProjectId() + "." + fileExtension);

			} catch (IOException e) {
				e.printStackTrace();
				throw new IOException("Failed to save the file: " + e.getMessage());
			}
		}
		Projects projects = this.mapper.map(projectDto, Projects.class);
		Projects savedProject = this.projectRepo.save(projects);
		ProjectsDTO savedDto = this.mapper.map(savedProject, ProjectsDTO.class);
		return savedDto;
	}

	@Override
	public List<ProjectsDTO> getAllProjectDetails() {
		List<Projects> listProjects = this.projectRepo.findAll();
		List<ProjectsDTO> collectedDto = listProjects.stream().map(project -> {
			ProjectsDTO projectsDTO = this.mapper.map(project, ProjectsDTO.class);
			return projectsDTO;
		}).collect(Collectors.toList());
		return collectedDto;

	}

	@Override
	public ProjectsDTO getProject(Long id) {
		Projects projects = this.projectRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Project", "id", id));
		ProjectsDTO projectsDTO = this.mapper.map(projects, ProjectsDTO.class);
		return projectsDTO;
	}

	@Override
	public List<ProjectsDTO> getAllProjectDeatilsDesc() {
		List<Projects> allProjects = this.projectRepo.findAllByOrderByIdDesc();
		List<ProjectsDTO> collectted = allProjects.stream().map(projects -> {
			ProjectsDTO map = this.mapper.map(projects, ProjectsDTO.class);
			return map;
		}).collect(Collectors.toList());
		return collectted;
	}

}
