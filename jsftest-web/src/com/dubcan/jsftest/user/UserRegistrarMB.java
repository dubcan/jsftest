package com.dubcan.jsftest.user;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.SelectItem;

@ManagedBean
@RequestScoped
public class UserRegistrarMB {

	private String name;
	private String surname;
	private String email;
	private String country;

	@EJB
	private UserRegistrar userRegistrar;
	
	private Map<String, CountryDto> countries;
	private Collection<SelectItem> countriesSelectItems;
	
	@PostConstruct
	public void init() {
		countries = new HashMap<>();
		for (CountryDto country : userRegistrar.getCountries()) {
			countries.put(country.getId(), country);
		}
		
		countriesSelectItems = new ArrayList<>();
		for (CountryDto countryDto : countries.values()) {
			countriesSelectItems.add(new SelectItem(countryDto.getId(), countryDto.getTitle()));
		}
	}
	
	public Collection<SelectItem> getCountriesSelectItems() {
		return countriesSelectItems;
	}
	
	public Map<String, CountryDto> getCountries() {
		return countries;
	}
	
	public String register() {
		userRegistrar.register(new RegisterUserRequest(name, surname, countries.get(country), email));
		return "registerCard";
	}
	
	public String getCountry() {
		return country;
	}
	
	public void setCountry(String country) {
		this.country = country;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
