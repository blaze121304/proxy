package com.rusty.proxy.controller;

import com.rusty.proxy.domain.dto.TaxBill;
import com.rusty.proxy.domain.service.ProxySerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/proxy")
public class ProxyController {

    private final ProxySerivce proxySerivce;

    @Autowired
    public ProxyController(ProxySerivce proxySerivce) {
        this.proxySerivce = proxySerivce;
    }

    @GetMapping("/tax/bill")
    private TaxBill getPaymentBill(TaxBill taxBill){

        return proxySerivce.getPaymentBill(taxBill);
    }





}
