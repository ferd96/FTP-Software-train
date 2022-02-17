package com.fpt.service.impl;

import com.fpt.entity.Users;
import com.fpt.repository.UsersRepo;
import com.fpt.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.Optional;

@Service
public class UsersServiceImpl implements UsersService {
    private BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
    @Autowired
    private UsersRepo repo;



    @Override
    public Users findById(Long id) {
        Optional<Users> optional = repo.findById(id);
        return optional.isPresent() ? optional.get() : null;
    }

    @Override
    public Users doLogin(String username, String password) {
        Users user = repo.findByUsername(username);//
        if (ObjectUtils.isEmpty(user)) {
            return null;
        } else {
          boolean checkPassword= bcrypt.matches(password,user.getHashPassword()); // matches để so sánh password của db mã hóa của db vs người dùng nhập
          return  checkPassword == true?user:null;
        }
    }

}
