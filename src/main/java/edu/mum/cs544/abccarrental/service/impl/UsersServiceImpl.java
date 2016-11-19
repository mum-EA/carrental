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
		user.setUsername(passwordEncoder.encode(user.getUsername()));
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
		return userRepo.findAllUsers();
	}
	@Override
	public Users findUserByUserName(String username) {
		// TODO Auto-generated method stub
		return userRepo.findUserByUserName(username);
	}
	@Override
	public void updateUser(Users user) {
		// TODO Auto-generated method stub
		Users userOld = userRepo.findUserByUserName(user.getUsername());
		if(userOld!=null){
			userOld.setUsername(user.getUsername());
			if(!user.getPassword().equals(userOld.getPassword())){
                userOld.setPassword(passwordEncoder.encode(user.getPassword()));
            }
			userOld.setEmail(user.getEmail());
			userOld.setEnabled(user.isEnabled());
			userOld.setAddress(user.getAddress());
			userOld.setUserRoles(user.getUserRoles());
		}
	}
	

}
