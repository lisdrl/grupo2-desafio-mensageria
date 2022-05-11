package br.com.ilabgrupo2.desafio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ilabgrupo2.desafio.model.Cliente;

public interface ClientDAO extends JpaRepository<Cliente, Long> {}
