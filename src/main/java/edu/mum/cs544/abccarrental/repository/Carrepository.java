package edu.mum.cs544.abccarrental.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import edu.mum.cs544.abccarrental.model.Car;

public interface Carrepository extends CrudRepository<Car, Integer> {
	@Query("select c from Car c")
	List<Car>getAllCars();
	
}
