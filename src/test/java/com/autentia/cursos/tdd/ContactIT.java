package com.autentia.cursos.tdd;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/contactbook-context.xml"})
public class ContactIT {

    @Resource
    private Contact contact;

    @Test
    public void shouldHasCorrectName() {
        assertThat(contact.getName(), is(equalTo("Pepe")));
    }

    @Test
    public void shouldHasCorrectSurname() {
        assertThat(contact.getSurName(), is(equalTo("Ruiz")));
    }

}
