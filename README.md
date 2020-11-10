# Sapient Email Service using AWS-SES-API

A simplified Java Library for sending emails using the Amazon Simple Email Service.

### Steps to use Sapient Email Service

## 1. Clone this repository and run

    mvn clean install

## 2. Dependencies required

```
<dependency>
	<groupId>com.sapient</groupId>
	<artifactId>email-service</artifactId>
	<version>1.0.0</version>
</dependency>

```

## 3. Add AWS credenditals

In your user directory under .aws folder add a file named credentials
example for windows: C:\Users\saukumar17\ .aws\credentials
In that credentials file add :

```
[default]
aws_access_key_id=***
aws_secret_access_key=***

```

## 4. Usage

Run this Main class, If no exception is thrown mail is sent successfully.

```
package com.sapient;

import com.sapient.service.SapientEmailService;

public static void main(String[] args)  {



		String to = "saurav3444@gmail.com";

		SapientEmailService email = new SapientEmailService();

		String text = "Hello world.";
		String subject = "welcome";
		String link = "https://www.google.com";

		email.forgotPassword(to, link);

		email.successfulPasswordReset(to);

		email.successfulRegistration(to, "saurav 1209 9021342109");

		email.customEmail(to, subject, text, link);
}

```

## 5. Check Mail

go to [Amazon Work mail](https://autocommunicationshub.awsapps.com/mail)

username: admin<br>
password: \*\*\*\*
