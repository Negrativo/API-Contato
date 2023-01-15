package com.client.client;

import Entidade.Contato;
import com.client.client.database.RepositorioContato;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = ClientApplication.class)
class ClientApplicationTests {

    private RepositorioContato repositorioContato;

    @Before
    public void contextLoads() {
        Contato contatoTest = new Contato(123L, "Contato Teste", "(00) 1324-5678", "teste@teste.com", "https://urlAvatar.com.br");
        repositorioContato.save(contatoTest);
    }

    @Test
    public void buscarUsuarioTest() {

    }

}
