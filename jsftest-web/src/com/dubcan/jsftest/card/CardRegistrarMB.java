package com.dubcan.jsftest.card;

import java.util.Date;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dubcan.jsftest.card.RegisterCardResponse.Error;
import com.dubcan.jsftest.card.RegisterCardResponse.Success;

@ManagedBean
@RequestScoped
public class CardRegistrarMB {

	private static final Logger log = LoggerFactory.getLogger(CardRegistrarMB.class);

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

	public String register() {
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

	@Override
	public String toString() {
		return "CardRegistrarMB [number=" + number + ", cardType=" + cardType + ", expired=" + expired + ", cvc=" + cvc
				+ "]";
	}

}
