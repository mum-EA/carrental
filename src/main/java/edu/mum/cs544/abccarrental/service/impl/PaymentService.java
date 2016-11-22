package edu.mum.cs544.abccarrental.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.cs544.abccarrental.model.Payment;
import edu.mum.cs544.abccarrental.repository.IPaymentRepository;
import edu.mum.cs544.abccarrental.service.IPaymentService;

@Service
@Transactional
public class PaymentService implements IPaymentService{

	@Autowired
	private IPaymentRepository paymentRepository;
	@Override
	public void add(Payment payment) {
		System.out.println(".......................");
		// TODO Auto-generated method stub
		paymentRepository.save(payment);
	}

	@Override
	public List<Payment> getAll() {
		// TODO Auto-generated method stub
		return (List<Payment>) paymentRepository.findAll();
	}

	@Override
	public Payment getById(int paymentId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(int paymentId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(int paymentId, Payment payment) {
		// TODO Auto-generated method stub
		
	}

}