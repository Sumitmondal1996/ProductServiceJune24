package com.scaler.productservicejune24.commons;

import com.scaler.productservicejune24.dtos.UserResponsedto;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AuthUtil {
    private RestTemplate restTemplate;
    public AuthUtil(RestTemplate restTemplate)
    {
        this.restTemplate = restTemplate;
    }

    public UserResponsedto validateToken(String tokenValue)
    {
        return restTemplate.getForObject("http://localhost:8083/users/validate/"+ tokenValue,
                UserResponsedto.class);
    }
}
