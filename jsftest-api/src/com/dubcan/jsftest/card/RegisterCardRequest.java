package com.dubcan.jsftest.card;

import java.io.Serializable;
import java.util.Date;

public class RegisterCardRequest implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private final String number;
	private final Date expired;
	private final String cvc;
	private final CardType type;
	
	public RegisterCardRequest(CardType type, String number, Date expired, String cvc) {
		if (type == null) {
			throw new NullPointerException("type");
		}
		if (number == null) {
			throw new NullPointerException("number");
		}
		if (number.isEmpty()) {
			throw new IllegalArgumentException("number is empty");
		}
		if (expired == null) {
			throw new NullPointerException("expired");
		}
		if (cvc == null) {
			throw new NullPointerException("cvc");
		}
		if (cvc.isEmpty()) {
			throw new IllegalArgumentException("cvc is empty");
		}
		this.type = type;
		this.number = number;
		this.expired = expired;
		this.cvc = cvc;
	}
	
	public CardType getType() {
		return type;
	}
	
	public String getNumber() {
		return number;
	}
	
	public Date getExpired() {
		return expired;
	}
	
	public String getCvc() {
		return cvc;
	}

	@Override
	public String toString() {
		return "RegisterCardRequest [number=" + number + ", expired=" + expired + ", cvc=" + cvc + ", type=" + type
				+ "]";
	}
}
