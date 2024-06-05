package com.rusty.proxy.domain.service;

import com.rusty.proxy.domain.dto.ProxyDto;
import org.springframework.http.ResponseEntity;

public interface ProxySerivce {
    ResponseEntity<String> alert(ProxyDto proxyDto);
}
