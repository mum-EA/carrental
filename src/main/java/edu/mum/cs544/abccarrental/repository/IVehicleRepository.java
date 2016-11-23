package edu.mum.cs544.abccarrental.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import edu.mum.cs544.abccarrental.model.Vehicle;
import edu.mum.cs544.abccarrental.model.VehicleStatus;

public interface IVehicleRepository extends CrudRepository<Vehicle, Integer> {
	@Query("select v from Vehicle v where v.status = :status")
	List<Vehicle>findVehiclesByAvailability(@Param("status") VehicleStatus available);
	public Vehicle findByPlateNumber(Integer plateNumber);
}
