package com.client.client.database;

import org.springframework.data.jpa.repository.JpaRepository;

import Entidade.Contato;


public interface RepositorioContato extends JpaRepository <Contato,Long> {
    
}
