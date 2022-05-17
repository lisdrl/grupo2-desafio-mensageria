package br.com.ilabgrupo2.desafio.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.ilabgrupo2.desafio.model.Produto;

@Component
public class DisplayContentImp implements IDisplayContent {

	@Autowired
	private LoadDataServiceImp loadDataService;
	
	@Override
	public List<Produto> getListOfProducts() {
		return loadDataService.findAllProducts();
	}

	@Override
	public String convertProductListToString(List<Produto> pList) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String convertProductListToString() {
		List<Produto> pList = getListOfProducts();
		String entries = "";
		List<String> result = new ArrayList<>();
		
		entries = "<p>" + "Nome" + " | " + "descrição" + " | " + "qtd" + " | " + "preço" + "<p>";
    result.add(entries);
    
    for (Produto p : pList) {
    	String name = p.getNome();
    	String desc = p.getDescricao();
    	Integer qtd  = p.getQuantidade();
    	Double preco = p.getPreco();
    	
    	entries = "<p>" + name + " | " + desc + " | " + qtd + " | " + preco + "<p>";
    	result.add(entries);
    }
    
    return result.toString().replace("[", "").replace("]", "").replace(",", "");
	}
	
	

}
