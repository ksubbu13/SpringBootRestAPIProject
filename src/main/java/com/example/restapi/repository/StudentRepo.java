package com.example.restapi.repository;

import com.example.restapi.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Student,Integer>{

}