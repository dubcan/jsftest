package com.dubcan.jsftest.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

public abstract class AbstractEnumConverter <T extends Enum<T>> implements Converter {

	protected abstract  T getEnum(String name);

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String string) {
		if ("null".equals(string)) {
			return null;
		}
		
		return getEnum(string);
	}
	
	@Override
	public String getAsString(FacesContext context, UIComponent component, Object object) {
		return String.valueOf(object);
	}
}
