package com.example.TaskBoard.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.TaskBoard.model.TaskBoardModel;
import com.example.TaskBoard.service.TaskBoardService;

@RestController
@RequestMapping("/api/taskboard")
public class TaskBoardController {
	@Autowired
	private TaskBoardService service;
	
	@GetMapping
	public List<TaskBoardModel> getAllTaskBoards() {
		return service.findAll();
	}
	
	@GetMapping("/{id}")
	public TaskBoardModel getTaskBoardById(@PathVariable String id) {
		return service.findById(id);
	}
	
	@PostMapping
	public TaskBoardModel createTaskBoard(@RequestBody TaskBoardModel taskBoard) {
		return service.save(taskBoard);
	}
	
	@PutMapping("/{id}")
	public TaskBoardModel updateTaskBoard(@PathVariable String id, @RequestBody TaskBoardModel taskBoard) {
		TaskBoardModel existing = service.findById(id);
		existing.setTaskStatus(taskBoard.getTaskStatus());
		existing.setActualTime(taskBoard.getActualTime());
		existing.setComments(taskBoard.getComments());
		return service.save(existing);
	}
	
	@DeleteMapping("/{id}")
	public void deleteTaskBoard(@PathVariable String id) {
		service.deleteById(id);
	}
}


