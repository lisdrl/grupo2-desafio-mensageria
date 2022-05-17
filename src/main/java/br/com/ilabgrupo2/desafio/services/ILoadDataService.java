package br.com.ilabgrupo2.desafio.services;

import java.util.List;

import br.com.ilabgrupo2.desafio.model.Produto;

public interface ILoadDataService {

	List<Produto> findAllProducts();
}
