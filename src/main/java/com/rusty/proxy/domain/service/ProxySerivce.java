package com.rusty.proxy.domain.service;

import com.rusty.proxy.domain.dto.ReqDetailFineData;
import com.rusty.proxy.domain.dto.ConfirmedFineData;
import com.rusty.proxy.domain.dto.TaxYnDto;
import org.springframework.http.ResponseEntity;

public interface ProxySerivce {
    ResponseEntity<ReqDetailFineData> FineNewIncurService(String carName);
    ResponseEntity<String> FineNewIncurSendService(ConfirmedFineData confirmedFineData);
    ResponseEntity<ConfirmedFineData> PaidFineCheck(TaxYnDto taxYnDto);


}
