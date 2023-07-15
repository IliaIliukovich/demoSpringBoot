package com.telran.demospringboot.controller;

import com.telran.demospringboot.model.Student;
import com.telran.demospringboot.service.DemoService;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(("/app"))
public class DemoController {

    private final DemoService service;

//    @Autowired
//    public void setService(DemoService service) {
//        this.service = service;
//    }

    @Autowired
    public DemoController(DemoService service) {
        System.out.println("Controller bean created");
        this.service = service;
    }

    @PostConstruct
    public void initDemoMethod(){
        System.out.println("Controller init method called");
    }

    @PreDestroy
    public void destroyDemoMethod(){
        System.out.println("Controller destroy method called");
    }

    @GetMapping("/all")
//    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Student> findAll(){
        return service.getAllStudents();
    }

    @PostMapping("/add")
    public void add(@RequestBody Student student){
        service.add(student);
    }

    @PutMapping("/add")
    public ResponseEntity<Student> update(@RequestBody Student student){
        Student updated = service.update(student);
        if (updated != null) {
            return new ResponseEntity<>(updated, HttpStatus.ACCEPTED);
        } else {
           return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PatchMapping("/add")
    public ResponseEntity<Student> updateAge(@RequestParam String name, @RequestParam Integer age){
        Student updated = service.updateAge(name, age);
        if (updated != null) {
            return new ResponseEntity<>(updated, HttpStatus.ACCEPTED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{name}")
    public void delete(@PathVariable String name){
        service.deleteByName(name);
    }

}
