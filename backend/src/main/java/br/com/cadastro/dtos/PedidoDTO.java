package br.com.cadastro.dtos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PedidoDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String uuid;
	private List<ItemPedidoDTO> itensPedido = new ArrayList<>();
	
	public PedidoDTO() {
		
	}

	public PedidoDTO(Long id, String uuid, List<ItemPedidoDTO> itensPedido) {
		this.id = id;
		this.uuid = uuid;
		this.itensPedido = itensPedido;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<ItemPedidoDTO> getItensPedido() {
		return itensPedido;
	}

	public void setItensPedido(List<ItemPedidoDTO> itensPedido) {
		this.itensPedido = itensPedido;
	}

	public String getUuid() {
		return uuid;
	}
	
	
	
}
