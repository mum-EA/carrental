package edu.mum.cs544.abccarrental.service;

import java.util.List;


import edu.mum.cs544.abccarrental.model.Reservation;


public interface IReservationService {
	public void add(Reservation reservation);
	public List<Reservation> getAll();
	public Reservation getById(int reservationId);
	public void delete(int reservationId);
	public void update(int reservationId, Reservation reservation);
	public List<Reservation> getMyReservations(int userId);
}
