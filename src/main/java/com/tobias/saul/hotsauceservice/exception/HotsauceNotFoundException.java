package com.tobias.saul.hotsauceservice.exception;

public class HotsauceNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5214117250386728712L;
	
	public HotsauceNotFoundException(Long hotsauceId) {
		super("Hot sauce [" + hotsauceId + "] not found.");
	}

	public HotsauceNotFoundException(String name) {
		super("Hot sauce [" + name + "] not found.");
	}

}
