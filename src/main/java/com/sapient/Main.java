package com.sapient;

import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.sapient.service.SapientEmailService;

public class Main {

	public static void main(String[] args)  {

		AWSCredentialsProvider credentialsProvider = new ProfileCredentialsProvider();
		credentialsProvider.getCredentials();

		String from = "admin@autocommunicationshub.com";
		String to = "saurav3444@gmail.com";

		SapientEmailService email = new SapientEmailService(from, to);

		String text = "Hello world.";
		String subject = "welcome";
		String link = "https://www.google.com";
		
		email.forgotPassword(link);
		
		email.successfulPasswordReset();
		
		email.successfulRegistration("saurav 1209 9021342109");
		
		email.customEmail(subject, text, link);
		
		
		

		String htmlBody = "    <style>\r\n" + "      body {\r\n" + "        background-color: #6495ed;\r\n"
				+ "      }\r\n" + "\r\n" + "      h1 {\r\n" + "        color: black;\r\n"
				+ "        text-align: center;\r\n" + "      }\r\n" + "\r\n" + "      p {\r\n"
				+ "        color:  white    }\r\n" + "    </style>\r\n" + "  </head>\r\n" + "  <body>\r\n"
				+ "    <h1>Auto Communications Hub</h1>\r\n"
				+ "    <br><p> Fiat Chrysler Automobiles (FCA) designs, engineers, manufactures and sells vehicles and related parts, services and production systems worldwide. The Group operates over 100 manufacturing facilities and over 40 R&D centers; and it sells through dealers and distributors in more than 130 countries.\r\n"
				+ "\r\n"
				+ "FCA’s automotive brands include Abarth, Alfa Romeo, Chrysler, Dodge, Fiat, Fiat Professional, Jeep®, Lancia, Ram, Maserati. The Group’s businesses also include Mopar (automotive parts and service), Comau (production systems) and Teksid (iron and castings).\r\n"
				+ "\r\n</p><br>" + "<a href=" + link + ">Click here to know more!</a>";
	
		email.customEmailWithHtmlBody(subject, htmlBody);

	}
}
