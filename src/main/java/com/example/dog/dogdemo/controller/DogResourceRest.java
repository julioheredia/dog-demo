package com.example.dog.dogdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dog.dogdemo.dao.DogRepository;
import com.example.dog.dogdemo.model.Dog;

@RestController
public class DogResourceRest {

	@Autowired
	DogRepository dogRepository;

	@RequestMapping("/dogs")
	public List<Dog> getDogs() {
		List<Dog> dogs = (List<Dog>) dogRepository.findAll();
		return dogs;
	}
}
