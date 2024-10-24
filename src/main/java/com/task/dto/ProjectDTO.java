package com.task.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ProjectDTO {

	private Long id;
	private LocalDate startdate;
	private LocalDate enddate;
	private String priority;
	private String projectcode;
	private String projectdescription;
	private String projectname;
	private String status;
	private int projectteamsize;
	private int projectprogress;
	
	private List<TaskDTO> taskDTO = new ArrayList<>();
	private List<NotificationDTO> notifications = new ArrayList<>();
	
	
	public int getProjectprogress() {
		return projectprogress;
	}
	public void setProjectprogress(int projectprogress) {
		this.projectprogress = projectprogress;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	
	public int getProjectteamsize() {
		return projectteamsize;
	}
	public void setProjectteamsize(int projectteamsize) {
		this.projectteamsize = projectteamsize;
	}
	public LocalDate getStartdate() {
		return startdate;
	}
	public void setStartdate(LocalDate startdate) {
		this.startdate = startdate;
	}
	public LocalDate getEnddate() {
		return enddate;
	}
	public void setEnddate(LocalDate enddate) {
		this.enddate = enddate;
	}
	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}
	public String getProjectcode() {
		return projectcode;
	}
	public void setProjectcode(String projectcode) {
		this.projectcode = projectcode;
	}
	public String getProjectdescription() {
		return projectdescription;
	}
	public void setProjectdescription(String projectdescription) {
		this.projectdescription = projectdescription;
	}
	public String getProjectname() {
		return projectname;
	}
	public void setProjectname(String projectname) {
		this.projectname = projectname;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
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
