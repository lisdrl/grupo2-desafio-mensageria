package br.com.ilabgrupo2.desafio.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ilabgrupo2.desafio.model.Produto;
import br.com.ilabgrupo2.desafio.repository.LoadDataRepository;

@Service
public class LoadDataServiceImp implements ILoadDataService {

	@Autowired
	private LoadDataRepository loadData;

	@Override
	public List<Produto> findAllProducts() {
		try {
			return loadData.findAll();
		} catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
}
