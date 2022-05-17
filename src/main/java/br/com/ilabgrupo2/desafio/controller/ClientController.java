package br.com.ilabgrupo2.desafio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.ilabgrupo2.desafio.dto.CreateClientDTO;
import br.com.ilabgrupo2.desafio.dto.ResponseClientDTO;
import br.com.ilabgrupo2.desafio.model.Cliente;
import br.com.ilabgrupo2.desafio.services.IClientService;

@Controller
@RequestMapping("clientes")
public class ClientController {

	@Autowired
	private IClientService clientService;
	
	@GetMapping
  public String listClients(Model model) {
      model.addAttribute("clientes", clientService.getAllClient());
      return "client/index";
  }
	
	@GetMapping("/delete")
  public String delteClient(Model model) {
      model.addAttribute("cliente", new Cliente());
      return "client/client_delete";
  }
	
	@GetMapping("/register")
  public String createClient(Model model) {
		model.addAttribute("cliente", new CreateClientDTO());
    return "client/client_register";
  }
	
	@GetMapping("/update")
	public String updateClient(Model model) {
	 model.addAttribute("cliente", new CreateClientDTO());
	 return "client/client_update";
	}
	
	@PostMapping("/register")
	public String createClient(@ModelAttribute CreateClientDTO cliente, Model model) {

		ResponseClientDTO regClient = clientService.createCliente(cliente);
		
		if (regClient == null) {
			model.addAttribute("error", "Erro ao cadastrar cliente!");
			return "client/client_error";
		}
		
		// buscar todos os clientes e passar nesse parametro t-t no lugar de (regClient);
		model.addAttribute("clientes", clientService.getAllClient());
		return "client/index";
	}
	
	@PostMapping("/update")
	public String updateClient(@ModelAttribute CreateClientDTO cliente, Model model) {
		ResponseClientDTO updatedClient = clientService.updateClient(cliente);
		
		if (updatedClient == null) {
			model.addAttribute("error", "Erro ao atualizar o cliente!");
			return "client/client_error";
		}
		
		model.addAttribute("cliente", updatedClient);
		return "client/client_result";
	}
	
	@PostMapping("/delete")
	public String deleteClient(@RequestParam("tel") String telefone) {
		System.out.println(telefone);
		clientService.deleteClient(telefone);
		
		return "client/client_delete";
	}
}
