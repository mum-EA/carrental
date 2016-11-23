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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Payment {
	@Id
	@GeneratedValue
	private int paymentId;
	@NotEmpty(message = "Payment type may not be empty")
	private String paymentType;
	@NotNull(message = "Card number may not be empty")
	private int cardNumber;
	@Min(100)
	@Max(999)
	@NotNull
	private int ccv;
	@NotEmpty(message = "it cannot be empty")
	@Pattern(regexp = "[1-9][0-9]{3}/[1-9]{1,2}", message = "Should be in XXXX/XX format")
	private String cardExpiryDate;
	
	
	
	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	private Reservation reservation;



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



	public int getCardNumber() {
		return cardNumber;
	}



	public void setCardNumber(int cardNumber) {
		this.cardNumber = cardNumber;
	}



	public int getCcv() {
		return ccv;
	}



	public void setCcv(int ccv) {
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



	@Override
	public String toString() {
		return "Payment [paymentId=" + paymentId + ", paymentType=" + paymentType + ", cardNumber=" + cardNumber
				+ ", ccv=" + ccv + ", cardExpiryDate=" + cardExpiryDate + "]";
	}
	
	public Payment(){
		
	}

	
	
}
