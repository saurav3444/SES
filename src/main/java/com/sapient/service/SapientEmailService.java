package com.sapient.service;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceClientBuilder;
import com.amazonaws.services.simpleemail.model.Body;
import com.amazonaws.services.simpleemail.model.Content;
import com.amazonaws.services.simpleemail.model.Destination;
import com.amazonaws.services.simpleemail.model.Message;
import com.amazonaws.services.simpleemail.model.SendEmailRequest;
import com.sapient.exception.EmailNotSentException;

public class SapientEmailService {
	
	public static final String HEADER = "Auto Communications Hub";
	private String from;
	private String to;
	private Regions regions = Regions.US_EAST_1;
	
	public SapientEmailService(String from, String to) {

		this.from = from;
		this.to = to;
	}

	public void setRegions(Regions regions) {
		this.regions = regions;
	}
	
	public void forgotPassword(String link) { 
		
		String htmlBodyForResetPassword = "<h1>" + HEADER + "</h1>"
				+ "<p>Dear Auto Communications Hub user,\r\n"
				+ "\r\n"
				+ "A we have received a request of Password Reset for your account.\r\n"
				+ "\r\n"
				+ " If you requested this verification, please go to the following URL and click the link below to change your password.\r\n"
				+ "\r\n"
				+ "<br>"
				+"<a href="+link+">"+link+"</a>"
				+"<br>"
				+"<br>"
				+ "If you did NOT request to verify this email address, do not click on the link. Please note that many times, "
				+ "\r\n"
				+ "the situation isn't a phishing attempt, but either a misunderstanding of how to use our service, "
				+ "\r\n"
				+ "or someone setting up email-sending capabilities on your behalf as part of a legitimate service, "
				+ "\r\n"
				+ "but without having fully communicated the procedure first." + "</p>";
		
		String subject = "Forgot Your Password?";

		awsSes(subject, htmlBodyForResetPassword);

	}

	public void successfulRegistration(String text) {
		
		String htmlBodyForSuccessfulRegistration = HEADER
				+ "<p>Welcome to Auto Communications Hub,\r\n"
				+ "<br>"
				+ text +"</p>";

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
		+"<a href="+link+">"+link+"</a>";
		
		awsSes(subject, htmlBodyCustomEmail);
	}

	public void customEmailWithHtmlBody(String subject, String htmlBody) {

		awsSes(subject, htmlBody);
	}
	

	public void awsSes(String subject, String htmlBody) {

		try {
			String type = "UTF-8";
			AmazonSimpleEmailService client = AmazonSimpleEmailServiceClientBuilder.standard()
					.withRegion(this.regions).build();
	     
			SendEmailRequest request = new SendEmailRequest()
					.withDestination(new Destination()
						.withToAddresses(to))
						.withMessage(new Message()
						
							.withBody(new Body()
								.withHtml(new Content()
								.withCharset(type)
								.withData(htmlBody)))
											
							.withSubject(new Content()
								.withCharset(type)
								.withData(subject)))
							.withSource(from);
	      
	      client.sendEmail(request);
	      
		} catch (Exception ex) {
			throw new EmailNotSentException(ex);
		}
	  }
}
