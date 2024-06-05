package com.rusty.proxy.controller;

import com.rusty.proxy.domain.dto.ProxyDto;
import com.rusty.proxy.domain.dto.User;
import com.rusty.proxy.domain.service.ProxySerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/proxy")
public class ProxyController {

    private final ProxySerivce proxySerivce;

    @Autowired
    public ProxyController(ProxySerivce proxySerivce) {
        this.proxySerivce = proxySerivce;
    }

    @PostMapping("/alert")
    private ResponseEntity<String> sendAlert(ProxyDto proxyDto){
        return proxySerivce.alert(proxyDto);
    }

    @PostMapping("/test")
    @ResponseBody
    private User sendTest(@RequestBody User user){
        return user;
    }
}
