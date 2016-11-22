package edu.mum.cs544.abccarrental.model;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.Locale;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.apache.tomcat.util.codec.binary.Base64;



 
@Entity
public class Vehicle implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1000000000000233L;

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
	@Enumerated(EnumType.STRING)
	private VehicleStatus status;
	
	@Lob
	private byte[] vehicleImage;
	@Transient
	private String base64imageFile;
	
	
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
	public VehicleStatus getStatus() {
		return status;
	}
	public void setStatus(VehicleStatus status) {
		this.status = status;
	}
	public byte[] getVehicleImage() {
		return vehicleImage;
	}
	public void setVehicleImage(byte[] vehicleImage) {
		this.vehicleImage = vehicleImage;
	}
	public String getBase64imageFile() {
		return new String(Base64.encodeBase64(this.getVehicleImage()));
	}
	public void setBase64imageFile(String base64imageFile) {
		String myBase64 = new String(Base64.encodeBase64(this.getVehicleImage()));
		this.base64imageFile = myBase64;
	}
	public void setManufacturedYear(Date manufacturedYear) {
		this.manufacturedYear = manufacturedYear;
	}
	
	
	
	
	

}