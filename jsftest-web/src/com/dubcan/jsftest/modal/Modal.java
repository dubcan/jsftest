package com.dubcan.jsftest.modal;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@ManagedBean
@RequestScoped
public class Modal {
	
	private static final String MAIN_MODAL = "main_modal";
	@EJB
	RandButtonGenerator randButtonGenerator;
	
	private String randButtonTitle;
	
	private static final Logger log = LoggerFactory.getLogger(Modal.class);
	
	public String getMainModal() {
		randButtonTitle = randButtonGenerator.getRandButton().getId();
		log.info("randButtonTitle = {}", randButtonTitle);
		return MAIN_MODAL;
	}
	
	public String getRandButtonTitle() {
		return randButtonTitle;
	}
	
	public void setRandButtonTitle(String randButtonTitle) {
		this.randButtonTitle = randButtonTitle;
	}
}
