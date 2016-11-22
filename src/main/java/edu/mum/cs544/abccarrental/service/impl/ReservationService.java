package edu.mum.cs544.abccarrental.service.impl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.cs544.abccarrental.model.Reservation;
import edu.mum.cs544.abccarrental.repository.IReservationRepository;
import edu.mum.cs544.abccarrental.service.IReservationService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

@Service @Transactional
public class ReservationService implements IReservationService{

	@Autowired
	private IReservationRepository reservationRepository;
	
	@Override
	public void add(Reservation reservation) {
		// TODO Auto-generated method stub
		reservationRepository.save(reservation);
	}

	@Override
	public List<Reservation> getAll() {
		// TODO Auto-generated method stub
		return (List<Reservation>) reservationRepository.findAll();
	}

	@Override
	public Reservation getById(int reservationId) {
		// TODO Auto-generated method stub
		return reservationRepository.findOne(reservationId);
	}

	@Override
	public void delete(int reservationId) {
		// TODO Auto-generated method stub
		reservationRepository.delete(reservationId);
	}

	@Override
	public void update(int reservationId, Reservation reservation) {
		// TODO Auto-generated method stub
		
	}

}