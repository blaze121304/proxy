package com.rusty.proxy.domain.service;

import com.rusty.proxy.domain.dto.TaxBill;
import org.springframework.stereotype.Service;

@Service
public class ProxyServiceImpl implements ProxySerivce{

    /**
     * @return bill
     */
    @Override
    public TaxBill getPaymentBill(TaxBill taxBill) {
        return taxBill;
    }

}
