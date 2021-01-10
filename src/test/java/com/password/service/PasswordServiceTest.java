package com.password.service;

import com.password.service.impl.PasswordServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class PasswordServiceTest {

    private PasswordService service;

    @Before
    public void setUp(){
        service = new PasswordServiceImpl();
    }

    @Test
    public void aoMenosUmDigitoRetornandoErro() throws Exception {

        String teste = "";
        boolean responde = service.passwordValidation(teste);
        assertThat(responde).isFalse();

    }

    @Test
    public void aoMenosUmaLetraMinusculaRetornaErro() throws Exception {

        String teste = "ABCDEFGHIJ@";
        boolean response = service.passwordValidation(teste);
        assertThat(response).isFalse();

    }

    @Test
    public void aoMenosUmaLetraMaisculaRetornaErro() throws Exception {

        String teste = "abcdefghij@";
        boolean response = service.passwordValidation(teste);
        assertThat(response).isFalse();
    }

    @Test
    public void aoMenosUmCaractereEspecialRetornaErro() throws Exception {

        String teste = "abcdefghij";
        boolean response = service.passwordValidation(teste);
        assertThat(response).isFalse();
    }

    @Test
    public void naoPossuirCaractereRepetido() throws Exception {

        String teste = "abcdefghijj";
        boolean response = service.passwordValidation(teste);
        assertThat(response).isFalse();
    }

    @Test
    public void deveRetornarTrue() throws Exception {

        String teste = "AbTp9!fok";
        boolean response = service.passwordValidation(teste);
        assertThat(response).isTrue();
    }
}
