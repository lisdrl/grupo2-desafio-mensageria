package br.com.ilabgrupo2.desafio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.ilabgrupo2.desafio.dto.ResponseOrderDTO;
import br.com.ilabgrupo2.desafio.model.Pedido;

public interface OrderRepository extends JpaRepository<Pedido, Long>{
    
    @Query ("SELECT pedido FROM Pedido pedido JOIN Cliente cliente ON cliente.id = pedido.idCliente.id WHERE pedido.id = :id")
	public ResponseOrderDTO findByIdCliente(@Param("id") Long id);

	@Query ("SELECT pedido FROM Pedido pedido JOIN Cliente cliente ON cliente.id = pedido.idCliente.id") 
	public List<ResponseOrderDTO> findClientAll();
}

