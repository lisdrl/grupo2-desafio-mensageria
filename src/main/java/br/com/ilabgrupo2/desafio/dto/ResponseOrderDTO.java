package br.com.ilabgrupo2.desafio.dto;

import java.util.List;

import br.com.ilabgrupo2.desafio.model.Clientes;
import br.com.ilabgrupo2.desafio.model.Pedidos;
import br.com.ilabgrupo2.desafio.model.Produto;

public class ResponseOrderDTO {
   
    private Long id;
    private Double valorTotal;
    private Clientes idCliente;
    private List<Produto> listaProdutos;

    
    public ResponseOrderDTO(Pedidos pedidos) {
        this.id = pedidos.getId();
        this.valorTotal = pedidos.getValorTotal();
        this.idCliente = pedidos.getIdCliente();
        this.listaProdutos = pedidos.getListaProdutos();
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

    
}
