package com.example.CRUD_application.service.impl;

import com.example.CRUD_application.model.Student;
import com.example.CRUD_application.repository.StudentRepository;
import com.example.CRUD_application.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List; 
import java.util.Optional;

@Service 
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    // Save student in the database 
    @Override 
    public Student saveStudent(Student student) { 
        return studentRepository.save(student); 
    }

    // Get all students from the database 
    @Override 
    public List<Student> getAllStudent() { 
        return studentRepository.findAll(); 
    }

    @Override 
    public Student getStudentByID(long id) { 
        Optional<Student> student = studentRepository.findById(id); 
        if (student.isPresent()) { 
            return student.get(); 
        } else { 
            throw new RuntimeException("Student not found with ID: " + id); 
        }
    }

    // Update student 
    @Override 
    public Student updateStudent(Student student, long id) { 
        Student existingStudent = 
        studentRepository.findById(id).orElseThrow( 
            () -> new RuntimeException("Student not found with ID: " + id) 
        ); 
        existingStudent.setFirstName(student.getFirstName()); 
        existingStudent.setLastName(student.getLastName()); 
        existingStudent.setEmail(student.getEmail()); 
        // Save 
        studentRepository.save(existingStudent); 
        return existingStudent; 
    }

    @Override
    public Object getStudentsByYearOfEnrollment(int year) { 
        throw new UnsupportedOperationException("Unimplemented method 'getStudentsByYearOfEnrollment'");
    }
}
