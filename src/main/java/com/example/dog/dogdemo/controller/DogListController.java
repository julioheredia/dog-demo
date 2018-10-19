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

import com.example.dog.dogdemo.dao.DogRepository;
import com.example.dog.dogdemo.model.Dog;

@Scope(value = "session")
@Component(value = "dogList")
@ELBeanName(value = "dogList")
@Join(path = "/listdogs", to = "/dog-list.jsf")
public class DogListController {

	@Autowired
	private DogRepository dogRepository;

	private List<Dog> dogs;

	@Deferred
	@RequestAction
	@IgnorePostback
	public void loadData() {
		dogs = (List<Dog>) dogRepository.findAll();
	}

	public List<Dog> getDogs() {
		return dogs;
	}
}