package edu.mum.cs544.abccarrental.service;

import java.util.List;

import edu.mum.cs544.abccarrental.model.Payment;


public interface IPaymentService {
	public void add(Payment payment);
	public List<Payment> getAll();
	public Payment getById(int paymentId);
	public void delete(int paymentId);
	public void update(int paymentId, Payment payment);
	
}