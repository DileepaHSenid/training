package org.example;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class Student {
    private int id;
    private String name;
    private int age;
    private List<String> subjects;

    public Student(int id, String name, int age, List<String> subjects) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.subjects = subjects;
    }
}
