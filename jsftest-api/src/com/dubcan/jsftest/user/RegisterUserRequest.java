package com.dubcan.jsftest.user;

import java.io.Serializable;

public class RegisterUserRequest implements Serializable {
	private static final long serialVersionUID = 1L;
	private final String name;
	private final String surname;
	private final CountryDto country;
	private final String email;

	public RegisterUserRequest(String name, String surname, CountryDto country, String email) {
		if (name == null) {
			throw new NullPointerException("name");
		}
		if (name.isEmpty()) {
			throw new IllegalArgumentException("name is empty");
		}
		if (surname == null) {
			throw new NullPointerException("surname");
		}
		if (surname.isEmpty()) {
			throw new IllegalArgumentException("surname is empty");
		}
		if (country == null) {
			throw new NullPointerException("country");
		}
		if (email == null) {
			throw new NullPointerException("email");
		}
		if (email.isEmpty()) {
			throw new IllegalArgumentException("email is empty");
		}
		this.name = name;
		this.surname = surname;
		this.country = country;
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public String getSurname() {
		return surname;
	}

	public CountryDto getCountry() {
		return country;
	}

	public String getEmail() {
		return email;
	}

	@Override
	public String toString() {
		return "UserInfo [name=" + name + ", surname=" + surname + ", country=" + country + ", email=" + email + "]";
	}
}
