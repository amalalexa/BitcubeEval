package com.bitcube.University.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bitcube.University.model.Degree;

@Repository
public interface DegreeRepository extends JpaRepository<Degree, Integer>{

	@Query(value="SELECT * FROM degree d", nativeQuery=true)
	List<Degree> findAllRecords();
}
