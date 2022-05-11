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
@Table(name = "pedidos")
public class Pedidos {
    
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "amount")
    private Double valorTotal;

    @ManyToOne
	@JoinColumn(name = "client_id")
	@JsonIgnoreProperties("listaPedidos")
    private Clientes idCliente;

    @OneToMany(mappedBy = "idPedido")
	@JsonIgnoreProperties("idPedido")
    private List<Produto> listaProdutos;

    public Pedidos() {}

    public Pedidos(Long id, Double valorTotal, Clientes idCliente) {
        this.id = id;
        this.valorTotal = valorTotal;
        this.idCliente = idCliente;
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

    public Clientes getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Clientes idCliente) {
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
        return "Pedidos [id=" + id + ", idCliente=" + idCliente + ", listaProdutos=" + listaProdutos + ", valorTotal="
                + valorTotal + "]";
    }

    
    
}

