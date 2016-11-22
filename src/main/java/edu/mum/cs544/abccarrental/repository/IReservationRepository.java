package edu.mum.cs544.abccarrental.repository;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import edu.mum.cs544.abccarrental.model.Reservation;


public interface IReservationRepository extends CrudRepository<Reservation, Integer>{

	@Query("select r from Reservation r where r.user.userId = :userId")
	public List<Reservation> getMyReservations(@Param("userId") int userId);
}
