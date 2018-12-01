package com.example.dog.dogdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.dog.dogdemo.dao.DogRepository;
import com.example.dog.dogdemo.model.Dog;

@RestController
public class DogResourceRest {

	@Autowired
	DogRepository dogRepository;

	@RequestMapping("/dogs")
	public List<Dog> getDogs() {
		return (List<Dog>) dogRepository.findAll();
	}

	@RequestMapping("/dogsByBreed")
	public List<Dog> getDogByBreed(@RequestParam(value = "descbreed", defaultValue = "breed") String descbreed) {
		return dogRepository.findDogByBreed(descbreed);
	}
}
