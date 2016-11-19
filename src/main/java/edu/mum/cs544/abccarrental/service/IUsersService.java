package edu.mum.cs544.abccarrental.service;

import java.util.List;


import edu.mum.cs544.abccarrental.model.Users;

public interface IUsersService {

	void delete(int userId);
	void save(Users user);
	Users findOne(int userId);
	List<Users> findAllUsers();
	Users findUserByUserName(String username);
	void updateUser(Users user);
	
}
