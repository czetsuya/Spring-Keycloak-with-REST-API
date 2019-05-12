package com.broodcamp.business.exception;

/**
 * @author Edward P. Legaspi
 */
public class CustomerNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -3310173336873980506L;

	public CustomerNotFoundException(Long id) {
		super("Could not find customer " + id);
	}

}
