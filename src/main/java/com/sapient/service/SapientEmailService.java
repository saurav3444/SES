package com.sapient.service;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceClientBuilder;
import com.amazonaws.services.simpleemail.model.Body;
import com.amazonaws.services.simpleemail.model.Content;
import com.amazonaws.services.simpleemail.model.Destination;
import com.amazonaws.services.simpleemail.model.Message;
import com.amazonaws.services.simpleemail.model.SendEmailRequest;

import lombok.extern.slf4j.Slf4j;


@Slf4j
public class SapientEmailService {
	
	public static final String HEADER = "<h1>Auto Communications Hub</h1>";
	private String from;
	private String to;
	
	public SapientEmailService(String from, String to) {

		this.from = from;
		this.to = to;
	}

	public void forgotPassword(String link) {
		
		String htmlBodyForResetPassword = HEADER
				+ "<p>Hi,\r\n"
				+ "\r\n"
				+ "A password reset for your account was requested.\r\n"
				+ "\r\n"
				+ "Please click the link below to change your password.\r\n"
				+ "\r\n"
				+ "<br>"
				+ "<p>"+ link + "</p>"
				+ "<a href="+ link + "></a>";
		String subject = "Forgot Your Password?";

		awsSes(subject, htmlBodyForResetPassword);

	}

	public void successfulRegistration() {
		
		String htmlBodyForSuccessfulRegistration = HEADER 
				+ "<p>Your Account is successfully created</p>";

		String subject = "Successful Registration";

		awsSes(subject, htmlBodyForSuccessfulRegistration);

	}

	public void successfulPasswordReset() {
		
		String htmlBodyForSuccessfulRegistration = HEADER
				+ "<p>Your Password is successfully changed</p>";
		
		String subject = "Successful Password Reset";
		
		awsSes(subject, htmlBodyForSuccessfulRegistration);
	}

	public void customEmail(String subject, String text, String link) {

		String htmlBodyCustomEmail = HEADER
		+"<p>"+text+"</p>"
		+"<br>"
		+ "<a href="+ link + "></a>";
		
		awsSes(subject, htmlBodyCustomEmail);
	}

	

	public void awsSes(String subject, String htmlBody) {

		try {
			String type = "UTF-8";
			AmazonSimpleEmailService client = AmazonSimpleEmailServiceClientBuilder.standard()
					.withRegion(Regions.US_EAST_1).build();
	     
			SendEmailRequest request = new SendEmailRequest()
					.withDestination(new Destination()
						.withToAddresses(to))
						.withMessage(new Message()
						
							.withBody(new Body()
								.withHtml(new Content()
								.withCharset(type)
								.withData(htmlBody))
							
							.withText(new Content()
								.withCharset(type)
								.withData("")))
											
							.withSubject(new Content()
								.withCharset(type)
								.withData(subject)))
							.withSource(from);
	      
	      client.sendEmail(request);
	      
	      log.info("Email sent!");
		} catch (Exception ex) {
			log.info("The email was not sent. Error message: ");
			log.info(ex.getMessage());
		}
	  }

}
