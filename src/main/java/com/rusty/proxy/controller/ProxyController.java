package com.rusty.proxy.controller;

import com.rusty.proxy.domain.dto.ReqDetailFineData;
import com.rusty.proxy.domain.dto.ConfirmedFineData;
import com.rusty.proxy.domain.dto.TaxYnDto;
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

    //1. 신규 발생 (과태료 발부 확정) - 대상 차량번호 전송 / 상세 과태료 데이터 요청
    @GetMapping(value = "/nfine")
    @ResponseBody
    private ResponseEntity<ReqDetailFineData> FineNewIncur(@RequestBody String carNum){

        return proxySerivce.FineNewIncurService(carNum);

    }

    //2. 확정 과태료 데이터 전송 - 주정차 과태료 데이터 전송 / 수신 응답
    @PostMapping("/alert")
    private ResponseEntity<String> FineNewIncurSend(ConfirmedFineData confirmedFineData){

        return proxySerivce.FineNewIncurSendService(confirmedFineData);

    }
    @GetMapping(value = "/cfine")
    @ResponseBody
    private ResponseEntity<ConfirmedFineData> carFine(@RequestBody TaxYnDto taxYnDto){

        return proxySerivce.PaidFineCheck(taxYnDto);

    }


}
