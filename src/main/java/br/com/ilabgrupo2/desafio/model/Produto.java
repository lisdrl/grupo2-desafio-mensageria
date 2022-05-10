package br.com.ilabgrupo2.desafio.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name = "products")
public class Produto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; 
	
	@Column(name = "prod_name")
	private String nome; 
	
	@Column(name = "description")
	private String descricao; 
	
	@Column(name = "quantity")
	private Integer quantidade; 
	
	@Column(name = "date")
	private String data;
	
	@Column(name = "price")
	private Double preco;

	@ManyToOne
	@JoinColumn(name = "order_id")
	@JsonIgnoreProperties("listaProdutos")
	private Pedidos idPedido;
	
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
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public Integer getQuantidade() {
		return quantidade;
	}
	
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	
	public String getData() {
		return data;
	}
	
	public void setData(String data) {
		this.data = data;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Pedidos getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(Pedidos idPedido) {
		this.idPedido = idPedido;
	}


	public Produto(String data, String nome, String descricao, Integer quantidade, Double preco) {
		super();
		this.data = data;
		this.nome = nome;
		this.descricao = descricao;
		this.quantidade = quantidade;
		this.preco = preco;
	}

	public Produto() {}

	@Override
	public String toString() {
		return "Produto [id=" + id + ", nome=" + nome + ", descricao=" + descricao + ", quantidade=" + quantidade
				+ ", data=" + data + ", price=" + preco + "]";
	}
}
