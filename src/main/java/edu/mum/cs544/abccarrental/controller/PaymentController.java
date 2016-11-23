package edu.mum.cs544.abccarrental.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.mum.cs544.abccarrental.model.Payment;
import edu.mum.cs544.abccarrental.model.Reservation;
import edu.mum.cs544.abccarrental.model.Vehicle;
import edu.mum.cs544.abccarrental.service.IPaymentService;
import edu.mum.cs544.abccarrental.service.IReservationService;
import edu.mum.cs544.abccarrental.service.IVehicleService;




@Controller
public class PaymentController {
	@Autowired
	private IPaymentService paymentService;
	@Autowired
	private IVehicleService vehicleService;
	@Autowired
	private IReservationService reservationService;
	
	
	@RequestMapping(value = "payment", method = RequestMethod.POST)
	public String addPayment( @Valid Payment payment, BindingResult result, Model model){
		if(result.hasErrors()){
			return "addPayment";
		}
		List<Reservation> revers = reservationService.getAll();
		model.addAttribute("revers",revers);
		paymentService.add(payment);
		return "thankYou";
	}
	
	
	@RequestMapping(value = "cancelpayments", method = RequestMethod.POST)
	public String cancelPayment(Model model){
		model.addAttribute("reservations", reservationService.getAll());
		List<Vehicle> vehicles = vehicleService.findAllVehicle();
		model.addAttribute("vehicles", vehicles );
		return "reservationList";
	}
}