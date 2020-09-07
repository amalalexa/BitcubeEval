package com.bitcube.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bitcube.model.Student;

public interface StudentRepository extends JpaRepository<Student, String>{

}
