package com.example.CRUD_application.repository;
import com.example.CRUD_application.model.Student;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface StudentRepository extends JpaRepository<Student,Long>{
    //----------------------
    List<Student> findByYearOfEnrollment(int yearOfEnrollment);

    @Query("SELECT s.department FROM Student s WHERE s.id = :id")
    String findDepartmentByStudentId(@Param("id") Long id);
    
    void deleteByYearOfEnrollment(int yearOfEnrollment);  
    //----------------------
}
