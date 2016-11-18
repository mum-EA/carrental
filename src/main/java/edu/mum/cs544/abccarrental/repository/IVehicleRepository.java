package edu.mum.cs544.abccarrental.repository;

import org.springframework.data.repository.CrudRepository;

import edu.mum.cs544.abccarrental.model.Vehicle;

public interface IVehicleRepository extends CrudRepository<Vehicle, Integer> {

}
