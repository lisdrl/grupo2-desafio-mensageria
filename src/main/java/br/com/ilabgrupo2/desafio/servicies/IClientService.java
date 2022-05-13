package br.com.ilabgrupo2.desafio.servicies;

import java.util.List;

import br.com.ilabgrupo2.desafio.dto.CreateClientDTO;
import br.com.ilabgrupo2.desafio.dto.ResponseClientDTO;

public interface IClientService {
	ResponseClientDTO createCliente(CreateClientDTO newClient);
	ResponseClientDTO getClientById(Long id);
	List<ResponseClientDTO> getAllClient();
	ResponseClientDTO updateClient(CreateClientDTO update);
	void deleteClient(Long id);
}
