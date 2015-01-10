package com.dubcan.jsftest.converter;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dubcan.jsftest.user.UserRegistrar;

@ManagedBean
@RequestScoped	
public class CountryConverter implements Converter {

	private static final Logger log = LoggerFactory.getLogger(CountryConverter.class);
	
	@EJB
	private UserRegistrar userRegistrar; 
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		log.info("getAsObject called. value = {}", value);
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		log.info("getAsString called. value = {}", value);
		return null;
	}

}
