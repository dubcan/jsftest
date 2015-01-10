package com.dubcan.jsftest.card;

public enum CardType {
	VISA("visa"), MASTERCARD("mastercard");
	private String title;

	private CardType(String title) {
		this.title = title;
	}
	
	public String getTitle() {
		return title;
	}
}
