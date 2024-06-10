package com.rusty.proxy.domain.service;

import com.rusty.proxy.domain.dto.CarDto;
import com.rusty.proxy.domain.dto.ProxyDto;
import org.springframework.http.ResponseEntity;

public interface ProxySerivce {
    ResponseEntity<String> alert(ProxyDto proxyDto);
    ResponseEntity<ProxyDto> carFine(CarDto carDto);
    ResponseEntity<ProxyDto> carFine(String carName);


}
