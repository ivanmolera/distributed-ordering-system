package com.appchana.dos.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * Created by ivanmolera on 12/04/2018.
 */
@RestController
@RequestMapping("/user-authentication")
public class AuthenticationController {

    @PostMapping
    public Boolean userAuthentication(@Valid @PathVariable String username, @Valid @PathVariable String password) {
        return Boolean.TRUE;
    }
}
