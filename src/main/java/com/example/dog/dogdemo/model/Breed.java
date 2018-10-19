package com.example.dog.dogdemo.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Breed implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long breedId;
	@Column
	private String descbreed;
	@OneToMany(mappedBy = "breed", fetch = FetchType.EAGER)
	private List<Dog> dogList;

	public Breed() {
		super();
	}

	public Breed(String descbreed) {
		super();
		this.descbreed = descbreed;
	}

	public long getBreedId() {
		return breedId;
	}

	public void setBreedId(long breedId) {
		this.breedId = breedId;
	}

	public String getDescbreed() {
		return descbreed;
	}

	public void setDescbreed(String descbreed) {
		this.descbreed = descbreed;
	}

	@Override
	public String toString() {
		return String.format(descbreed);
	}

	public List<Dog> getDogList() {
		return dogList;
	}

	public void setDogList(List<Dog> dogList) {
		this.dogList = dogList;
	}

}
