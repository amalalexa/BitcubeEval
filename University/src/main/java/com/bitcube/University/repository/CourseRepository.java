package com.bitcube.University.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bitcube.University.model.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer>{

	@Query(value="SELECT * FROM course c", nativeQuery=true)
	List<Course> findAllRecords();
}
