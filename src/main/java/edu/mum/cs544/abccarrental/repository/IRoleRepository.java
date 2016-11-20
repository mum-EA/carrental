package edu.mum.cs544.abccarrental.repository;

import org.springframework.data.repository.CrudRepository;

import edu.mum.cs544.abccarrental.model.Roles;

public interface IRoleRepository extends CrudRepository<Roles, Integer> {

}
