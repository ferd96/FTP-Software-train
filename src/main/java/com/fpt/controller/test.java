package com.fpt.controller;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class test {
    public static void main(String[] args) {
         BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
         String p = "111";
         String ps ="$2a$10$bC3fIu4WyB/FGwlbOPlZt.3IRzkM34vZNt1Kbe5ZDcq7r/XZFWNrO";
        System.out.println(bcrypt.matches(p,ps));
    }
}
