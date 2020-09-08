package com.bitcube.University.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bitcube.University.model.Lecturer;

@Repository
public interface LecturerRepository extends JpaRepository<Lecturer, Integer> {
	
	@Query(value="SELECT * FROM lecturer l", nativeQuery=true)
	List<Lecturer> findAllRecords();
}
