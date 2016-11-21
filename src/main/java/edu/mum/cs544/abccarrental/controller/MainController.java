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
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.NoHandlerFoundException;

import edu.mum.cs544.abccarrental.model.Roles;
import edu.mum.cs544.abccarrental.model.Users;
import edu.mum.cs544.abccarrental.service.IRolesService;
import edu.mum.cs544.abccarrental.service.IUsersService;

@Controller
public class MainController {
	@Autowired
	IUsersService userService;
	@Autowired
	IRolesService roleService;

	@RequestMapping(value = { "/", "/home" }, method = RequestMethod.GET)
	public String homePage(ModelMap model) {
		model.addAttribute("greeting", "Hi, Welcome to our site");
		model.addAttribute("username", getPrincipal());
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
	public String illegalLogin(ModelMap model){
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
		
		return "activation";
	}
	@RequestMapping(value = "/dealactivation", method = RequestMethod.POST)
	public String enableDisableCustomer(@ModelAttribute("user") Users user, BindingResult bindingResult) {
		System.out.println("Before this");
		System.out.println("User name is: "+ user.getUsername());
		Users oldUser = userService.findUserByUserName(user.getUsername());
		System.out.println("After this:");
		oldUser.setEnabled(user.isEnabled());
		userService.updateUser(oldUser);
		return "customers";
	}

	@RequestMapping(value = "/addnewcustomer", method = RequestMethod.POST)
	public String processAdd(@ModelAttribute("user") @Valid Users user, BindingResult bindingResult) {
		if(bindingResult.hasErrors()){
			return "registercustomer";
		} else{
		String username = getPrincipal();
		if (!username.equals("anonymousUser")) {
			userService.updateUser(user);
		} else{
		userService.save(user);
		Roles role = new Roles();
		if(user.getUsername().equalsIgnoreCase("Administrator") ||(user.getUsername().equalsIgnoreCase("Admin"))){
			role.setRole("ROLE_ADMIN");
		} else{
		role.setRole("ROLE_CUSTOMER");
		}
		role.setUsername(user.getUsername());
		roleService.Save(role);
	}
		return "redirect:/home";
		}
	}
	
	@ExceptionHandler(NoHandlerFoundException.class)
	public String handle(Exception ex) {
	    return "redirect:/page-not-found";
	}
	@RequestMapping(value = {"/page-not-found"}, method = RequestMethod.GET)
	public String NotFoudPage() {
	    return "page-not-found";

	}
	private String getPrincipal() {
		String userName = null;
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
			userName = ((UserDetails) principal).getUsername();
		} else {
			userName = principal.toString();
		}
		return userName;
	}

	//initialize 
}
