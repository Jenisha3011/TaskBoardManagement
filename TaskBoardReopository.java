package com.example.TaskBoard.repository;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.TaskBoard.model.TaskBoardModel;
public interface TaskBoardReopository extends MongoRepository<TaskBoardModel, String>{

}
