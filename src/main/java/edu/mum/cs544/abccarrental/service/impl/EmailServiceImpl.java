package edu.mum.cs544.abccarrental.service.impl;

import java.util.List;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import edu.mum.cs544.abccarrental.repository.IUserRepository;
import edu.mum.cs544.abccarrental.service.IEmailService;

@Service
public class EmailServiceImpl implements IEmailService{

	@Autowired
	IUserRepository userRepo;
	@Autowired
	private JavaMailSender mailSender;
	@Override
	public void sendHappyNewYearEmail() {
		try {
			System.out.println("Started sending emails");

			String fromAddress = String.format("ABC Car rental <abcrental.com>");
			List<String> emails = userRepo.getListOfEmails();


			String subject = "Happy new year";

			System.out.println("Subject is: " + subject);
			String msgBody = String.format("<html><body>Dear Customers, </br> Happy new year!</body></html>");

			MimeMessage mimeMessage = mailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);

			
			String[] validEmailList = emails.toArray(new String[emails.size()]);
			mimeMessage.setContent(msgBody, "text/html");
			helper.setTo(validEmailList);
			helper.setSubject(subject);
			helper.setFrom(fromAddress);
			mailSender.send(mimeMessage);
			System.out.println("Email sent...");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	@Override
	public void sendThankYouForRegistrationEMail(String email,String userName) {
		try {

			String fromAddress = String.format("ABC Car rental <abcrental.com>");

			String subject = "Registration confirmation";

			String msgBody = String.format("<html><body>Dear "+ userName + " , </br> Thank you for registering with us </br> You will enjoy the benefits, stay with us!</body></html>");

			MimeMessage mimeMessage = mailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
			
			mimeMessage.setContent(msgBody, "text/html");
			helper.setTo(email);
			helper.setSubject(subject);
			helper.setFrom(fromAddress);
			mailSender.send(mimeMessage);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	
	
}
