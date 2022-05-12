package br.com.ilabgrupo2.desafio.servicies;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.ilabgrupo2.desafio.dto.CreateClientDTO;
import br.com.ilabgrupo2.desafio.dto.ResponseClientDTO;
import br.com.ilabgrupo2.desafio.model.Cliente;
import br.com.ilabgrupo2.desafio.repository.ClientRepository;

@Component
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
		try {
			return new ResponseClientDTO(clientRepository.findById(id).get());			
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	@Override
	public List<ResponseClientDTO> getAllClient() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseClientDTO updateClient(CreateClientDTO update, Long id) {
		try {
			ResponseClientDTO cliente = getClientById(id);
			updateClientFields(update, cliente);
			return new ResponseClientDTO(clientRepository.save(new Cliente(cliente.getId(), cliente.getNome(), cliente.getTelefone())));
		} catch (Exception ex) {
			return null;
		}
	}

	@Override
	public void deleteClient(Long id) {
		// TODO Auto-generated method stub
		
	}
	
	private void updateClientFields(CreateClientDTO update, ResponseClientDTO cliente) {
		if(update.getNome() != null && !update.getNome().equals("")) {
			cliente.setNome(update.getNome());
		}
		
		if(update.getTelefone() != null && !update.getTelefone().equals("")) {
			cliente.setTelefone(update.getTelefone());
		}
	}
}
