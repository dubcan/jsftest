package com.dubcan.jsftest.modal;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ManagedBean
@ViewScoped
public class FooModal {

	private boolean nextButtonClicked;
	
	private String firstName;
	private String secondName;
	private String lastName;
	private String country;
	private String city;
	private String street;
	
	@EJB
	private PostModalExecutor postModalExecutor;
	
	
	public void next() {
		log.info("next called. firstName = {}", firstName);
		nextButtonClicked = true;
	}
	
	public void setNextButtonClicked(boolean nextButtonClicked) {
		this.nextButtonClicked = nextButtonClicked;
	}
	
	private static final Logger log = LoggerFactory.getLogger(FooModal.class);
	
	public boolean isNextButtonClicked() {
		log.info("isNextButtonClicked called. firstName = {}", firstName);
		return nextButtonClicked;
	}
	
	public void finish() {
		log.info("finish from FooModel called");
		postModalExecutor.execute(new FooModalData(firstName));
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSecondName() {
		return secondName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}
	
	
	
}
