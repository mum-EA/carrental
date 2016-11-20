package edu.mum.cs544.abccarrental.controller;

import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import edu.mum.cs544.abccarrental.model.Vehicle;
import edu.mum.cs544.abccarrental.model.VehicleType;
import edu.mum.cs544.abccarrental.service.IVehicleService;





@Controller
public class VehicleController {
	@Autowired
	IVehicleService vehicleService;
	
	
	@RequestMapping(value = "/vehicle", method = RequestMethod.GET)
	public String addVehicle(Model model){
		model.addAttribute("vtype",VehicleType.values());
		return "addvehicle";
	}
	
	@RequestMapping(value="/vehicle", method=RequestMethod.POST )
	public String createVehicle(Model model,Vehicle vehicle) {		
		
		vehicleService.saveVehicle(vehicle);
		model.addAttribute("vehicles", vehicleService.findAllVehicle());
		return "showvehicle";
	}
	
	@RequestMapping(value="/vehicle/showvehicle", method=RequestMethod.GET )
	public String showVehicle(Model model,Vehicle vehicle) {
		model.addAttribute("vehicles", vehicleService.findAllVehicle());
		
		return "home";
	}
	
	@RequestMapping("/editvehicle/{id}" )
	public String editVehicle(Model model, @PathVariable("id") int id, Vehicle vehicle) {
		Vehicle findOne = vehicleService.findOne(id);
		model.addAttribute("vehicle", findOne);
		System.out.println(id);
		return "editvehicle";
	}
	
	@RequestMapping(value="/updatevehicle", method=RequestMethod.POST )
	public String updateVehicle(@ModelAttribute("Vehicle") Vehicle vehicle ,  Model model) {		
		System.out.println("*******************************************************");
		vehicleService.saveVehicle(vehicle);
		 model.addAttribute("vehicles", vehicle);
		return "redirect:/vehicle/showvehicle";
	}
	
	@RequestMapping("/remove/{id}")
    public String removePerson(@PathVariable("id") int id){
		
        vehicleService.delete(id);
        return "home";
        
    }
}
