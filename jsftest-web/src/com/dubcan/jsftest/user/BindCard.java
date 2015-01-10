package com.dubcan.jsftest.user;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.SelectItem;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dubcan.jsftest.card.CardBinder;
import com.dubcan.jsftest.card.CardRegistrar;
import com.dubcan.jsftest.card.CardType;
import com.dubcan.jsftest.card.RegisterCardRequest;
import com.dubcan.jsftest.card.RegisterCardResponse;
import com.dubcan.jsftest.card.RegisterCardResponse.Error;
import com.dubcan.jsftest.card.RegisterCardResponse.Success;

@ManagedBean
@RequestScoped
public class BindCard {
	
	private static final Logger log = LoggerFactory.getLogger(BindCard.class);

	private String name;
	private String surname;
	private String email;
	private String country;

	@EJB
	private CardBinder cardBinder;
	
	@EJB
	private UserRegistrar userRegistrar;
	
	private Map<String, CountryDto> countries;
	private Collection<SelectItem> countriesSelectItems;
	
	public void startBinding() {
		log.info("startBinding starting... ");
		cardBinder.start();
	}
	
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
	
	public void registerUser() {
		userRegistrar.register(new RegisterUserRequest(name, surname, countries.get(country), email));
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
	
	private String number;
	private CardType cardType;
	private Date expired;
	private String cvc;

	@EJB
	CardRegistrar cardRegistrar;

	public CardType getCardType() {
		return cardType;
	}

	public void setCardType(CardType cardType) {
		this.cardType = cardType;
	}

	public String registerCard() {
		log.info("starting... this = {}", this);
		String result = cardRegistrar.register(new RegisterCardRequest(cardType, number, expired, cvc)).accept(
				new RegisterCardResponse.Visitor<String>() {

					@Override
					public String visit(Success response) {
						return "success";
					}

					@Override
					public String visit(Error response) {
						return "error";
					}
				});
		log.info("finished. result = {}", result);
		return "success";
	}
	

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Date getExpired() {
		return expired;
	}

	public void setExpired(Date expired) {
		this.expired = expired;
	}

	public String getCvc() {
		return cvc;
	}

	public void setCvc(String cvc) {
		this.cvc = cvc;
	}
}
