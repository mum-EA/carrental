package edu.mum.cs544.abccarrental.model;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.Locale;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


 
@Entity
public class Vehicle {
	
	@Id
	@GeneratedValue
	private int vehicleId;
	private int plateNumber;
	private int numberOfSeats;
	@Enumerated(EnumType.STRING)
	private VehicleType vehicleType;
	private double dailyPrice;
	private String brand;
	
	@Temporal(TemporalType.DATE)
	private Date manufacturedYear;
	private boolean status;
	
	private static DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT, Locale.US);
	
	
	
	
	public int getVehicleId() {
		return vehicleId;
	}
	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}
	
	public int getPlateNumber() {
		return plateNumber;
	}
	public void setPlateNumber(int plateNumber) {
		this.plateNumber = plateNumber;
	}
	public int getNumberOfSeats() {
		return numberOfSeats;
	}
	public void setNumberOfSeats(int numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
	}
	
	public VehicleType getvehicleType() {
		return vehicleType;
	}
	
	public void setVehicleType(VehicleType vehicleType) {
		this.vehicleType = vehicleType;
	}
	public double getDailyPrice() {
		return dailyPrice;
	}
	public void setDailyPrice(double dailyPrice) {
		this.dailyPrice = dailyPrice;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public Date getManufacturedYear() {
		return manufacturedYear;
	}
	public void setManufacturedYear(String manufacturedYear) {
		try {
			this.manufacturedYear =  df.parse(manufacturedYear);
		} catch (ParseException e) {
			e.printStackTrace();
		} 
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	
	

}
