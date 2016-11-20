package edu.mum.cs544.abccarrental.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.cs544.abccarrental.model.Users;

public interface IUserRepository extends CrudRepository<Users, Integer> {

	@Query("select u from Users u")
	List<Users> findAllUsers();
	@Query("select u from Users u where u.username = :userName")
	Users findUserByUserName(@Param("userName") String username);
	@Modifying
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	@Query("update Users u set u.password = :password, u.email = :email, u.name = :name,u.city = :city, u.street = :street"
			+ ",u.state = :state, u.zip = :zip, u.country = :country where u.username = :username")
	void updateUser(@Param("password") String password, @Param("email") String email, @Param("name") String name,
					@Param("street") String street, @Param("state") String state, @Param("zip") String zip,
					@Param("country") String country, @Param("username") String username, @Param("city") String city);
}
