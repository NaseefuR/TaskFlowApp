package com.task.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.task.dto.AddTask;
import com.task.dto.Response;
import com.task.service.impl.TaskServiceImpl;

@RestController
@RequestMapping("/task")
public class TaskController {

	@Autowired
	private TaskServiceImpl taskServiceImpl;
	
	@GetMapping("/get-alltask-userid/{userId}")
	public ResponseEntity<Response> getAllTaskUserId(@PathVariable Long userId){
		Response response =taskServiceImpl.getAllTaskByuserId(userId) ;
		return ResponseEntity.status(response.getStatusCode()).body(response);
	}
	
	@GetMapping("/get-alltaskproject/{userId}/{teamId}/{projectId}")
	public ResponseEntity<Response> getAllTaskProjectId(@PathVariable Long userId,@PathVariable Long teamId,@PathVariable Long projectId){
		Response response =taskServiceImpl.getAllTaskByProjectId(userId,teamId,projectId) ;
		return ResponseEntity.status(response.getStatusCode()).body(response);
	}
	
	@GetMapping("/get-today-tasks/{userId}")
	public ResponseEntity<Response> getTodayTasks(@PathVariable Long userId){
		Response response = taskServiceImpl.getTodayTasks(userId);
		return ResponseEntity.status(response.getStatusCode()).body(response);
	}
	
	@PostMapping("/add-task/{userId}/{teamId}/{projectId}")
	public ResponseEntity<Response> addTaskToProjects(@PathVariable Long userId,@PathVariable Long teamId,@PathVariable Long projectId,@RequestBody AddTask task) {
		Response response = taskServiceImpl.addTaskTOProject(userId, projectId, teamId, task);
		return ResponseEntity.status(response.getStatusCode()).body(response);
	}
	
	@PostMapping("/complete-task/{taskId}/{teamId}/{projectId}")
	public ResponseEntity<Response> completeTask(@PathVariable Long taskId,@PathVariable Long teamId,@PathVariable Long projectId){
		Response response = taskServiceImpl.completeTask(taskId,teamId,projectId);
		return ResponseEntity.status(response.getStatusCode()).body(response);
	}
}
