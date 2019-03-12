package net.bakaar.sandbox.person.data.jpa.adapter;

import net.bakaar.sandbox.person.data.jpa.entity.PersonEntity;
import net.bakaar.sandbox.person.data.jpa.mapper.PartnerEntityDomainMapper;
import net.bakaar.sandbox.person.data.jpa.repository.PersonJpaRepository;
import net.bakaar.sandbox.person.domain.entity.Partner;
import net.bakaar.sandbox.shared.domain.vo.PNumber;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class PartnerRepositoryAdapterTest {

    private final PartnerEntityDomainMapper entityDomainMapper = mock(PartnerEntityDomainMapper.class);
    private final PersonJpaRepository repository = mock(PersonJpaRepository.class);
    private final PartnerRepositoryAdapter adapter = new PartnerRepositoryAdapter(repository, entityDomainMapper);
    private final PersonEntity mockedEntity = mock(PersonEntity.class);
    private final Partner input = mock(Partner.class);
    private final Partner returned = mock(Partner.class);

    @Test
    public void push_should_store_partner_in_db() {
        //Given
        given(entityDomainMapper.mapToEntity(input)).willReturn(mockedEntity);
        given(repository.save(any(PersonEntity.class))).willAnswer(invocation -> invocation.getArgument(0));
        given(entityDomainMapper.mapToDomain(mockedEntity)).willReturn(returned);
        //When
        Partner partner = adapter.putPartner(input);
        //Then
        verify(entityDomainMapper).mapToEntity(input);
        verify(repository).save(mockedEntity);
        verify(entityDomainMapper).mapToDomain(mockedEntity);
        assertThat(partner).isNotNull().isSameAs(returned);
    }

    @Test
    public void fetchPartnerById_should_read_partner_from_db() {
        //Given
        long id = 12345678L;
        PNumber pNumber = PNumber.of(id);
        given(repository.findByPNumber(id)).willReturn(mockedEntity);
        given(entityDomainMapper.mapToDomain(mockedEntity)).willReturn(returned);
        //When
        Partner partner = adapter.fetchPartnerById(pNumber);
        //Then
        assertThat(partner).isNotNull().isSameAs(returned);
        verify(repository).findByPNumber(id);
        verify(entityDomainMapper).mapToDomain(mockedEntity);


    }
}