package com.bitcube.University.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bitcube.University.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, String>, ParentRepository{

	@Query(value="SELECT s.student_id FROM student s", nativeQuery=true)
	List<String> findAllId();
}
