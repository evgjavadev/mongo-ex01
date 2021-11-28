package com.mongo.example01.todo.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@NoArgsConstructor
@Getter
@Setter
public class ToDoModel {

    @Id
    private Long id;
    private String name;
    private String description;
    private int priority;

    @Override
    public String toString() {
        return "ToDoModel:" +
                " name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", priority=" + priority;
    }
}
