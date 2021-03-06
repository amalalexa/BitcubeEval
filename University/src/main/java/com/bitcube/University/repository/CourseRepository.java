package com.bitcube.University.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bitcube.University.model.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, String>, ParentRepository{

	@Query(value="SELECT c.course_id FROM course c", nativeQuery=true)
	List<String> findAllId();
	
	@Query(value="SELECT * FROM course c where c.degree_id = :degree_id",nativeQuery=true)
	List<Course> findAllCourseBasedOnDegreeId(@Param("degree_id") String degreeId);
}
