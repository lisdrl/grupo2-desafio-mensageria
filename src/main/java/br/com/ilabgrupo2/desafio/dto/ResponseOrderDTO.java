package br.com.ilabgrupo2.desafio.dto;

import java.util.List;

import br.com.ilabgrupo2.desafio.model.Cliente;
import br.com.ilabgrupo2.desafio.model.Pedido;
import br.com.ilabgrupo2.desafio.model.Produto;

public class ResponseOrderDTO {
   
    private Long id;
    private Double valorTotal;
    private Cliente idCliente;
    private List<Produto> listaProdutos;
    
    public ResponseOrderDTO(Pedido pedido) {
      this.id = pedido.getId();
      this.valorTotal = pedido.getValorTotal();
      this.idCliente = pedido.getIdCliente();
      this.listaProdutos = pedido.getListaProdutos();
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
}
