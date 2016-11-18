package edu.mum.cs544.abccarrental.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.web.multipart.MultipartFile;

@Entity
public class Car {

	@Id
	@GeneratedValue
	private int carId;
	
	private String model;
	private String description;
	private MultipartFile carImage;
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	public int getCarId() {
		return carId;
	}
	public void setCarId(int carId) {
		this.carId = carId;
	}
	public MultipartFile getCarImage() {
		return carImage;
	}
	public void setCarImage(MultipartFile carImage) {
		this.carImage = carImage;
	}
	@Override
	public String toString() {
		return "Car [carId=" + carId + ", model=" + model + ", description=" + description + "]";
	}
	
	
}
