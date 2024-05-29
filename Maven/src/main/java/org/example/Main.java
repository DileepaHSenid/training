package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> myList = new ArrayList <>();
        myList.add("Mathematics");
        myList.add("English");
        myList.add("History");
        Student student = new Student (100,"Jone Doel", 10, myList);

        System.out.println("Id: "+ student.getId());
        System.out.println("Name: "+ student.getName());
        System.out.println("Age: "+ student.getAge());
        System.out.println("Subs: "+ student.getSubjects());

    }
}
