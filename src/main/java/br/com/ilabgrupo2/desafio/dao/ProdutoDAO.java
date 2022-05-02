package br.com.ilabgrupo2.desafio.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ilabgrupo2.desafio.models.Produto;

public interface ProdutoDAO extends JpaRepository<Produto, Integer>{

}