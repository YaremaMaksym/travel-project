package com.xsakon.travelproject.login;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "TravelProject/login")
@AllArgsConstructor
public class LoginController {

    private final LoginService loginService;

    @PostMapping
    public String login(@RequestBody LoginRequest loginRequest) {
        loginService.login(loginRequest);
        return "Logged";
    }

}
