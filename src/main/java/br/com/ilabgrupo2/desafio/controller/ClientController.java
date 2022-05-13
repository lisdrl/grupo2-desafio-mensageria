package br.com.ilabgrupo2.desafio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
   public String clientForm(Model model) {
		 model.addAttribute("cliente", new CreateClientDTO());
     return "client/client_register";
   }
	 
	 @GetMapping("/update")
	 public String updateClient(Model model) {
		 model.addAttribute("cliente", new CreateClientDTO());
		 return "client/client_update";
	 }
	
	@PostMapping
	public String createClient(@ModelAttribute CreateClientDTO cliente, Model model) {

		ResponseClientDTO regClient = clientService.createCliente(cliente);
		
		if (regClient == null) {
			model.addAttribute("error", "Erro ao cadastrar cliente!");
			return "client/client_error";
		}
		
		model.addAttribute("cliente", regClient);
		return "client/client_result";
	}
	
	@PostMapping("/update")
	public String updateClient(@ModelAttribute CreateClientDTO cliente, Model model) {
		System.out.println(cliente);
		ResponseClientDTO updatedClient = clientService.updateClient(cliente);
		
		if (updatedClient == null) {
			model.addAttribute("error", "Erro ao atualizar o cliente!");
			return "client/client_error";
		}
		
		model.addAttribute("cliente", updatedClient);
		return "client/client_result";
	}
}
