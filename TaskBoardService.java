package com.example.TaskBoard.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.TaskBoard.model.TaskBoardModel;
import com.example.TaskBoard.repository.TaskBoardReopository;

@Service
public class TaskBoardService {
	@Autowired
	private TaskBoardReopository repository;
	
	public List<TaskBoardModel> findAll() {
		return repository.findAll();
	}
	
	public TaskBoardModel findById(String id) {
		return repository.findById(id).orElseThrow();
	}
	
	public TaskBoardModel save(TaskBoardModel taskBoard) {
		return repository.save(taskBoard);
	}
	
	public void deleteById(String id) {
		repository.deleteById(id);
	}
}



