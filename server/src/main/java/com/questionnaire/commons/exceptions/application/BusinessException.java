 package com.questionnaire.commons.exceptions.application;


public class BusinessException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3892116817542890495L;

/**
 * 
 * @param e Exception
 */
	public BusinessException(Exception e)
	{
		super(e.getMessage(),e);
	}
	
/**
 * 
 * @param string
 */
	public BusinessException(String string)
	{
		super(string);
		
	}
}
