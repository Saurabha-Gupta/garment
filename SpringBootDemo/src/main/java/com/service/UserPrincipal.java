package com.service;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.entity.UsrMain;

public class UserPrincipal implements UserDetails{

	private UsrMain usrMain;
	public UserPrincipal(UsrMain usrMain) {
		// TODO Auto-generated constructor stub
		this.usrMain = usrMain;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return Collections.singleton(new SimpleGrantedAuthority("USER"));
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return this.usrMain.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		System.out.println(this.usrMain.getUsername()+" ################ UserID ######################");
		return this.usrMain.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
