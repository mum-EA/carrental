package edu.mum.cs544.abccarrental.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.SystemPropertyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import edu.mum.cs544.abccarrental.model.Payment;
import edu.mum.cs544.abccarrental.model.Reservation;
import edu.mum.cs544.abccarrental.model.Users;
import edu.mum.cs544.abccarrental.model.Vehicle;
import edu.mum.cs544.abccarrental.service.IReservationService;
import edu.mum.cs544.abccarrental.service.IUsersService;
import edu.mum.cs544.abccarrental.service.IVehicleService;



@Controller
public class ReservationController2 {
	@Autowired
	private IReservationService reservationService;
	
	@Autowired
	IVehicleService vehicleService;
	@Autowired
	IUsersService userService;
	
	
	@RequestMapping(value = "/rentReservation", method = RequestMethod.GET)
	public String addReservation( @RequestParam("id") int id, Model model, HttpSession session){
		Reservation reservation = new Reservation();
		Vehicle vehicle = vehicleService.findOne(id);
		reservation.setVehicle(vehicle);
		session.setAttribute("vehicle", vehicle);
		model.addAttribute("vehicle", vehicle);
		model.addAttribute("reservation", reservation);
		return "addReservation2";
	}
	
	
	@RequestMapping(value="/reservation", method=RequestMethod.POST )
	public String SaveReservation(@Valid Reservation reservation,BindingResult result,Model model, HttpSession session) {		
		if(result.hasErrors()){
			return "addReservation2";
		}
		
		Vehicle vehicle = (Vehicle)session.getAttribute("vehicle");
		Vehicle vehicle2 = vehicleService.findOne(vehicle.getVehicleId());
		reservation.setVehicle(vehicle2);
		Users user = userService.findUserByUserName(MainController.getPrincipal());
		reservation.setUser(user);
		int daystotal = (int)((reservation.getReturnDate().getTime()-reservation.getPickupDate().getTime())/(1000 * 60 * 60 * 24));
		 reservation.setTotalPrice(daystotal * reservation.getVehicle().getDailyPrice());
		reservationService.add(reservation);
		model.addAttribute("reservations", reservationService.getAll());
		List<Vehicle> vehicles = vehicleService.findAllVehicle();
		model.addAttribute("vehicles", vehicles );
		return "reservationList";
	}
	
	
	@RequestMapping(value="/cancelAddReservation", method=RequestMethod.GET )
	public String cancelreservation(Model model) {		
		List<Vehicle> vehicles = vehicleService.findAllVehicle();
		model.addAttribute("vehicles", vehicles );
		return "vehicleList2";
	}
	
	
	@RequestMapping(value="/rentMore", method=RequestMethod.POST )
	public String RentMore(Model model) {		
		List<Vehicle> vehicles = vehicleService.findAllVehicle();
		model.addAttribute("vehicles", vehicles );
		return "vehicleList2";
	}
	
	
	
	@RequestMapping(value="/editReservation/{id}", method=RequestMethod.GET)
	public String openEditReservation( @PathVariable("id") int id, Model model) {
		Reservation reservation = reservationService.getById(id);
		model.addAttribute("reservation", reservation);
		return "editReservation2";
	}
	

	@RequestMapping(value="/editReservation/updateReservation", method=RequestMethod.POST )
	public String updateVehicle( @Valid Reservation reservation, Model model) {		
		/*if(result.hasErrors()){
			return "editReservation2";
		}*/
		List<Vehicle> vehicles = vehicleService.findAllVehicle();
		model.addAttribute("vehicles", vehicles );
		model.addAttribute("reservations", reservationService.getAll());
		//return "redirect:/reservations/vehicleList2";
		return "vehicleList2";
	}
	

	@RequestMapping(value = "/removeReservation/{id}", method = RequestMethod.GET)
    public String removePerson(@PathVariable("id") int id, Model model){
        reservationService.delete(id);
        model.addAttribute("reservations", reservationService.getAll());
		List<Vehicle> vehicles = vehicleService.findAllVehicle();
		model.addAttribute("vehicles", vehicles );
		return "reservationList";
    }
	
		
	@RequestMapping(value="/makePayment", method=RequestMethod.GET)
	public String makePayment(Model model, HttpSession session){
		if(reservationService.getAll().isEmpty()){
			int errorMessage = 0;
			model.addAttribute("errorMessage", errorMessage);
			return "reservationList";
		}
		Payment payment = new Payment();  
		model.addAttribute("payment", payment);
		return "addPayment";
	}
}
