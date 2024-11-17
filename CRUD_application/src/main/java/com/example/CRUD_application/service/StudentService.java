package com.example.CRUD_application.service;
import com.example.CRUD_application.model.Student;
import java.util.List;

public interface StudentService {
    Student saveStudent(Student student);
    List<Student> getAllStudent();
    Student getStudentByID(long id);
    Student updateStudent(Student student,long id);
    Object getStudentsByYearOfEnrollment(int year);   
}
