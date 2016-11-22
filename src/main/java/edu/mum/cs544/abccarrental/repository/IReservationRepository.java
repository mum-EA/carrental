package edu.mum.cs544.abccarrental.repository;

import org.springframework.data.repository.CrudRepository;

import edu.mum.cs544.abccarrental.model.Reservation;


public interface IReservationRepository extends CrudRepository<Reservation, Integer>{

}
