package com.rusty.proxy.infra.dao;

import jakarta.persistence.Id;
import lombok.Data;
import org.antlr.v4.runtime.misc.NotNull;

@Data
public class TaxBillDao {

    @Id
    String id;

    @NotNull
    String name;
    String pay;
    String countNum;


}
