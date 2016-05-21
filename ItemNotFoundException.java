package com.basket.manager.exception;

public class ItemNotFoundException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ItemNotFoundException(){}
	
	public ItemNotFoundException(String msg){
		super(msg);
	}

}
