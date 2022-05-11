package br.com.ilabgrupo2.desafio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ilabgrupo2.desafio.model.Produto;

@Repository
public interface LoadDataRepository extends JpaRepository<Produto, Long> {}
