package com.rusty.proxy.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProxyDto {
    String orgCode;
    String userName;
    String userAddress;
    String carNo;
    String violationCode;
    String violationName;
    String violationDivision;
    String violationDetail;
    String violationDt;
    String violationLocation;
    String volunteerPaymentPeriod;
    String mainTax;
    String surcharge;
    String addSurcharge;
    String violationFee;
    String confirmDate;
    String dueDate;
    String virtualBank;
    String virtualBankPaymentNo;
    String electronicPaymentNo;
    String violationImage01;
    String violationImage02;
    String violationImage03;
    String violationImage04;

}
