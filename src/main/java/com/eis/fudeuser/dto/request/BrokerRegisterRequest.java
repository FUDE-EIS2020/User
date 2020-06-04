package com.eis.fudeuser.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BrokerRegisterRequest {
    private String name;
    private String password;
}
