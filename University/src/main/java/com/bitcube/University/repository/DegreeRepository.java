package com.bitcube.University.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bitcube.University.model.Degree;

@Repository
public interface DegreeRepository extends JpaRepository<Degree, String>, ParentRepository{

	@Query(value="SELECT d.degree_id FROM degree d", nativeQuery=true)
	List<String> findAllId();
}
