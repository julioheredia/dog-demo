package com.example.dog.dogdemo.controller;

import java.util.ArrayList;
import java.util.List;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.annotation.RequestAction;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.ocpsoft.rewrite.faces.annotation.Deferred;
import org.ocpsoft.rewrite.faces.annotation.IgnorePostback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.example.dog.dogdemo.dao.BreedRepository;
import com.example.dog.dogdemo.dao.DogRepository;
import com.example.dog.dogdemo.model.Breed;
import com.example.dog.dogdemo.model.Dog;

@Scope(value = "session")
@Component(value = "dogController")
@ELBeanName(value = "dogController")
@Join(path = "/dog", to = "/dog-form.jsf")
public class DogController {

	@Autowired
	BreedRepository breedRepository;

	@Autowired
	DogRepository dogRepository;

	private Dog dog = new Dog();
	private List<String> breeds;
	private String descbreed;

	@Deferred
	@RequestAction
	@IgnorePostback
	public void loadData() {
		List<Breed> aux = (List<Breed>) breedRepository.findAll();
		breeds = new ArrayList<String>();
		for (Breed breed : aux) {
			breeds.add(breed.getDescbreed());
		}
	}

	public String save() {
		try {
			Breed breed = breedRepository.findByName(descbreed);
			dog.setBreed(breed);

			dogRepository.save(dog);
			dog = new Dog();
			return "/dog-list.xhtml?faces-redirect=true";

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "/dog-list.xhtml?faces-redirect=true";
	}

	public String getDescbreed() {
		return descbreed;
	}

	public void setDescbreed(String descbreed) {
		this.descbreed = descbreed;
	}

	public List<String> getBreeds() {
		return breeds;
	}

	public Dog getDog() {
		return dog;
	}

}
