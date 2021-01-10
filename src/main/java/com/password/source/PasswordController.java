package com.password.source;

import com.password.service.PasswordService;
import io.swagger.annotations.Api;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping(value="/password")
@Api(tags="Password Validation")
public class PasswordController {

    @Autowired
    PasswordService service;

    @GetMapping(value="/validate")
    @ResponseBody
    public Object passwordValidation(@RequestParam String password) throws Exception {

        boolean result =  service.passwordValidation(password);
        JSONObject json=new JSONObject();
        json.put("result",result);

        return json.toString();
    }
}
