package br.com.ilabgrupo2.desafio.dto;

import br.com.ilabgrupo2.desafio.model.Cliente;

public class ResponseClientDTO {

	private Long id;
	private String nome;
	private String telefone;
	
	public ResponseClientDTO(Cliente cliente) {
		super();
		this.id = cliente.getId();
		this.nome = cliente.getNome();
		this.telefone = cliente.getTelefone();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
}
