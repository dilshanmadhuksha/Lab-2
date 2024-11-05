package com.example.CRUD_application.controller;

import com.example.CRUD_application.model.Student; 
import com.example.CRUD_application.service.StudentService; 
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.http.HttpStatus; 
import org.springframework.http.ResponseEntity; 
import org.springframework.web.bind.annotation.*;

import java.util.List; 

@RestController 
@RequestMapping("/api/student") 
@CrossOrigin(origins = "*") 
public class StudentCotroller {

    @Autowired 
    private StudentService studentService; 
    @PostMapping 
    public ResponseEntity<Student> saveStudent(@RequestBody Student 
    student){ 
        return new 
    ResponseEntity<Student>(studentService.saveStudent(student), 
    HttpStatus.CREATED); 
    }

    //GetAll Rest Api 
    @GetMapping public List<Student> getAllStudent(){ 
        return studentService.getAllStudent(); 
        } 
        //Get by Id Rest Api 
        @GetMapping("{id}") 
        // localhost:8080/api/student/1 
        public ResponseEntity<Student> getStudentByID(@PathVariable("id") long 
        studentID){ 
            return new 
        ResponseEntity<Student>(studentService.getStudentByID(studentID),HttpStatus.OK); }

        //Update Rest Api

        @PutMapping("{id}") 
        public ResponseEntity<Student> updateStudent(@PathVariable("id") long id, 
        @RequestBody Student student){ 
            return new 
            ResponseEntity<Student>(studentService.updateStudent(student,id),HttpStatus.OK); 
            } 
            }
