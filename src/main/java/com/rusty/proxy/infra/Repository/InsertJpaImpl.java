package com.rusty.proxy.infra.Repository;

import com.rusty.proxy.domain.dto.DetailFineData;
import com.rusty.proxy.domain.dto.ConfirmedFineData;
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
    public void execute(HttpEntity<DetailFineData> requestEntity, ResponseEntity<ConfirmedFineData> responseEntity) {

    }

    /**
     * @param responseEntity
     * @param requestEntity
     */
    @Override
    public void execute(ResponseEntity<ConfirmedFineData> responseEntity, HttpEntity<String> requestEntity) {

    }
}
