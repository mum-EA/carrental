package edu.mum.cs544.abccarrental.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.support.ByteArrayMultipartFileEditor;
import org.springframework.web.servlet.NoHandlerFoundException;

import edu.mum.cs544.abccarrental.model.Roles;
import edu.mum.cs544.abccarrental.model.Users;
import edu.mum.cs544.abccarrental.model.Vehicle;
import edu.mum.cs544.abccarrental.model.VehicleStatus;
import edu.mum.cs544.abccarrental.service.IEmailService;
import edu.mum.cs544.abccarrental.service.IRolesService;
import edu.mum.cs544.abccarrental.service.IUsersService;
import edu.mum.cs544.abccarrental.service.IVehicleService;

@Controller
public class MainController {
	@Autowired
	IUsersService userService;
	@Autowired
	IRolesService roleService;
	@Autowired
	IVehicleService vehicleService;
	@Autowired
	IEmailService emailService;

	
	@RequestMapping(value = { "/", "/home" }, method = RequestMethod.GET)
	public String homePage(ModelMap model) {
		model.addAttribute("username", getPrincipal());
		List<Vehicle> vehicles = vehicleService.findVehiclesByAvailability(VehicleStatus.Available);
		model.addAttribute("vehicles", vehicles );
		return "home";
	}

	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String adminPage(ModelMap model) {
		model.addAttribute("user", getPrincipal());
		return "admin";
	}

	@RequestMapping(value = "/customer", method = RequestMethod.GET)
	public String dbaPage(ModelMap model) {
		model.addAttribute("user", getPrincipal());
		return "dba";
	}

	@RequestMapping(value = "/sessionhasexpired", method = RequestMethod.GET)
	public String accessDeniedPage(ModelMap model) {
		return "sessionhasexpired";
	}

	@RequestMapping(value = "illegallogin", method = RequestMethod.GET)
	public String illegalLogin(ModelMap model) {
		return "illegallogin";
	}

	@RequestMapping(value = "/login")
	public String loginPage() {
		return "login";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return "redirect:/login?logout";
	}

	@RequestMapping(value = "/registernewcustomer", method = RequestMethod.GET)
	public String showCustomerRegister(Model model) {
		model.addAttribute("user", new Users());
		return "registercustomer";
	}

	@RequestMapping(value = "/updateCustomerInfo", method = RequestMethod.GET)
	public String showUpdatePage(Model model) {
		Users user = userService.findUserByUserName(getPrincipal());
		model.addAttribute("user", user);
		return "registercustomer";
	}

	@RequestMapping(value = "/customerdetail", method = RequestMethod.GET)
	public String showCustomerDetail(Model model) {
		System.out.println("current user is: " + getPrincipal());
		Users user = userService.findUserByUserName(getPrincipal());

		System.out.println(user);
		model.addAttribute("user", user);
		return "customerdetails";
	}

	@RequestMapping(value = "/allcustomers", method = RequestMethod.GET)
	public String showAllCustomers(Model model) {
		List<Users> users = userService.findAllUsers();
		System.out.println(users);
		model.addAttribute("customers", users);
		return "customers";
	}

	@RequestMapping(value = "/managecustomer/{username}", method = RequestMethod.GET)
	public String getCustomerInfo(@PathVariable("username") String username, Model model) {
		Users oldUser = userService.findUserByUserName(username.trim());
		model.addAttribute("user", oldUser);
		
		System.out.println(oldUser.getName());

		return "activation";
	}

	@RequestMapping(value = "/dealactivation", method = RequestMethod.POST)
	public String enableDisableCustomer(@ModelAttribute("user") Users user, Model model) {

		System.out.println("Before this");
		System.out.println("User name is: " + user.getUsername());
		Users oldUser = userService.findUserByUserName(user.getUsername());
		System.out.println("After this:");
		System.out.println(oldUser);
//		oldUser.setEnabled(user.isEnabled());
		userService.updateUser(oldUser);
		
		return "customers";
	}

	@RequestMapping(value = "/addnewcustomer", method = RequestMethod.POST)
	public String processAdd(@ModelAttribute("user") @Valid Users user, BindingResult bindingResult, Model model) {
		
		//check if user already exists
		
		Users existingUser = userService.findUserByUserName(user.getUsername());
		if (bindingResult.hasErrors()) {
			return "registercustomer";
		} else {
			String username = getPrincipal();
			
			System.out.println("Current user is: "+ username);
			if (!username.equals("anonymousUser")) {
				userService.updateUser(user);
			} else if(existingUser == null) {
				userService.save(user);
				Roles role = new Roles();
				if (user.getUsername().equalsIgnoreCase("Administrator")
						|| (user.getUsername().equalsIgnoreCase("Admin"))) {
					role.setRole("ROLE_ADMIN");
				} else {
					role.setRole("ROLE_CUSTOMER");
				}
				role.setUsername(user.getUsername());
				roleService.Save(role);
				
				//send email to user up on registration
				
				emailService.sendThankYouForRegistrationEMail(user.getEmail(), user.getName());
			} else{
				model.addAttribute("useralreadyexists", "Username already taken");
				return "registercustomer";
			}
			return "redirect:/home";
		}
	}

	@ExceptionHandler(NoHandlerFoundException.class)
	public String handle(Exception ex) {
		return "redirect:/page-not-found";
	}

	@RequestMapping(value = { "/page-not-found" }, method = RequestMethod.GET)
	public String NotFoudPage() {
		return "page-not-found";

	}

	static String getPrincipal() {
		String userName = null;
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
			userName = ((UserDetails) principal).getUsername();
		} else {
			userName = principal.toString();
		}
		return userName;
	}

	// initialize
	@InitBinder
	public void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) {
		// Convert multipart object to byte[]
		binder.registerCustomEditor(byte[].class, new ByteArrayMultipartFileEditor());
	}
}
