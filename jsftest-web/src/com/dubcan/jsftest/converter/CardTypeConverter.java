package com.dubcan.jsftest.converter;

import com.dubcan.jsftest.card.CardType;

public class CardTypeConverter extends AbstractEnumConverter<CardType> {

	@Override
	protected CardType getEnum(String name) {
		return Enum.valueOf(CardType.class, name);
	}
}
