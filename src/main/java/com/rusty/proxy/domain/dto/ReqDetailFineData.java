package com.rusty.proxy.domain.dto;

import lombok.Data;

//상세 과태료 데이터 요청
@Data
public class ReqDetailFineData {
    private String carNum;
    private String carName;
    private String admin;
}
