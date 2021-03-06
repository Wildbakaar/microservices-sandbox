package net.bakaar.sandbox.infra.data.rest;

import net.bakaar.sandbox.domain.number.BusinessNumberRepository;
import net.bakaar.sandbox.domain.shared.AddressNumber;
import net.bakaar.sandbox.infra.data.rest.configuration.BusinessNumberServiceProperties;
import net.bakaar.sandbox.shared.domain.vo.PNumber;
import org.springframework.web.client.RestTemplate;

public class BusinessNumberRepositoryAdapter implements BusinessNumberRepository {
    private final BusinessNumberServiceProperties properties;
    private final RestTemplate restTemplate;

    private static final String API_URL = "rest/api/v1/business-number";

    public BusinessNumberRepositoryAdapter(BusinessNumberServiceProperties properties, RestTemplate restTemplate) {
        this.properties = properties;
        this.restTemplate = restTemplate;
    }

    @Override
    public PNumber fetchNextPNumber() {
        String url = String.format("%s/%s/person-id", properties.getUrl(), API_URL);
        return PNumber.of(restTemplate.getForObject(url, Long.class));
    }

    @Override
    public AddressNumber fetchNextAddressNumber() {
        String url = String.format("%s/%s/address-id", properties.getUrl(), API_URL);
        return AddressNumber.of(restTemplate.getForObject(url, Long.class));
    }
}
