# Sapient Email Service using AWS-SES-API

A simplified Java Library for sending emails using the Amazon Simple Email Service.

### Steps to use Sapient Email Service

## 1. Dependencies required

```
<dependency>
  <groupId>com.amazonaws</groupId>
  <artifactId>aws-java-sdk</artifactId>
  <version>1.11.256</version>
  <scope>compile</scope>
</dependency>
```

```
<dependency>
  <groupId>com.amazonaws</groupId>
  <artifactId>amazon-kinesis-client</artifactId>
  <version>1.2.1</version>
  <scope>compile</scope>
</dependency>
```

## 2. Add AWS credenditals

In your user directory under .aws folder add a file named credentials
example for windows: C:\Users\saukumar17\ .aws\credentials
In that credentials file add :

```
[default]
aws_access_key_id=AKIAQNYMR7A7KLLQ7NDJ
aws_secret_access_key=08QYRNWOgpHyTLmuoMGZSzSivSKdRVsguY3WNcpu

```

## 3. Add jar file in this repository or build this project on jenkins to generate the same

1.Download jar file in target folder email-service-1.0.0
2.In eclipse goto build path -> add external jar file -> select downloaded jar file
3.Update project

## 4. Usage

Run this Main class, If no exception is thrown mail is sent successfully.

```
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

```

## 5. Check Mail

go to [Amazon Work mail](https://autocommunicationshub-com.awsapps.com/mail)

username: info<br>
password: psiotb#123
