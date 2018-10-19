package com.example.dog.dogdemo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dog.dogdemo.dao.BreedRepository;
import com.example.dog.dogdemo.dao.DogRepository;
import com.example.dog.dogdemo.model.Dog;
import com.example.dog.dogdemo.service.DogService;

@Service
public class DogServiceImpl implements DogService {

	@Autowired
	DogRepository dogRepository;

	@Autowired
	BreedRepository breedRepository;

	Dog drica = new Dog();

	@Override
	public void addDogs() {

//		Breed breed = (Breed) breedRepository.findById(1L);
//		drica.setBreed(breed);
//		drica.setName("Adriana 'Drica'");

		dogRepository.save(drica);

		System.out.println("Cards have been added : " + dogRepository.findAll());

	}

}
