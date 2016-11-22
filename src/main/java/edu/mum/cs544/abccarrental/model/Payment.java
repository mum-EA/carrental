package edu.mum.cs544.abccarrental.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Future;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Payment {
	@Id
	@GeneratedValue
	private int paymentId;
	private String paymentType;
	//@NotEmpty
	//@Pattern(regexp = "(\\d{16}", message = "card Number must be 16 digit integer")
	private Integer cardNumber;
	//@Min(3)
//	@Max(3)
//	@NotEmpty
	private Integer ccv;
//	@NotEmpty(message = "it cannot be empty")
	//@Future
	private String cardExpiryDate;
	
	
	
	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	private Reservation reservation;
	
	
	//@OneToOne(cascade = CascadeType.ALL)
	//List<Reservation> reservations = new ArrayList<Reservation>();
	
	
	/*public List<Reservation> getReservations() {
		return reservations;
	}
	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}*/
	public int getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}
	public String getPaymentType() {
		return paymentType;
	}
	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}
	public Integer getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(Integer cardNumber) {
		this.cardNumber = cardNumber;
	}
	public Integer getCcv() {
		return ccv;
	}
	public void setCcv(Integer ccv) {
		this.ccv = ccv;
	}
	public String getCardExpiryDate() {
		return cardExpiryDate;
	}
	public void setCardExpiryDate(String cardExpiryDate) {
		this.cardExpiryDate = cardExpiryDate;
	}
	public Reservation getReservation() {
		return reservation;
	}
	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}
	public Payment() {
		
	}
	@Override
	public String toString() {
		return "Payment [paymentId=" + paymentId + ", paymentType=" + paymentType + ", cardNumber=" + cardNumber
				+ ", ccv=" + ccv + ", cardExpiryDate=" + cardExpiryDate + ", reservation=" + reservation + "]";
	}
	
	
	
}
