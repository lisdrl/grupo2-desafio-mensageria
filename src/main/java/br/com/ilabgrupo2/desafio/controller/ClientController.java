package br.com.ilabgrupo2.desafio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.ilabgrupo2.desafio.dto.CreateClientDTO;
import br.com.ilabgrupo2.desafio.dto.ResponseClientDTO;
import br.com.ilabgrupo2.desafio.servicies.IClientService;

@Controller
@RequestMapping("clientes")
public class ClientController {

	@Autowired
	private IClientService clientService;
	
	 @GetMapping
   public String viewClientePage() {
     return "clientes";
   }
	
	@PostMapping
	public ResponseClientDTO createClient (@RequestBody CreateClientDTO createClient) {
		return clientService.createCliente(createClient);
	}
}
