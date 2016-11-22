package edu.mum.cs544.abccarrental.repository;



import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.mum.cs544.abccarrental.model.Vehicle;
@Repository
public interface IVehicleRepository extends CrudRepository<Vehicle, Integer> {

}
