package com.client.client.database;

import Entidade.Contato;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioContato extends JpaRepository<Contato, Long> {

}
