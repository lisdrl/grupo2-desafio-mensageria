package br.com.ilabgrupo2.desafio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.ilabgrupo2.desafio.dto.ResponseClientDTO;
import br.com.ilabgrupo2.desafio.model.Cliente;

public interface ClientRepository extends JpaRepository<Cliente, Long> {
//	ResponseClientDTO findByTelefone(String telefone);
	
	@Query (" SELECT new "
			+ "br.com.ilabgrupo2.desafio.dto.ResponseClientDTO(cliente) "
			+ "FROM Cliente as cliente "
			+ "WHERE cliente.telefone = :telefone")
	public ResponseClientDTO findByTelefone(@Param("telefone") String telefone);
}
