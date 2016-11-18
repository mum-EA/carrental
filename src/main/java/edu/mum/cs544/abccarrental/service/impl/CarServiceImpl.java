package edu.mum.cs544.abccarrental.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.cs544.abccarrental.model.Car;
import edu.mum.cs544.abccarrental.repository.Carrepository;
import edu.mum.cs544.abccarrental.service.CarService;

@Service
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class CarServiceImpl implements CarService {

	@Autowired
	private Carrepository carRepo;
	@Override
	public List<Car> getAllCars() {
		// TODO Auto-generated method stub
		return carRepo.getAllCars();
	}
	@Override
	public void save(Car car) {
		// TODO Auto-generated method stub
		carRepo.save(car);
		
	}

}
