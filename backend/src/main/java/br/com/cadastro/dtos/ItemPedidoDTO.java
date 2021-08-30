package br.com.cadastro.dtos;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class ItemPedidoDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String uuid;
	private Set<ProdutoDTO> produtos = new HashSet<>();;
	private Set<PedidoDTO> pedidos = new HashSet<>();
	
	public ItemPedidoDTO() {
		
	}

	public ItemPedidoDTO(Long id, String uuid, Set<ProdutoDTO> produtos) {
		this.id = id;
		this.uuid = uuid;
		this.produtos = produtos;
	}

	public Set<ProdutoDTO> getProdutos() {
		return produtos;
	}

	public void setProdutos(Set<ProdutoDTO> produtos) {
		this.produtos = produtos;
	}
	

	public Set<PedidoDTO> getPedidos() {
		return pedidos;
	}

	public void setPedidos(Set<PedidoDTO> pedidos) {
		this.pedidos = pedidos;
	}

	public Long getId() {
		return id;
	}

	public String getUuid() {
		return uuid;
	}
			
}
