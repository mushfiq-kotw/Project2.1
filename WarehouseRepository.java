package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface WarehouseRepository extends CrudRepository<Warehouse, Long>{
	List<Warehouse> findAll();
	Optional<Warehouse> findById(long id);
}