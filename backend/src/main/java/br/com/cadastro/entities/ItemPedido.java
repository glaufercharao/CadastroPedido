package br.com.cadastro.entities;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
@Entity
@Table(name = "TB_ITEM_PEDIDO")
public class ItemPedido {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "UUID_ITEM_PEDIDO")
	private String uuid;
	
	@ManyToMany(cascade = CascadeType.ALL)
    @JoinTable( name="tb_produto_item_pedido",
                joinColumns = @JoinColumn(name = "produto_uuid") ,
                inverseJoinColumns = @JoinColumn(name = "item_pedido_uuid")
    )
	private Set<Produto> produtos = new HashSet<>();
	
	@ManyToMany(mappedBy = "itensPedido")
	private Set<Pedido> pedidos = new HashSet<>();
	
	public ItemPedido() {
		this.uuid = UUID.randomUUID().toString();
	}
	
	public ItemPedido(Long id, Set<Produto> produtos, Set<Pedido> pedidos) {
		super();
		this.id = id;
		this.produtos = produtos;
		this.pedidos = pedidos;
		this.uuid = UUID.randomUUID().toString();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Set<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(Set<Produto> produtos) {
		this.produtos = produtos;
	}
	
	
	public Set<Pedido> getItensPedido() {
		return pedidos;
	}

	public void setItensPedido(Set<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	public String getUuid() {
		return uuid;
	}
	
}
