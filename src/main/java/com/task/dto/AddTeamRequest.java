package com.task.dto;

public class AddTeamRequest {
	
	private String email;
	private Long sendBy;
	private Long teamId;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getSendBy() {
		return sendBy;
	}
	public void setSendBy(Long sendBy) {
		this.sendBy = sendBy;
	}
	public Long getTeamId() {
		return teamId;
	}
	public void setTeamId(Long teamId) {
		this.teamId = teamId;
	}
	
}
