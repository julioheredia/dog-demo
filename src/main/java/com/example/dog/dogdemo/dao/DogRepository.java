package com.example.dog.dogdemo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.dog.dogdemo.model.Dog;

public interface DogRepository extends CrudRepository<Dog, Long> {

	@Query("select dog from Breed b inner join b.dogList as dog where b.descbreed = :descbreed ")
	List<Dog> findDogByBreed(@Param("descbreed") String descbreed);

}
