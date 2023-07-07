package com.telran.demospringboot.controller;

import com.telran.demospringboot.model.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(("/app"))
public class DemoController {

    private List<Student> students;

    public DemoController() {
        students = new ArrayList<>();
        students.add(new Student("Tom", "Werner", 16));
        students.add(new Student("Mary", "Werner", 15));
        students.add(new Student("Jane", "Fox", 14));
        students.add(new Student("Ivan", "Ivanov", 20));
        students.add(new Student("Simon", "Smiths", 21));
    }

    @GetMapping("/all")
    public List<Student> findAll(){
        return students;
    }

    @PostMapping("/add")
    public void add(@RequestBody Student student){
        students.add(student);
    }

    @PutMapping("/add")
    public ResponseEntity<Student> update(@RequestBody Student student){
        Optional<Student> first = students.stream().filter(student1 -> student1.getName().equals(student.getName())).findFirst();
        if (first.isPresent()){
            Student studentFromList = first.get();
            studentFromList.setSurname(student.getSurname());
            studentFromList.setAge(student.getAge());
            return new ResponseEntity<>(studentFromList, HttpStatus.ACCEPTED);
        } else {
           return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PatchMapping("/add")
    public ResponseEntity<Student> updateAge(@RequestParam String name, @RequestParam Integer age){
        Optional<Student> first = students.stream().filter(student1 -> student1.getName().equals(name)).findFirst();
        if (first.isPresent()) {
            Student student = first.get();
            student.setAge(age);
            return new ResponseEntity<>(student, HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/delete/{name}")
    public void delete(@PathVariable String name){
        students.removeIf(student -> student.getName().equals(name));
    }

}
