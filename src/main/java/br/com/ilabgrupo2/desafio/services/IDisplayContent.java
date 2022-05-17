package br.com.ilabgrupo2.desafio.services;

import java.util.List;

import br.com.ilabgrupo2.desafio.model.Produto;

public interface IDisplayContent {
	List<Produto> getListOfProducts();
	
	String convertProductListToString(List<Produto> pList);
	String convertProductListToString();
}
