package com.rusty.proxy.infra.Repository;

import com.rusty.proxy.domain.dto.CarDto;
import com.rusty.proxy.domain.dto.ProxyDto;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;

public interface InsertJpa {

    void execute(HttpEntity<CarDto> requestEntity, ResponseEntity<ProxyDto> responseEntity);

    void execute(ResponseEntity<ProxyDto> responseEntity, HttpEntity<String> requestEntity);
}
