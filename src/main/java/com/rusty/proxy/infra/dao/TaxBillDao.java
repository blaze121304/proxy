package com.rusty.proxy.infra.dao;

import jakarta.persistence.Id;
import lombok.Data;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.web.multipart.MultipartFile;

@Data
public class TaxBillDao {

    @Id
    String carNum;
    String carName;
    String admin;

    String name;
    String pay;
    String countNum;

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
    MultipartFile violationImage01;
    MultipartFile violationImage02;
    MultipartFile violationImage03;
    MultipartFile violationImage04;


}
