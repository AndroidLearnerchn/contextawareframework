package com.contextawareframework.exceptions;
/***************************************************************************************
Test class for how to create a custom exception class before creating the exception class
****************************************************************************************/
public class UserDefined_Exception_Example extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	UserDefined_Exception_Example(String s) {
		      super(s);
		   }
}
		

class Input {
	   void method() throws UserDefined_Exception_Example {
	      throw new UserDefined_Exception_Example("Wrong input");
	   }
	}
	class TestInput {
	   public static void main(String[] args){
	      try {
	         new Input().method();
	      }
		  catch(UserDefined_Exception_Example udee) {
	         System.out.println(udee.getMessage());
	      }
	   }
	}

