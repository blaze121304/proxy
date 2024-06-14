package com.rusty.proxy.controller;

import com.rusty.proxy.domain.dto.DetailFineData;
import com.rusty.proxy.domain.dto.ConfirmedFineData;
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

    //1. 신규 발생 (과태료 발부 확정)
    @GetMapping(value = "/cnfine")
    @ResponseBody
    private ResponseEntity<DetailFineData> FineNewIncur(@RequestBody String carNum){

        return proxySerivce.FineNewIncurService(carNum);

    }

    @PostMapping("/alert")
    private ResponseEntity<String> FineNewIncurSend(ConfirmedFineData confirmedFineData){

        return proxySerivce.FineNewIncurSendService(confirmedFineData);

    }
    @GetMapping(value = "/cfine")
    @ResponseBody
    private ResponseEntity<ConfirmedFineData> carFine(@RequestBody DetailFineData detailFineData){

        return proxySerivce.carFine(detailFineData);

    }


}
