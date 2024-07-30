package com.example.taskboard;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskBoardService {
	@Autowired
private TaskBoardRepository repository;
    
	public List<TaskBoard> getAllTaskBoards() {
	    return repository.findAll();
	  }
	  
	  public TaskBoard getTaskBoardById(String id) {
	    return repository.findById(id).orElse(null);
	  }
	  
	  public TaskBoard createTaskBoard(TaskBoard taskBoard) {
	    return repository.save(taskBoard);
	  }
	  
	  public TaskBoard updateTaskBoard(String id, TaskBoard taskBoard) {
	    TaskBoard existingTaskBoard = repository.findById(id).orElse(null);
	    if (existingTaskBoard != null) {
	      existingTaskBoard.setTaskId(taskBoard.getTaskId());
	      // Update other fields as needed
	      return repository.save(existingTaskBoard);
	    }
	    return null;
	  }
	  
	  public void deleteTaskBoard(String id) {
	    repository.deleteById(id);
	  }
	}


