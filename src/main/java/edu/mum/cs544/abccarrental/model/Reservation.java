package edu.mum.cs544.abccarrental.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.annotations.Cascade;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Reservation implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1000000000000675L;
	@Id
	@GeneratedValue
	private int reservationId;
	@Future
	//@Pattern(regexp = "^((?<year>(?:[0-9]{2})?[0-9]{2})/?<month>[0-3]?[0-9])/(?<day>[0-3]?[0-9])$", message = "invalid date format")
	@Temporal(TemporalType.DATE)
	private Date pickupDate;

	@Temporal(TemporalType.DATE)
	private Date returnDate;
	
	@Temporal(TemporalType.DATE)
	private Date reservationDate;
	@NotNull
	@NotEmpty(message="location to cannot be empty")
	private String locationto;
	@NotNull
	@NotEmpty(message="location from cannot be empty")
	private String locationfrom;
	
	private double totalPrice;
	@Enumerated(EnumType.STRING)
	private ReservationStatus status;

	@OneToOne
	private Vehicle vehicle;
	
	
	@OneToOne
	@JoinColumn(name = "userId")
	private Users user;

	public int getReservationId() {
		return reservationId;
	}

	public void setReservationId(int reservationId) {
		this.reservationId = reservationId;
	}

	public Date getPickupDate() {
		return pickupDate;
	}

	public void setPickupDate(Date pickupDate) {
		this.pickupDate = pickupDate;
	}

	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
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

	public String getLocationto() {
		return locationto;
	}

	public void setLocationto(String locationto) {
		this.locationto = locationto;
	}

	public String getLocationfrom() {
		return locationfrom;
	}

	public void setLocationfrom(String locationfrom) {
		this.locationfrom = locationfrom;
	}

	public void setStatus(ReservationStatus status) {
		this.status = status;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;

	}


	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

}
