package com.client.client;

import Entidade.Contato;
import com.client.client.database.RepositorioContato;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/contato")
public class ContatoRest {

    private static final String CONTATO_NAO_ENCONTRADO = "CONTATO NÃO ENCONTRADO.";

    @Autowired
    private RepositorioContato repositorio;

    @GetMapping
    public List<Contato> listar() {
        return repositorio.findAll();
    }

    @GetMapping("/{id}")
    public Contato buscarPorId(@PathVariable("id") Long id) {
        Optional<Contato> contatoOptional = repositorio.findById(id);
        return contatoOptional.orElseThrow(() -> {
            throw new EntityNotFoundException(CONTATO_NAO_ENCONTRADO);
        });
    }

    @PostMapping
    public void salvar(@RequestBody Contato contato) {
        repositorio.save(contato);
    }

    @PutMapping
    public void alterar(@RequestBody Contato contato) {
        Optional<Contato> contatoOptional = repositorio.findById(contato.getId());
        contatoOptional.ifPresentOrElse(
                contatoPresent -> repositorio.save(contatoPresent),
                () -> {
                    throw new EntityNotFoundException(CONTATO_NAO_ENCONTRADO);
                });
    }

    @DeleteMapping
    public void excluir(Contato contato) {
        Optional<Contato> contatoOptional = repositorio.findById(contato.getId());
        contatoOptional.ifPresentOrElse(
                contatoPresent -> repositorio.delete(contatoPresent),
                () -> {
                    throw new EntityNotFoundException(CONTATO_NAO_ENCONTRADO);
                });
    }

}
