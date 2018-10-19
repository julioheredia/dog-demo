package com.example.dog.dogdemo.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.dog.dogdemo.model.Breed;

public interface BreedRepository extends CrudRepository<Breed, Long> {

	@Query("select b from Breed b where b.descbreed = :descbreed ")
	Breed findByName(@Param("descbreed") String descbreed);

}
