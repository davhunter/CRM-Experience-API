package com.deloitte.crm.exceptions;

import org.mule.module.apikit.exception.BadRequestException;

/**
 * Raised for parts of the API that haven't yet been implemented
 * 
 * @author David Hunter (Deloitte)
 *
 */
public class APINotImplementedException extends BadRequestException {	
	public APINotImplementedException(String message) {
		super(message);
	}

	private static final long serialVersionUID = 1L;
}
