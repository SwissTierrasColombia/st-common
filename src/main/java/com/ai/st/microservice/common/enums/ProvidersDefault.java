package com.ai.st.microservice.common.enums;

public enum ProvidersDefault {

    PROVIDER_IGAC_ID((long) 1),
    PROVIDER_SNR_ID((long) 8);

    private final Long id;

    ProvidersDefault(Long id) {
        this.id = id;
    }

    public Long id() {
        return id;
    }

}
