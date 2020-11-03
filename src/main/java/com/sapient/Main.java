package com.sapient;

import com.sapient.service.SapientEmailService;

public class Main {

	public static void main(String[] args) {
		
		SapientEmailService email = new SapientEmailService();
		
		String from="saurav3444@gmail.com";
	   	String  to="saurav3444@gmail.com";
	   	String  text= "Hello world." ;
	   	String  subject="reset password";
		
	   	email.sendEmail(from, to, subject, text);
	   	
	    subject="registration";
		email.sendEmail(from, to, subject, text);
	}
}
