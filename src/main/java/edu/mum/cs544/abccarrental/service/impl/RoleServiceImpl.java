package edu.mum.cs544.abccarrental.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.cs544.abccarrental.model.Roles;
import edu.mum.cs544.abccarrental.repository.IRoleRepository;
import edu.mum.cs544.abccarrental.service.IRolesService;

@Service
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class RoleServiceImpl implements IRolesService{

	@Autowired
	IRoleRepository roleRepo;
	
	@Override
	public void Save(Roles role) {
		roleRepo.save(role);
		
	}

}
