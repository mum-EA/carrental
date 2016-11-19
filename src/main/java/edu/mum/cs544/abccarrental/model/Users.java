package edu.mum.cs544.abccarrental.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.JoinColumn;


@Entity
public class Users implements Serializable{


	private static final long serialVersionUID = 10000000000000012L;
	@Id
	private String username;
	private String password;
	private boolean enabled;
	private String email;
	@Embedded
	private Address address;
	
	 @ManyToMany(fetch = FetchType.LAZY)
	    @JoinTable(name = "user_roles", 
	             joinColumns = { @JoinColumn(name = "User_Id") }, 
	             inverseJoinColumns = { @JoinColumn(name = "Role_Id") })
	    private Set<Roles> userRoles = new HashSet<Roles>();
	//user info
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public Set<Roles> getUserRoles() {
		return userRoles;
	}
	public void setUserRoles(Set<Roles> userRoles) {
		this.userRoles = userRoles;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Users other = (Users) obj;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
	
	
}
