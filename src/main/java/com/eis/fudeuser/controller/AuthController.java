package com.eis.fudeuser.controller;

import com.eis.fudeuser.dto.request.BrokerLoginRequest;
import com.eis.fudeuser.dto.request.BrokerRegisterRequest;
import com.eis.fudeuser.dto.request.TraderLoginRequest;
import com.eis.fudeuser.dto.request.TraderRegisterRequest;
import com.eis.fudeuser.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @RequestMapping(value = "/trader/login", method = {RequestMethod.POST, RequestMethod.OPTIONS}, produces = "application/json;charset=UTF-8")
    public ResponseEntity<?> traderLogin(@RequestBody TraderLoginRequest loginRequest) throws NoSuchAlgorithmException, IOException, InvalidKeySpecException {
        return new ResponseEntity<>(authService.traderLogin(loginRequest), HttpStatus.OK);
    }

    @RequestMapping(value = "/broker/login", method = {RequestMethod.POST, RequestMethod.OPTIONS}, produces = "application/json;charset=UTF-8")
    public ResponseEntity<?> brokerLogin(@RequestBody BrokerLoginRequest loginRequest) throws NoSuchAlgorithmException, IOException, InvalidKeySpecException {
        return new ResponseEntity<>(authService.brokerLogin(loginRequest), HttpStatus.OK);
    }

    @RequestMapping(value = "/trader/register", method = {RequestMethod.POST, RequestMethod.OPTIONS}, produces = "application/json;charset=UTF-8")
    public ResponseEntity<?> traderRegiser(@RequestBody TraderRegisterRequest registerRequest) {
        return new ResponseEntity<>(authService.traderRegister(registerRequest), HttpStatus.OK);
    }

    @RequestMapping(value = "/broker/register", method = {RequestMethod.POST, RequestMethod.OPTIONS}, produces = "application/json;charset=UTF-8")
    public ResponseEntity<?> brokerRegister(@RequestBody BrokerRegisterRequest registerRequest) {
        return new ResponseEntity<>(authService.brokerRegister(registerRequest), HttpStatus.OK);
    }
}
