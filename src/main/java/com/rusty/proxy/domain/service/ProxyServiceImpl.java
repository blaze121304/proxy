package com.rusty.proxy.domain.service;

import com.rusty.proxy.domain.dto.ProxyDto;
import com.rusty.proxy.domain.vo.ProxyVo;
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

    @Autowired
    public ProxyServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
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
}
