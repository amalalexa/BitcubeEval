package com.bitcube.University.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bitcube.University.model.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, String>, ParentRepository{

	@Query(value="SELECT c.course_id FROM course c", nativeQuery=true)
	List<String> findAllId();
}
