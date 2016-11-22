package edu.mum.cs544.abccarrental.repository;

import org.springframework.data.repository.CrudRepository;

import edu.mum.cs544.abccarrental.model.Payment;


public interface IPaymentRepository extends CrudRepository<Payment, Integer>{

}
