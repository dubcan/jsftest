package com.dubcan.jsftest.user;

import java.util.Collection;

public interface UserRegistrar {
	void register(RegisterUserRequest request);
	
	Collection<CountryDto> getCountries();
}
