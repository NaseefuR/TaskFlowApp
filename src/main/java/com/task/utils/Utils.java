package com.task.utils;

import java.security.SecureRandom;
import java.util.List;
import java.util.stream.Collectors;

import com.task.dto.ProjectDTO;
import com.task.dto.TaskDTO;
import com.task.dto.TeamDTO;
import com.task.dto.UserDTO;
import com.task.entity.Project;
import com.task.entity.Task;
import com.task.entity.Team;
import com.task.entity.User;

public class Utils {

    private static final String ALPHANUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final SecureRandom secureRandom = new SecureRandom();

    public static String generatedRandomAlphanumeric(int length) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int randomIndex = secureRandom.nextInt(ALPHANUMERIC_STRING.length());
            char randomChar = ALPHANUMERIC_STRING.charAt(randomIndex);
            stringBuilder.append(randomChar);
        }
        return stringBuilder.toString();
    }

    public static UserDTO mapUserEntityToUserDTO(User user) {
        if (user == null) {
            return null;  // Handle null case to avoid NullPointerException
        }
        
        UserDTO userDto = new UserDTO();
        userDto.setId(user.getId());
        userDto.setEmail(user.getEmail());
        userDto.setDateofbirth(user.getDateofbirth());
        userDto.setFirstname(user.getFirstname());
        userDto.setLastname(user.getLastname());
        userDto.setPhonenumber(user.getPhonenumber());
        userDto.setProfilepicture(user.getProfilepicture());
        userDto.setSubscription(user.getSubscription());

        return userDto;
    }

    public static List<TeamDTO> mapTeamListEntityToTeamDtoList(List<Team> teamList) {
        if (teamList == null || teamList.isEmpty()) {
            return null;
        }
        
        return teamList.stream()
                .map(Utils::mapTeamEntityToTeamDto)
                .collect(Collectors.toList());
    }
    
    public static List<ProjectDTO> mapProjectListEntityToProjectDtoList(List<Project> projectList) {
        if (projectList == null || projectList.isEmpty()) {
            return null;
        }
        
        return projectList.stream()
                .map(Utils::mapProjectEntityToProjectDto)
                .collect(Collectors.toList());
    }

    
    public static TeamDTO mapTeamEntityToTeamDto(Team team) {
        if (team == null) {
            return null;
        }
        
        TeamDTO teamDTO = new TeamDTO();
        teamDTO.setId(team.getId());
        teamDTO.setDescription(team.getDescription());
        teamDTO.setRole(team.getRole());
        teamDTO.setTeamcode(team.getTeamcode());
        teamDTO.setTeamname(team.getTeamname());

        return teamDTO;
    }

	public static ProjectDTO mapProjectEntityToProjectDto(Project project) {
		
		if(project==null) {
			return null;
		}
		
		ProjectDTO projectDTO = new ProjectDTO();
		
		projectDTO.setId(project.getId());
		projectDTO.setEnddate(project.getEnddate());
		projectDTO.setStatus(project.getStatus());
		projectDTO.setPriority(project.getPriority());
		projectDTO.setProjectcode(project.getProjectcode());
		projectDTO.setProjectdescription(project.getProjectdescrption());
		projectDTO.setProjectname(project.getProjectname());
		projectDTO.setStartdate(project.getStartdate());
		
		return projectDTO;
	}
	
	public static TaskDTO mapTaskEntityToTaskDto(Task task) {
		if(task==null) {
			return null;
		}
		
		TaskDTO taskDto = new TaskDTO();
		
		taskDto.setId(task.getId());
		taskDto.setTaskname(task.getTaskname());
		taskDto.setTaskdescription(task.getTaskdescription());
		taskDto.setStatus(task.getStatus());
		taskDto.setPriority(task.getPriority());
		taskDto.setStartdate(task.getStartdate());
		taskDto.setEnddate(task.getEnddate());
		taskDto.setDuration(task.getDuration());
		if(task.getCompletedat()!=null) {
			taskDto.setCompletedat(task.getEnddate());
		}
		
		return taskDto;
	}

}
