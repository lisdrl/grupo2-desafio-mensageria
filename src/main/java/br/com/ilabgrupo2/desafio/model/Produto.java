package br.com.ilabgrupo2.desafio.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


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
	
	public Double getPrice() {
		return preco;
	}

	public void setPrice(Double preco) {
		this.preco = preco;
	}

	public Produto(String nome, String descricao, Integer quantidade) {
		this.nome = nome;
		this.descricao = descricao;
		this.quantidade = quantidade;
	}

	public Produto() {}

	@Override
	public String toString() {
		return "Produto [id=" + id + ", nome=" + nome + ", descricao=" + descricao + ", quantidade=" + quantidade
				+ ", data=" + data + ", price=" + preco + "]";
	}
}
