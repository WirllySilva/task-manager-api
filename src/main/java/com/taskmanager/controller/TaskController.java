package com.taskmanager.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.taskmanager.model.Task;
import com.taskmanager.service.TaskService;

@RestController
@RequestMapping("/task")
public class TaskController {
	
	private final TaskService taskService;
	
	public TaskController(TaskService taskService) {
		this.taskService =taskService;
	}
	
	@PostMapping
	public ResponseEntity<Task> creatTask(@RequestBody Task task) {
		Task savedTask = taskService.createTask(task);
		return ResponseEntity.ok(savedTask);
	}
	
	@GetMapping
	public ResponseEntity<List<Task>> getAllTasks() {
		return ResponseEntity.ok(taskService.getAllTasks());
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Task> getTaskById(@PathVariable Long id) {
		return taskService.getTaskById(id)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
		if (taskService.deleteTask(id)) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
	}

}
