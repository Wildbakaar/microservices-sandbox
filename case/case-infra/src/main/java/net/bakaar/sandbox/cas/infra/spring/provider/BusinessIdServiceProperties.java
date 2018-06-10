package net.bakaar.sandbox.cas.infra.spring.provider;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("service.businessId")
public class BusinessIdServiceProperties {
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
