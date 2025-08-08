package com.taskmanager.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.taskmanager.model.Task;
import com.taskmanager.repository.TaskRepository;

@Service
public class TaskService {
	
	private final TaskRepository taskRepository;
	
	public TaskService(TaskRepository taskRepository) {
		this.taskRepository = taskRepository;
	}
	
	public Task createTask(Task task) {
		return taskRepository.save(task);
	}
	
	public List<Task> getAllTasks() {
		return taskRepository.findAll();
	}
	
	public Optional<Task> getTaskById(Long id) {
		return taskRepository.findById(id);
	}
	
	public Optional<Task> updateTask(Long id, Task updatedTask) {
		return taskRepository.findById(id).map(task -> {
			task.setName(updatedTask.getName());
			task.setDueDate(updatedTask.getDueDate());
			task.setResponsible(updatedTask.getResponsible());
			return taskRepository.save(task);
		});
	}
	
	public boolean deleteTask(Long id) {
		if (taskRepository.existsById(id)) {
			taskRepository.deleteById(id);
			return true;
		}
		return false;
	}

}
