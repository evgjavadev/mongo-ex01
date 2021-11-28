package com.mongo.example01.todo.controller;

import com.mongo.example01.todo.entity.ToDoModel;
import com.mongo.example01.todo.repository.ToDoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.List;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/todo")
public class TodoController {

    private final ToDoRepository repository;

    @PostMapping("/save")
    public Long save(@RequestBody ToDoModel todo) {
        log.error("Incoming request to save - {}", todo);
        todo.setId(Instant.now().toEpochMilli());
        return this.repository.save(todo).getId();
    }

    @GetMapping
    public List<ToDoModel> getAll() {
        log.error("Incoming request to get all");
        return StreamSupport.stream(
                Spliterators.spliteratorUnknownSize(
                        this.repository.findAll().iterator(),
                        Spliterator.ORDERED),
                false)
                .collect(Collectors.toList());
    }
}
