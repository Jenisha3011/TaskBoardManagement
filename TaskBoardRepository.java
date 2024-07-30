package com.example.taskboard;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface TaskBoardRepository extends MongoRepository<TaskBoard, String> {
}


