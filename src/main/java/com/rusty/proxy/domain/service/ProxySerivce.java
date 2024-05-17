package com.rusty.proxy.domain.service;

import com.rusty.proxy.domain.dto.TaxBill;

public interface ProxySerivce {

    TaxBill getPaymentBill(TaxBill taxBill);

}
