package com.dubcan.jsftest.registrar.modal;

import javax.ejb.Local;
import javax.ejb.Stateless;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dubcan.jsftest.modal.RandButton;
import com.dubcan.jsftest.modal.RandButtonGenerator;

/**
 * Only for test purposes
 * @author dubcan
 *
 */
@Deprecated
@Stateless
@Local(RandButtonGenerator.class)
public class RandButtonGeneratorEJB implements RandButtonGenerator {

	private static final Logger log = LoggerFactory.getLogger(RandButtonGeneratorEJB.class);
	
	@Override
	public RandButton getRandButton() {
		log.info("starting...");
		//RandButton result = RandButton.values()[(int) (Math.random() * RandButton.values().length)];
		RandButton result = RandButton.FOO; //temporary only for test
		log.info("finished. result = {}", result);
		return result;
	}
}
