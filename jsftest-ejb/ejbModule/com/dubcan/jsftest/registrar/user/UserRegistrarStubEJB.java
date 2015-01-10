package com.dubcan.jsftest.registrar.user;

import java.util.ArrayList;
import java.util.Collection;

import javax.ejb.Local;
import javax.ejb.Stateless;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dubcan.jsftest.user.CountryDto;
import com.dubcan.jsftest.user.RegisterUserRequest;
import com.dubcan.jsftest.user.UserRegistrar;

/**
 * Only for test purposes
 * @author dubcan
 *
 */
@Deprecated
@Stateless
@Local(UserRegistrar.class)
public class UserRegistrarStubEJB implements UserRegistrar {
	private static final Logger log = LoggerFactory.getLogger(UserRegistrarStubEJB.class);
	
	@Override
	public void register(RegisterUserRequest request) {
		log.info("save user info to DB " + request);
	}

	@Override
	public Collection<CountryDto> getCountries() {
		log.info("starting...");
		//get from db...
		Collection<CountryDto> c = new ArrayList<>();
		c.add(new CountryDto("RU", "Russia"));
		c.add(new CountryDto("US", "USA"));
		c.add(new CountryDto("UK", "UK"));
		log.info("finished. result = {}", c);
		return c;
	}
}
