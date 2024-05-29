package com.rusty.proxy.domain.service;

import com.rusty.proxy.domain.dto.TaxBill;
import com.rusty.proxy.domain.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ProxyServiceImpl implements ProxySerivce{

    private final RestTemplate restTemplate;
    private final User user;

    @Autowired
    public ProxyServiceImpl(RestTemplate restTemplate, User user) {
        this.restTemplate = restTemplate;
        this.user = user;

        user.setId("rusty");
        user.setAddr("부산");
        user.setName("KIMKIWOOK");
        user.setTaxNum("1124211");

    }

    /**
     * @param id
     * @return User
     */
    @Override
    public User find(String id) {

        //return user.get
    }

    /**
     * @return User
     */
    @Override
    public User findAll() {
        return user;
    }
}
