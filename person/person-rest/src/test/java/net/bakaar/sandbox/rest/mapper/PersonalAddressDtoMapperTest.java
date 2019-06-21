package net.bakaar.sandbox.rest.mapper;

import net.bakaar.sandbox.domain.person.PersonalAddress;
import net.bakaar.sandbox.domain.shared.AddressNumber;
import net.bakaar.sandbox.rest.dto.PersonalAddressDTO;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PersonalAddressDtoMapperTest {

    @Test
    public void mapToDomain_should_map_correctly() {
        // Given
        String addressLine = "My Address bli";
        AddressNumber addressId = AddressNumber.of(674397124L);
        PersonalAddressDTO dto = new PersonalAddressDTO();
        dto.setAddress(addressLine);
        dto.setId(addressId.format());
        // When
        PersonalAddressDtoMapper mapper = new PersonalAddressDtoMapper();
        PersonalAddress address = mapper.mapToDomain(dto);
        // Then
        assertThat(address).isNotNull();
        assertThat(address.getId()).isEqualTo(addressId);
        assertThat(address.getAddress()).isEqualTo(addressLine);
    }
}