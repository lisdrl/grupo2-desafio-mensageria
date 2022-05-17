package br.com.ilabgrupo2.desafio.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "orders")
public class Pedido {
    
  @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "amount")
  private Double valorTotal;

  @ManyToOne
	@JoinColumn(name = "client_id")
	@JsonIgnoreProperties("listaPedidos")
  private Cliente idCliente;

  @OneToMany(mappedBy = "idPedido")
  @JsonIgnoreProperties("idPedido")
  private List<Produto> listaProdutos;

  public Pedido() {}

  public Pedido(Long id, Double valorTotal, Cliente idCliente, List<Produto> listaProdutos) {
    this.id = id;
    this.valorTotal = valorTotal;
    this.idCliente = idCliente;
    this.listaProdutos = listaProdutos;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Double getValorTotal() {
    return valorTotal;
  }

  public void setValorTotal(Double valorTotal) {
    this.valorTotal = valorTotal;
  }

  public Cliente getIdCliente() {
    return idCliente;
  }

  public void setIdCliente(Cliente idCliente) {
    this.idCliente = idCliente;
  }
  
  public List<Produto> getListaProdutos() {
		return listaProdutos;
	}

	public void setListaProdutos(List<Produto> listaProdutos) {
		this.listaProdutos = listaProdutos;
	}


  @Override
  public String toString() {
    return "Pedido [id=" + id + ", listaProdutos=" + listaProdutos + ", valorTotal="
        + valorTotal + "]";
  }

	
}

