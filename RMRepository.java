package com.example.demo;

import java.util.*;

import org.springframework.data.repository.CrudRepository;

public interface RMRepository extends CrudRepository<RawMaterial, Long>{
	List<RawMaterial> findAll();
	Optional<RawMaterial> findById(Long id);
}
