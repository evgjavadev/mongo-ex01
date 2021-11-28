package com.mongo.example01.todo.repository;

import com.mongo.example01.todo.entity.ToDoModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ToDoRepository extends CrudRepository<ToDoModel, Long> {
    List<ToDoModel> findAllByOrderByPriority();

    List<ToDoModel> findAllByPriority(int priority);
}
