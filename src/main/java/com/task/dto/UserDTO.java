package com.task.dto;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDTO {

	private Long id;
	private String firstname;
	private String lastname;
	private String email;
	private BigInteger phonenumber;
	private String profilepicture;
	private String password;
	private LocalDate dateofbirth;
	
	private String subscription;

	private List<TeamDTO> teamDTO = new ArrayList<>();
	private List<ProjectDTO> projectDTO = new ArrayList<>();
	private List<TaskDTO> taskDTO = new ArrayList<>();
	private List<NotificationDTO> notifications = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public BigInteger getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(BigInteger phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getProfilepicture() {
		return profilepicture;
	}

	public void setProfilepicture(String profilepicture) {
		this.profilepicture = profilepicture;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LocalDate getDateofbirth() {
		return dateofbirth;
	}

	public void setDateofbirth(LocalDate dateofbirth) {
		this.dateofbirth = dateofbirth;
	}

	public List<TeamDTO> getTeamDTO() {
		return teamDTO;
	}

	public void setTeamDTO(List<TeamDTO> teamDTO) {
		this.teamDTO = teamDTO;
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

	public String getSubscription() {
		return subscription;
	}

	public void setSubscription(String subscription) {
		this.subscription = subscription;
	}
	
	

}
