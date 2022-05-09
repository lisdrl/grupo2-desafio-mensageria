package br.com.ilabgrupo2.desafio.servicies;

import java.util.List;

import br.com.ilabgrupo2.desafio.model.Produto;

public interface ILoadDataService {

	List<Produto> findAllProducts();
}
