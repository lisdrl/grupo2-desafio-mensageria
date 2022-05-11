package br.com.ilabgrupo2.desafio.servicies;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.ilabgrupo2.desafio.dto.CreateClientDTO;
import br.com.ilabgrupo2.desafio.dto.ResponseClientDTO;
import br.com.ilabgrupo2.desafio.model.Cliente;
import br.com.ilabgrupo2.desafio.repository.ClientRepository;

public class ClientServiceImp implements IClientService {

	@Autowired
	private ClientRepository clientRepository;
	
	@Override
	public ResponseClientDTO createCliente(CreateClientDTO newClient) {
		try {			
			Cliente cliente = new Cliente();
			cliente.setNome(newClient.getNome());
			cliente.setTelefone(newClient.getTelefone());
			
			cliente = clientRepository.save(cliente);
			
			ResponseClientDTO clientResponse = new ResponseClientDTO(cliente);
			return clientResponse;
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	@Override
	public ResponseClientDTO getClientById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ResponseClientDTO> getAllClient() {
		// TODO Auto-generated method stub
		return null;
	}
}
