package com.rusty.proxy.infra.Repository;

import com.rusty.proxy.domain.dto.ReqDetailFineData;
import com.rusty.proxy.domain.dto.ConfirmedFineData;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;

public interface InsertJpa {

    void execute(HttpEntity<ReqDetailFineData> requestEntity, ResponseEntity<ConfirmedFineData> responseEntity);

    void execute(ResponseEntity<ConfirmedFineData> responseEntity, HttpEntity<String> requestEntity);
}
