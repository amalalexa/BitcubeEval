package com.bitcube.University.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bitcube.University.dao.StudentDetailsDao;
import com.bitcube.University.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, String>, ParentRepository{

	@Query(value="SELECT s.student_id FROM student s", nativeQuery=true)
	List<String> findAllId();
	
	
	@Query("SELECT new com.bitcube.University.dao.StudentDetailsDao(s.studentId,s.fullName) FROM Student s where s.degree.degreeId = :degree_id")
	List<StudentDetailsDao> findSudentDetails(@Param("degree_id") String degreeId);
	
}
