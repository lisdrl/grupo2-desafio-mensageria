package br.com.ilabgrupo2.desafio.dto;

import java.util.List;

import br.com.ilabgrupo2.desafio.model.Cliente;
import br.com.ilabgrupo2.desafio.model.Produto;

public class CreateOrderDTO {

    private Double valorTotal;
    private Cliente idCliente;
    private List<Produto> listaProdutos;

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

    
}
