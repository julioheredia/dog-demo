package com.example.dog.dogdemo.controller;

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
import com.example.dog.dogdemo.model.Breed;

@Scope(value = "session")
@Component(value = "breedList")
@ELBeanName(value = "breedList")
@Join(path = "/breedList", to = "/breed-list.jsf")
public class BreedListController {

	@Autowired
	BreedRepository breedRepository;

	private List<Breed> breeds;

	@Deferred
	@RequestAction
	@IgnorePostback
	public void loadData() {
		breeds = (List<Breed>) breedRepository.findAll();
	}

	public List<Breed> getBreeds() {
		return breeds;
	}
}