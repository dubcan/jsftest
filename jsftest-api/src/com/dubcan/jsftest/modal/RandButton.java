package com.dubcan.jsftest.modal;

public enum RandButton {
	FOO("Foo"), BAR("Bar"), BAZ("Baz");
	
	private final String id;

	private RandButton(String id) {
		if (id == null) {
			throw new NullPointerException("id");
		}
		if (id.isEmpty()) {
			throw new IllegalArgumentException("id is empty");
		}
		this.id = id;
	}
	
	public String getId() {
		return id;
	}
}
