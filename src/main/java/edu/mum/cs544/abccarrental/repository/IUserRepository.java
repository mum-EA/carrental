package edu.mum.cs544.abccarrental.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import edu.mum.cs544.abccarrental.model.Users;

public interface IUserRepository extends CrudRepository<Users, Integer> {

	@Query("select u from Users u")
	List<Users> findAllUsers();
	@Query("select u from Users u where u.username = :userName")
	Users findUserByUserName(@Param("skillName") String username);
}
