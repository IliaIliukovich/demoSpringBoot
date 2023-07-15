package com.telran.demospringboot.service;

import com.telran.demospringboot.model.Student;
import com.telran.demospringboot.repository.DemoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DemoService {

    private final DemoRepository repository;

    @Autowired
    public DemoService(DemoRepository repository) {
        System.out.println("Service bean created");
        this.repository = repository;
    }

    public List<Student> getAllStudents(){
        return repository.getAll();
    }

    public void add(Student student) {
        repository.save(student);
    }

    public Student update(Student student) {
        Optional<Student> first = repository.getAll().stream()
                .filter(s -> s.getName().equals(student.getName())).findFirst();
        if (first.isPresent()) {
            Student studentFromList = first.get();
            studentFromList.setSurname(student.getSurname());
            studentFromList.setAge(student.getAge());
            return studentFromList;
        }
        return null;
    }

    public Student updateAge(String name, Integer age) {
        Optional<Student> first = repository.getAll().stream().filter(s -> s.getName().equals(name)).findFirst();
        if (first.isPresent()) {
            Student student = first.get();
            student.setAge(age);
            return student;
        }
        return null;
    }

    public void deleteByName(String name) {
        repository.deleteByName(name);
    }
}
