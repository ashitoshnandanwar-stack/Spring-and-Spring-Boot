package com.app.todo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.todo.model.Task;
import com.app.todo.repository.TaskRepository;

@Service
public class TaskService {
	
	
	private final TaskRepository taskRepository ;
	
	
	public TaskService(TaskRepository taskRepository) {
		super();
		this.taskRepository = taskRepository;
	}


	public List<Task> getAllTasks() {
		// TODO Auto-generated method stub
		return taskRepository.findAll();
	}


	public void createTask(String title) {
		// TODO Auto-generated method stub
		
		Task task = new Task();
		task.setTitle(title);
		task.setCompleted(false);
		taskRepository.save(task);
		
	}


	public void deleteTask(long id) {
		// TODO Auto-generated method stub
		taskRepository.deleteById(id);
		
	}


	public void toggleTask(long id) {
		// TODO Auto-generated method stub
		Task task = taskRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid task Id"));
		task.setCompleted(!task.isCompleted());
		taskRepository.save(task);
		
	}

}
