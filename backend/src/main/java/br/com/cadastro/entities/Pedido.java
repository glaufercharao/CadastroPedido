package br.com.cadastro.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import br.com.cadastro.enuns.StatusPedido;

@Entity
@Table(name = "TB_PEDIDO")
public class Pedido {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "UUID_PEDIDO")
	private String uuid;
	
	@Enumerated(EnumType.STRING)
	private StatusPedido status;
    
	@ManyToMany
    @JoinTable( name="tb_pedido_item_pedido",
                joinColumns = @JoinColumn(name = "item_pedido_uuid") ,
                inverseJoinColumns = @JoinColumn(name = "pedido_uuid")
    )
	private List<ItemPedido> itensPedido = new ArrayList<>();
	
	public Pedido() {
		this.uuid = UUID.randomUUID().toString();
	}
	
	

	public Pedido(Long id, List<ItemPedido> itensPedido) {
		this.id = id;
		this.itensPedido = itensPedido;
		this.uuid = UUID.randomUUID().toString();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<ItemPedido> getProdutos() {
		return itensPedido;
	}

	public void setProdutos(List<ItemPedido> itensPedido) {
		this.itensPedido = itensPedido;
	}

	public String getUuid() {
		return uuid;
	}
	
	

}
