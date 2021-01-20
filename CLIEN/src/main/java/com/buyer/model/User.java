package com.buyer.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.boot.autoconfigure.domain.EntityScan;

public class User {
	private Long id; 
	private String username;
 
	private String password;
	
	private String salt;
	
	private String email;
 
	private boolean enabled;
	 private String one_time_password;
	 
	 private Date otp_requested_time;
	private Set<Role> roles = new HashSet<>();

	public User() {
//		super();
	}

	
	public String getOne_time_password() {
		return one_time_password;
	}


	public void setOne_time_password(String one_time_password) {
		this.one_time_password = one_time_password;
	}


	public Date getOtp_requested_time() {
		return otp_requested_time;
	}


	public void setOtp_requested_time(Date otp_requested_time) {
		this.otp_requested_time = otp_requested_time;
	}


	public Long getId() {
		return id;
	} 

	public void setId(Long id) {
		this.id = id;
	}

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

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	
	
}
