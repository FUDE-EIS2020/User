package com.eis.fudeuser.serviceImpl;

import com.eis.fudeuser.dto.GeneralMessage;
import com.eis.fudeuser.dto.request.BrokerLoginRequest;
import com.eis.fudeuser.dto.request.BrokerRegisterRequest;
import com.eis.fudeuser.dto.request.TraderLoginRequest;
import com.eis.fudeuser.dto.request.TraderRegisterRequest;
import com.eis.fudeuser.dto.response.LoginResponse;
import com.eis.fudeuser.entity.Broker;
import com.eis.fudeuser.entity.Trader;
import com.eis.fudeuser.repository.BrokerRepository;
import com.eis.fudeuser.repository.TraderRepository;
import com.eis.fudeuser.service.AuthService;
import com.eis.fudeuser.service.JWTService;
import com.eis.fudeuser.utils.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.HashMap;
import java.util.Map;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private JWTService jwtService;

    @Autowired
    private TraderRepository traderRepository;

    @Autowired
    private BrokerRepository brokerRepository;

    @Override
    public LoginResponse traderLogin(TraderLoginRequest traderLoginRequest) throws NoSuchAlgorithmException, IOException, InvalidKeySpecException {
        Trader trader = traderRepository.findByCompNameAndName(traderLoginRequest.getCompName(), traderLoginRequest.getName());
        if (trader == null) {
            return new LoginResponse(false, "", "", "no trader");
        } else {
            if (this.checkPw(traderLoginRequest.getPassword(), trader.getToken())) {
                // password true
                Map<String, Object> claims = new HashMap<>();
                claims.put("traderId", trader.getId());

                String jwt = jwtService.generateToken(claims, null, null);

                return new LoginResponse(true, trader.getId().toString(), jwt, "OK");
            } else {
                // wrong password
                return new LoginResponse(false, "", "", "wrong password");
            }
        }
    }

    @Override
    public LoginResponse brokerLogin(BrokerLoginRequest brokerLoginRequest) throws NoSuchAlgorithmException, IOException, InvalidKeySpecException {
        Broker broker = brokerRepository.findByName(brokerLoginRequest.getName());
        if (broker == null) {
            return new LoginResponse(false, "", "", "no broker");
        } else {
            if (this.checkPw(brokerLoginRequest.getPassword(), broker.getToken())) {
                // password true
                Map<String, Object> claims = new HashMap<>();
                claims.put("brokerId", broker.getId());

                String jwt = jwtService.generateToken(claims, null, null);

                return new LoginResponse(true, broker.getId().toString(), jwt, "OK");
            } else {
                // wrong password
                return new LoginResponse(false, "", "", "wrong password");
            }
        }
    }

    @Override
    public GeneralMessage traderRegister(TraderRegisterRequest traderRegisterRequest) {
        if (traderRepository.existsByCompNameAndName(traderRegisterRequest.getCompName(), traderRegisterRequest.getName())) {
            // replicate username
            return new GeneralMessage(400, "username exists");
        } else {
            Trader trader = new Trader();
            trader.setCompName(traderRegisterRequest.getCompName());
            trader.setName(traderRegisterRequest.getName());
            trader.setToken(BCrypt.hashpw(traderRegisterRequest.getPassword()));
            traderRepository.save(trader);
            return new GeneralMessage(200, "register success");
        }
    }

    @Override
    public GeneralMessage brokerRegister(BrokerRegisterRequest brokerRegisterRequest) {
        if (brokerRepository.existsByName(brokerRegisterRequest.getName())) {
            // replicate username
            return new GeneralMessage(400, "username exists");
        } else {
            Broker broker = new Broker();
            broker.setName(brokerRegisterRequest.getName());
            broker.setToken(BCrypt.hashpw(brokerRegisterRequest.getPassword()));
            brokerRepository.save(broker);
            return new GeneralMessage(200, "register success");
        }
    }

    private Boolean checkPw(String input, String password) {
        return BCrypt.checkpw(input, password);
    }
}
