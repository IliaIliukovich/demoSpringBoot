package com.telran.demospringboot.repository;

import com.telran.demospringboot.model.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DemoRepository {

    @Value("${database.name}")
    private String dbName;
    @Value("${database.password}")
    private String dbPassword;

    private List<Student> students;

    public DemoRepository() {
        System.out.println("Repository bean created");
        students = new ArrayList<>();
//        students.add(new Student("Tom", "Werner", 16,
//                new Student("Peter","Petrov", 15),
//                new Faculty("Physics")));
        students.add(new Student("Mary", "Werner", 15));
        students.add(new Student("Jane", "Fox", 14));
        students.add(new Student("Ivan", "Ivanov", 20));
        students.add(new Student("Simon", "Smiths", 21));
    }

    public List<Student> getAll() {
        System.out.println("Repository data from .properties file: " + dbName);
        System.out.println("Repository data from .properties file: " + dbPassword);
        return students;
    }

    public void save(Student student) {
        students.add(student);
    }

    public void deleteByName(String name) {
        students.removeIf(student -> student.getName().equals(name));
    }
}
