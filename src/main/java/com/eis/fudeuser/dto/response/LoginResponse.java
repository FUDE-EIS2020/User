package com.eis.fudeuser.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponse {
    private Boolean success;
    private String userId;
    private String jwt;
    private String msg;
}
