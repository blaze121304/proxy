package com.rusty.proxy.domain.service;

import com.rusty.proxy.domain.dto.DetailFineData;
import com.rusty.proxy.domain.dto.ConfirmedFineData;
import com.rusty.proxy.domain.vo.ProxyVo;
import com.rusty.proxy.infra.Repository.InsertJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.StandardCharsets;
import java.util.Collections;


@Service
public class ProxyServiceImpl implements ProxySerivce{

    private final RestTemplate restTemplate;
    private final InsertJpa insertJpa;

    @Autowired
    public ProxyServiceImpl(RestTemplate restTemplate, InsertJpa insertJpa) {
        this.restTemplate = restTemplate;
        this.insertJpa = insertJpa;
    }

    /**
     * 1. 신규발생(과태료 발부 확정)
     * 1.1. (1) 대상 차량 번호 전송 (가산->휘슬)
     *
     * @param carNum 대상 차량 번호
     * @return DetailFineData 상세 과태료 데이터
     */
    @Override
    public ResponseEntity<DetailFineData> FineNewIncurService(String carNum) {

        String url = "";    //휘슬로 요청할 url
        HttpHeaders headers = getHttpHeadersJson();
        HttpEntity<String> requestEntity = new HttpEntity<>(carNum,headers);

        try{
            ResponseEntity<DetailFineData> responseEntity = restTemplate.exchange(url,HttpMethod.GET,requestEntity, DetailFineData.class);
            return responseEntity;
        }catch (RestClientException rcex){
            throw new RestClientException("[Service] RestClientException : " + rcex.getMessage());
        }

    }


    /**
     * 1. 신규발생(과태료 발부 확정)
     * 1.2. (4)데이터 확인 - 주정차 과태료 데이터 전송 (가산->휘슬)
     * @param confirmedFineData
     * @return String
     */
    @Override
    public ResponseEntity<String> FineNewIncurSendService(ConfirmedFineData confirmedFineData) {

        String url = ProxyVo.ProxyEnum.DEV_010_URL.getValue() + ProxyVo.ProxyEnum.API_URL.getValue();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);

        MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
        body.add("orgCode", confirmedFineData.getOrgCode());
        body.add("userName", confirmedFineData.getUserName());

        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(body, headers);

        try{
            return restTemplate.exchange(url, HttpMethod.POST, requestEntity, String.class);
        }catch (RestClientException rcex){
            throw new RestClientException("[Service] RestClientException : " + rcex.getMessage());
        }

    }

    /**
     * @param detailFineData
     * @return
     */
    @Override
    public ResponseEntity<ConfirmedFineData> carFine(DetailFineData detailFineData) {

        String url = "";    //가산으로 요청할 url (차 번호로 request)
        HttpHeaders headers = getHttpHeadersJson();
        HttpEntity<DetailFineData> requestEntity = new HttpEntity<>(detailFineData,headers);

        try{
            ResponseEntity<ConfirmedFineData> responseEntity = restTemplate.exchange(url,HttpMethod.GET,requestEntity, ConfirmedFineData.class);
            saveDB(requestEntity,responseEntity);
            return responseEntity;
        }catch (RestClientException rcex){
            throw new RestClientException("[Service] RestClientException : " + rcex.getMessage());
        }

    }



    private static HttpHeaders getHttpHeadersJson() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.setContentType(new MediaType("application","json",StandardCharsets.UTF_8));
        return headers;
    }

    private void saveDB(HttpEntity<DetailFineData> requestEntity, ResponseEntity<ConfirmedFineData> responseEntity) {
        insertJpa.execute(requestEntity,responseEntity);
    }

    private void saveDB(ResponseEntity<ConfirmedFineData> responseEntity, HttpEntity<String> requestEntity) {
        insertJpa.execute(responseEntity,requestEntity);
    }



}
