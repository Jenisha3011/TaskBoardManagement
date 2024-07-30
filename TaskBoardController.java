package com.example.taskboard;

import java.util.List;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/taskboards")
public class TaskBoardController {
private TaskBoardService service;
    
    @GetMapping
    public List<TaskBoard> getAllTaskBoards() {
        return service.getAllTaskBoards();
      }
      
      @GetMapping("/{id}")
      public TaskBoard getTaskBoardById(@PathVariable String id) {
        return service.getTaskBoardById(id);
      }
      
      @PostMapping
      public TaskBoard createTaskBoard(@RequestBody TaskBoard taskBoard) {
        return service.createTaskBoard(taskBoard);
      }
      
      @PatchMapping("/{id}")
      public TaskBoard updateTaskBoard(@PathVariable String id, @RequestBody TaskBoard taskBoard) {
        return service.updateTaskBoard(id, taskBoard);
      }
      
      @DeleteMapping("/{id}")
      public void deleteTaskBoard(@PathVariable String id) {
        service.deleteTaskBoard(id);
      }
    }


	


