package com.rusty.proxy.infra.Repository;

import com.rusty.proxy.domain.dto.CarDto;
import com.rusty.proxy.domain.dto.ProxyDto;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

@Repository
public class InsertJpaImpl implements InsertJpa {
    /**
     * @param requestEntity
     * @param responseEntity
     */
    @Override
    public void execute(HttpEntity<CarDto> requestEntity, ResponseEntity<ProxyDto> responseEntity) {

    }

    /**
     * @param responseEntity
     * @param requestEntity
     */
    @Override
    public void execute(ResponseEntity<ProxyDto> responseEntity, HttpEntity<String> requestEntity) {

    }
}
