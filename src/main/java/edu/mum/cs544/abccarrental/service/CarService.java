package edu.mum.cs544.abccarrental.service;

import java.util.List;

import edu.mum.cs544.abccarrental.model.Car;

public interface CarService {
	List<Car>getAllCars();
	void save(Car car);
}
