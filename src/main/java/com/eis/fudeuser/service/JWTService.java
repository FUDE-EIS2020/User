package com.eis.fudeuser.service;

import io.jsonwebtoken.Claims;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;
import java.util.Map;

public interface JWTService {
    public Claims verifyJwt(String token, String keyString) throws NoSuchAlgorithmException, IOException, InvalidKeySpecException;

    public String generateToken(Map<String, Object> claims, ArrayList<String> scopes, String key) throws NoSuchAlgorithmException, IOException, InvalidKeySpecException;
}
