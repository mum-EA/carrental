package edu.mum.cs544.abccarrental.service;

public interface IEmailService {
	public void sendHappyNewYearEmail();
	public void sendThankYouForRegistrationEMail(String email, String userName);
}
