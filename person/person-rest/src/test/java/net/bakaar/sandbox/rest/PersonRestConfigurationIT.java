package net.bakaar.sandbox.rest;

import net.bakaar.sandbox.domain.number.BusinessNumberRepository;
import net.bakaar.sandbox.domain.person.PersonApplicationService;
import net.bakaar.sandbox.rest.controller.PersonRestController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = PersonRestConfiguration.class)
public class PersonRestConfigurationIT {

    @Autowired
    private PersonRestController controller;

    @MockBean
    private BusinessNumberRepository businessNumberRepository;

    @MockBean
    private PersonApplicationService service;

    @Test
    public void context_should_be_complete() {
        assertThat(controller).isNotNull();
    }
}