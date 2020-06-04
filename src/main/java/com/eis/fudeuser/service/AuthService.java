package com.eis.fudeuser.service;

import com.eis.fudeuser.dto.GeneralMessage;
import com.eis.fudeuser.dto.request.BrokerLoginRequest;
import com.eis.fudeuser.dto.request.BrokerRegisterRequest;
import com.eis.fudeuser.dto.request.TraderLoginRequest;
import com.eis.fudeuser.dto.request.TraderRegisterRequest;
import com.eis.fudeuser.dto.response.LoginResponse;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

public interface AuthService {
    LoginResponse traderLogin(TraderLoginRequest traderLoginRequest) throws NoSuchAlgorithmException, IOException, InvalidKeySpecException;

    LoginResponse brokerLogin(BrokerLoginRequest brokerLoginRequest) throws NoSuchAlgorithmException, IOException, InvalidKeySpecException;

    GeneralMessage traderRegister(TraderRegisterRequest traderRegisterRequest);

    GeneralMessage brokerRegister(BrokerRegisterRequest brokerRegisterRequest);
}
