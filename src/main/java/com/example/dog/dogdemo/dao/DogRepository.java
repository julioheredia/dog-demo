package com.example.dog.dogdemo.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.dog.dogdemo.model.Dog;

public interface DogRepository extends CrudRepository<Dog, Long> {

}
