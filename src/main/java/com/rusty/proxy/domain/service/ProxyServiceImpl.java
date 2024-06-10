package com.rusty.proxy.domain.service;

import com.rusty.proxy.domain.dto.CarDto;
import com.rusty.proxy.domain.dto.ProxyDto;
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
     * @return
     */
    @Override
    public ResponseEntity<String> alert(ProxyDto proxyDto) {

        String url = ProxyVo.ProxyEnum.DEV_010_URL.getValue() + ProxyVo.ProxyEnum.API_URL.getValue();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);

        MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
        body.add("orgCode",proxyDto.getOrgCode());
        body.add("userName",proxyDto.getUserName());

        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(body, headers);
        //String response = restTemplate.postForObject(url, body, String.class);

        try{
            return restTemplate.exchange(url, HttpMethod.POST, requestEntity, String.class);
        }catch (RestClientException rcex){
            throw new RestClientException("[Service] RestClientException : " + rcex.getMessage());
        }

    }

    /**
     * @param carDto
     * @return
     */
    @Override
    public ResponseEntity<ProxyDto> carFine(CarDto carDto) {

        String url = "";    //가산으로 요청할 url (차 번호로 request)
        HttpHeaders headers = getHttpHeadersJson();
        HttpEntity<CarDto> requestEntity = new HttpEntity<>(carDto,headers);

        try{
            ResponseEntity<ProxyDto> responseEntity = restTemplate.exchange(url,HttpMethod.GET,requestEntity,ProxyDto.class);
            saveDB(requestEntity,responseEntity);
            return responseEntity;
        }catch (RestClientException rcex){
            throw new RestClientException("[Service] RestClientException : " + rcex.getMessage());
        }

    }


    /**
     * @param carName
     * @return
     */
    @Override
    public ResponseEntity<ProxyDto> carFine(String carName) {

        String url = "";    //가산으로 요청할 url (차 번호로 request)
        HttpHeaders headers = getHttpHeadersJson();
        HttpEntity<String> requestEntity = new HttpEntity<>(carName,headers);

        try{
            ResponseEntity<ProxyDto> responseEntity = restTemplate.exchange(url,HttpMethod.GET,requestEntity,ProxyDto.class);
            saveDB(responseEntity,requestEntity);
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

    private void saveDB(HttpEntity<CarDto> requestEntity, ResponseEntity<ProxyDto> responseEntity) {
        insertJpa.excute(requestEntity,responseEntity);
    }

    private void saveDB( ResponseEntity<ProxyDto> responseEntity, HttpEntity<String> requestEntity) {
        insertJpa.excute(responseEntity,requestEntity);
    }



}
