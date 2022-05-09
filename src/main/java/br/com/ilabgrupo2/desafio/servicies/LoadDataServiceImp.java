package br.com.ilabgrupo2.desafio.servicies;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ilabgrupo2.desafio.model.Produto;
import br.com.ilabgrupo2.desafio.repository.LoadDataDAO;

@Service
public class LoadDataServiceImp implements ILoadDataService {

	@Autowired
	private LoadDataDAO loadData;

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
