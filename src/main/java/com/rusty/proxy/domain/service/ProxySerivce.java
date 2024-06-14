package com.rusty.proxy.domain.service;

import com.rusty.proxy.domain.dto.DetailFineData;
import com.rusty.proxy.domain.dto.ConfirmedFineData;
import org.springframework.http.ResponseEntity;

public interface ProxySerivce {
    ResponseEntity<DetailFineData> FineNewIncurService(String carName);
    ResponseEntity<String> FineNewIncurSendService(ConfirmedFineData confirmedFineData);
    ResponseEntity<ConfirmedFineData> carFine(DetailFineData detailFineData);


}
