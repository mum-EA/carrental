package edu.mum.cs544.abccarrental.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.cs544.abccarrental.model.Reservation;
import edu.mum.cs544.abccarrental.model.Vehicle;
import edu.mum.cs544.abccarrental.model.VehicleStatus;
import edu.mum.cs544.abccarrental.repository.IReservationRepository;
import edu.mum.cs544.abccarrental.repository.IVehicleRepository;
import edu.mum.cs544.abccarrental.service.IReservationService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

@Service
@Transactional
public class ReservationService implements IReservationService {

	@Autowired
	private IReservationRepository reservationRepository;
	@Autowired
	private IVehicleRepository vehicleRepository;

	@Override
	public void add(Reservation reservation) {
		reservationRepository.save(reservation);
	
		Vehicle v = vehicleRepository.findOne(reservation.getVehicle().getVehicleId());
		v.setStatus(VehicleStatus.NotAvailable);
		vehicleRepository.save(v);
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
		Reservation r = reservationRepository.findOne(reservationId);
		reservationRepository.delete(reservationId);
		Vehicle v = vehicleRepository.findOne(r.getVehicle().getVehicleId());
		v.setStatus(VehicleStatus.Available);
		vehicleRepository.save(v);
	}

	@Override
	public void update(int reservationId, Reservation reservation) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Reservation> getMyReservations(int userId) {
		return reservationRepository.getMyReservations(userId);
	}

}