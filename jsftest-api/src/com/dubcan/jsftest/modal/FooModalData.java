package com.dubcan.jsftest.modal;

public class FooModalData implements ModalData {
	private static final long serialVersionUID = 1L;
	private final String firstName;

	public FooModalData(String firstName) {
		if (firstName == null) {
			throw new NullPointerException("firstName");
		}
		if (firstName.isEmpty()) {
			throw new IllegalArgumentException("firstName is empty");
		}
		this.firstName = firstName;
	}
	
	public String getFirstName() {
		return firstName;
	}

	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}

	@Override
	public String toString() {
		return "FooModalData [firstName=" + firstName + "]";
	}
}
