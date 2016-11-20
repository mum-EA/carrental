package edu.mum.cs544.abccarrental.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.cs544.abccarrental.model.Vehicle;
import edu.mum.cs544.abccarrental.repository.IVehicleRepository;
import edu.mum.cs544.abccarrental.service.IVehicleService;

@Service
@Transactional
public class VehicleServiceImpl implements IVehicleService {
	@Autowired
	IVehicleRepository vehiclerepository;
	
	public VehicleServiceImpl(){
		
	}
	
	
	@Override
	public void saveVehicle(Vehicle vehicle){
		vehiclerepository.save(vehicle);
	}

	
	@Override
	public Vehicle findOne(int id) {
		
		return vehiclerepository.findOne(id);
	}

	@Override
	public List<Vehicle> findAllVehicle() {
		// TODO Auto-generated method stub
		return (List<Vehicle>) vehiclerepository.findAll();
	}

	@Override
	public Vehicle update(Vehicle vehicle) {
		return vehiclerepository.save(vehicle);
	}

	@Override
	public void delete(int id) {
		vehiclerepository.delete(id);
	}

	

	
}
