package com.rusty.proxy.domain.vo;

public class ProxyVo {
    private final ProxyEnum proxyEnum;

    public ProxyVo(ProxyEnum proxyEnum) {
        this.proxyEnum = proxyEnum;
    }

    public enum ProxyEnum{

        DEV_010_URL("https://qapi-dev.010car.kr/"),
        API_URL("qapi/violation/receiveAlert");


        private final String value;

        ProxyEnum(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }
}
