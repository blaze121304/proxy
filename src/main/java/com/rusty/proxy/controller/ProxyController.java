package com.rusty.proxy.controller;

import com.rusty.proxy.domain.dto.TaxBill;
import com.rusty.proxy.domain.dto.User;
import com.rusty.proxy.domain.service.ProxySerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/proxy")
public class ProxyController {

    private final ProxySerivce proxySerivce;

    @Autowired
    public ProxyController(ProxySerivce proxySerivce) {
        this.proxySerivce = proxySerivce;
    }

    @GetMapping("/user/{id}")
    private User findUserById(@PathVariable String id){
        return proxySerivce.find(id);
    }

    @GetMapping("/user")
    private User findAll(User user){
        return proxySerivce.findAll();
    }

//    @GetMapping("/tax/{id}")
//    private TaxBill findTaxById(TaxBill taxBill){
//        return null;
//    }
//
//    @PostMapping("/reg/{id}")
//    private TaxBill registId(TaxBill taxBill){
//        return null;
//    }
//
//    @PostMapping("/modify/{id}")
//    private TaxBill modifyId(TaxBill taxBill){
//        return null;
//    }


}
