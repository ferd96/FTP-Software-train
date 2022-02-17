package com.fpt.service;

import com.fpt.entity.Users;


public interface UsersService {

	Users findById(Long id);
	Users doLogin(String username, String password); //login

}
