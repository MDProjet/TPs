package model;

import exception.ExceptionCreation;



public class CaseFactory {
	
	public static ICase getCase(EnumCase type) throws ExceptionCreation{
		ICase c;
		if(type.equals(EnumCase.SIMPLE_CASE)){
			c= new Case();
		}else{
			throw new ExceptionCreation(type.toString());
		}
		return c;
	}
	
	
}
	