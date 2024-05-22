package com.rusty.proxy.domain.service;

import com.rusty.proxy.domain.dto.TaxBill;
import com.rusty.proxy.domain.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ProxyServiceImpl implements ProxySerivce{

    private final RestTemplate restTemplate;

    @Autowired
    public ProxyServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    /**
     * @param id
     * @return
     */
    @Override
    public User find(String id) {

        User user = new User();
        user.setId("rusty");
        user.setAddr("부산");
        user.setName("KIMKIWOOK");
        user.setTaxNum("1124211");

        return user;
    }
}
