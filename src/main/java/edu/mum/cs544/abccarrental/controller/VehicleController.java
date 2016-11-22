package edu.mum.cs544.abccarrental.controller;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.validation.Valid;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.support.ByteArrayMultipartFileEditor;

import edu.mum.cs544.abccarrental.model.Vehicle;
import edu.mum.cs544.abccarrental.model.VehicleType;
import edu.mum.cs544.abccarrental.service.IVehicleService;





@Controller
public class VehicleController {
	@Autowired
	IVehicleService vehicleService;
	
	@Autowired
	private ServletContext servletContext;

	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
	}
	
	
	@RequestMapping(value = "/vehicle", method = RequestMethod.GET)
	public String addVehicle(Model model,@ModelAttribute("vehicle") Vehicle vehicle ){
		return "addvehicle";
	}
	
	@RequestMapping(value = "/vehicle", method = RequestMethod.POST)
	public String createVehicle(Model model, @ModelAttribute("vehicle") Vehicle vehicle,  BindingResult bindingresult ,HttpServletRequest request,
            @RequestParam CommonsMultipartFile[] vehicleImage)throws IOException {	
		System.out.println("£££££££££££££££££££££££££££££££££££££££££££££££££££££££££");
		System.out.println("dontdont");
		/*if(vehicle.getVehicleImage().length == 0){
			vehicle.setVehicleImage(null);
		}*/
		 if (vehicleImage != null && vehicleImage.length > 0) {
		        for (CommonsMultipartFile file : vehicleImage){
		            System.out.println("File Name: " + file.getOriginalFilename());
		            System.out.println("File Data: " + Arrays.toString( file.getBytes() ));
		  }
		 }
		String myBase64 = new String(Base64.encodeBase64(vehicle.getVehicleImage()));
		model.addAttribute("imageBase64", myBase64);
		vehicleService.saveVehicle(vehicle);
		model.addAttribute("vehicles", vehicleService.findAllVehicle());
		return "showvehicle";
	}
/*@RequestMapping(value = "/fileUpload", method = RequestMethod.POST)
public String upload(HttpServletRequest request,
                            @RequestParam CommonsMultipartFile[] fileUpload) throws Exception {
    if (fileUpload != null && fileUpload.length > 0) {
        for (CommonsMultipartFile file : fileUpload){
            System.out.println("File Name: " + file.getOriginalFilename());
            System.out.println("File Data: " + Arrays.toString( file.getBytes() ));
        }
    }
    return "uploadCompleted";
}  */
	
	
	
	@RequestMapping(value = "/image/{plateNumber}",method = RequestMethod.GET)
	public void getImage(Model model , @PathVariable ("plateNumber") int plateNumber , HttpServletResponse response, HttpServletRequest request)throws
	ServletException,IOException{
		
		System.out.println("****************************************************");
		Vehicle item  = vehicleService.findOne(plateNumber);
		response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
		ServletOutputStream out = response.getOutputStream();
		out.write(item.getVehicleImage());
		out.close();
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
	
	@InitBinder
	public void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) {
		// Convert multipart object to byte[]
		binder.registerCustomEditor(byte[].class, new ByteArrayMultipartFileEditor());
	}
}
