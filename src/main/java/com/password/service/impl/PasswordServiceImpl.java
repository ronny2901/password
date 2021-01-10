package com.password.service.impl;

import com.password.service.PasswordService;
import org.springframework.stereotype.Service;


@Service("passwordService")
public class PasswordServiceImpl implements PasswordService {

    @Override
    public boolean passwordValidation(String password) throws Exception {
        boolean result = false;
        try{
            String regex = "^(?!.*([A-Za-z0-9])\\1{1})(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*()-+])(?=\\S+$).{8,}$";
            result = password.matches(regex);
        }
       catch (Exception e){
            throw new Exception(e.getMessage(), e.getCause());
       }
        return result;
    }
}
