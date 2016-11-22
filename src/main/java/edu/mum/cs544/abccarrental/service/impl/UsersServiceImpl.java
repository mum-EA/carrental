package edu.mum.cs544.abccarrental.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.cs544.abccarrental.model.Users;
import edu.mum.cs544.abccarrental.repository.IUserRepository;
import edu.mum.cs544.abccarrental.service.IUsersService;

@Service
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class UsersServiceImpl implements IUsersService {

	@Autowired
	IUserRepository userRepo;
	@Autowired
    private PasswordEncoder passwordEncoder;
	@Override
	public void delete(int userId) {
		userRepo.delete(userId);
	}
	@Override
	public void save(Users user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		user.setEnabled(true); //when a customer creates an account, the are enabled
		userRepo.save(user);
	}
	@Override
	public Users findOne(int userId) {
		// TODO Auto-generated method stub
		return userRepo.findOne(userId);
	}
	@Override
	public List<Users> findAllUsers() {
		// TODO Auto-generated method stub
		System.out.println("From service");
		System.out.println(userRepo.findAll());
		return userRepo.findAll();
	}
	@Override
	public Users findUserByUserName(String username) {
		// TODO Auto-generated method stub
		return userRepo.findUserByUserName(username);
	}
	@Override
	public void updateUser(Users user) {
		
		Users userOld = userRepo.findUserByUserName(user.getUsername());
		if(userOld!=null){
			if(!user.getPassword().equals(userOld.getPassword())){
                userOld.setPassword(passwordEncoder.encode(user.getPassword()));
            }
			userRepo.updateUser(userOld.getPassword(), user.getEmail(), user.getName(), user.getStreet(), user.getState(), user.getZip(), user.getCountry(), user.getUsername(), user.getCity());
		}
	}
	
	

}
