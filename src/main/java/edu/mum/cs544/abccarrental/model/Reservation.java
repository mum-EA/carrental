package edu.mum.cs544.abccarrental.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Reservation {

	@Id
	@GeneratedValue
	private int reservationId;

	private int confirmationId;
	@Temporal(TemporalType.DATE)
	private Date pickupDate;
	@Temporal(TemporalType.DATE)
	private Date dropoffDate;
	@Temporal(TemporalType.DATE)
	private Date reservationDate;
	@Enumerated(EnumType.STRING)
	private ReservationStatus status;
	public int getReservationId() {
		return reservationId;
	}
	public void setReservationId(int reservationId) {
		this.reservationId = reservationId;
	}
	public int getConfirmationId() {
		return confirmationId;
	}
	public void setConfirmationId(int confirmationId) {
		this.confirmationId = confirmationId;
	}
	public Date getPickupDate() {
		return pickupDate;
	}
	public void setPickupDate(Date pickupDate) {
		this.pickupDate = pickupDate;
	}
	public Date getDropoffDate() {
		return dropoffDate;
	}
	public void setDropoffDate(Date dropoffDate) {
		this.dropoffDate = dropoffDate;
	}
	public Date getReservationDate() {
		return reservationDate;
	}
	public void setReservationDate(Date reservationDate) {
		this.reservationDate = reservationDate;
	}
	public ReservationStatus getStatus() {
		return status;
	}
	public void setStatus(ReservationStatus status) {
		this.status = status;
	}
	
	
	
	
	
}
