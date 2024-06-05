package com.rusty.proxy.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;

@Data
public class ProxyDto {

    private String orgCode;
    private String userName;
    private String userAddress;
    private String carNo;
    private String violationCode;
    private String violationName;
    private String violationDivision;
    private String violationDetail;
    private String violationDt;
    private String violationLocation;
    private String volunteerPaymentPeriod;
    private String mainTax;
    private String surcharge;
    private String addSurcharge;
    private String violationFee;
    private String confirmDate;
    private String dueDate;
    private String virtualBank;
    private String virtualBankPaymentNo;
    private String electronicPaymentNo;
    private MultipartFile violationImage01;
    private MultipartFile violationImage02;
    private MultipartFile violationImage03;
    private MultipartFile violationImage04;

}
