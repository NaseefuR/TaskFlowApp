package com.task.dto;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class TeamDTO {
	
	private Long id;
	private String description;
	private String role;
	private String teamcode;
	private String teamname;
	private int teamsize; 
	
	
	private List<ProjectDTO> projectDTO = new ArrayList<>();
	private List<TaskDTO> taskDTO = new ArrayList<>();
	private List<NotificationDTO> notifications = new ArrayList<>();
	
	
	public int getTeamsize() {
		return teamsize;
	}
	public void setTeamsize(int teamsize) {
		this.teamsize = teamsize;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getTeamcode() {
		return teamcode;
	}
	public void setTeamcode(String teamcode) {
		this.teamcode = teamcode;
	}
	public String getTeamname() {
		return teamname;
	}
	public void setTeamname(String teamname) {
		this.teamname = teamname;
	}
	public List<ProjectDTO> getProjectDTO() {
		return projectDTO;
	}
	public void setProjectDTO(List<ProjectDTO> projectDTO) {
		this.projectDTO = projectDTO;
	}
	public List<TaskDTO> getTaskDTO() {
		return taskDTO;
	}
	public void setTaskDTO(List<TaskDTO> taskDTO) {
		this.taskDTO = taskDTO;
	}
	public List<NotificationDTO> getNotifications() {
		return notifications;
	}
	public void setNotifications(List<NotificationDTO> notifications) {
		this.notifications = notifications;
	}

	
	
}
