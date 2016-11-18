package edu.mum.cs544.abccarrental.repository;

import org.springframework.data.repository.CrudRepository;

import edu.mum.cs544.abccarrental.model.Customer;

public interface ICustomerRepository extends CrudRepository<Customer, Integer> {

}
