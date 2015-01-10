package com.dubcan.jsftest.registrar.card;

import javax.ejb.Local;
import javax.ejb.Stateless;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dubcan.jsftest.card.CardBinder;

/**
 * Only for test purposes
 * @author dubcan
 *
 */
@Deprecated
@Stateless
@Local(CardBinder.class)
public class CardBinderStubEJB implements CardBinder {

	private static final Logger log = LoggerFactory.getLogger(CardBinderStubEJB.class);
	@Override
	public void start() {
		log.info("starting...");
		log.info("processing...");
		log.info("finished. ");
	}

	@Override
	public void finish() {
		log.info("starting...");
		log.info("processing...");
		log.info("finished. ");
	}
}
