package br.com.ilabgrupo2.desafio.dao;


import br.com.ilabgrupo2.desafio.model.Clientes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioDAO extends JpaRepository<Clientes, Integer> { 

}
