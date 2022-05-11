package br.com.ilabgrupo2.desafio.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "client")
public class Clientes {

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "client_name")
    private String nome;

    @Column(name = "client_phone")
    private String telefone;

    /*@OneToMany(mappedBy = "idCliente")
	@JsonIgnoreProperties("idCliente")
	private List<Pedidos> listaPedidos;
*/
    public Clientes() {}
    
    public Clientes(Long id, String nome, String telefone) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
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

   /*public List<Pedidos> getListaPedidos() {
        return listaPedidos;
    }

    public void setListaPedidos(List<Pedidos> listaPedidos) {
        this.listaPedidos = listaPedidos;
    }
*/
    @Override
    public String toString() {
        return "Clientes [id=" + id + ", listaPedidos=" + ", nome=" + nome + ", telefone=" + telefone
                + "]";
    }

    
}