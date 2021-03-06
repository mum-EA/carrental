package edu.mum.cs544.abccarrental.service;

import java.util.List;


import edu.mum.cs544.abccarrental.model.Vehicle;
import edu.mum.cs544.abccarrental.model.VehicleStatus;

public interface IVehicleService {
	public void saveVehicle(Vehicle vehicle);
	public Vehicle findOne(int id);
	public List<Vehicle> findAllVehicle();
	public Vehicle update(Vehicle vehicle);
	public void delete(int id);
	public List<Vehicle>findVehiclesByAvailability(VehicleStatus available);
	
	
}