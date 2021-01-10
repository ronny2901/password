package com.password.service;

import org.springframework.http.ResponseEntity;

public interface PasswordService {

    public boolean passwordValidation(String password) throws Exception;

}
