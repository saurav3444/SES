package com.sapient;

import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.sapient.service.SapientEmailService;


public class Main {
	

	public static void main(String[] args) throws Exception {
		AWSCredentialsProvider credentialsProvider = new ProfileCredentialsProvider();
		credentialsProvider.getCredentials();

		String from = "info-@autocommunicationshub-com.awsapps.com";
		String to = "info-@autocommunicationshub-com.awsapps.com";
		SapientEmailService email = new SapientEmailService(from, to);

		String text = "Hello world.";
		String subject = "welcome";
		String link = "https://www.google.com";

		email.customEmail(subject, text, link);
		email.forgotPassword(link);
		email.successfulPasswordReset();
		email.successfulRegistration();
		
	}
}
