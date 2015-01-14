package com.dubcan.jsftest.registrar.modal;

import javax.ejb.Local;
import javax.ejb.Stateless;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dubcan.jsftest.modal.ModalData;
import com.dubcan.jsftest.modal.PostModalExecutor;

/**
 * Only for test purposes
 * @author dubcan
 *
 */
@Deprecated
@Stateless
@Local(PostModalExecutor.class)
public class PostModalExecutorEJB implements PostModalExecutor {

	private static final Logger log = LoggerFactory.getLogger(PostModalExecutorEJB.class);
	
	@Override
	public void execute(ModalData data) {
		log.info("execute starting... {}", data);
		//TODO some logic here
		log.info("finished. result");
	}

}
