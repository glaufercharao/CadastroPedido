package br.com.cadastro.entities;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.cadastro.enuns.TipoCadastro;

@Entity
@Table(name="TB_PRODUTO")
public class Produto {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "UUID_PRODUTO")
	private String uuid;
	
	private String nome;
	private String descricao;
	private double precoUnitario;
	@Enumerated(EnumType.STRING)
	private TipoCadastro tipoCadastro;
	
	public Produto() {
		this.uuid = UUID.randomUUID().toString();
	}
	
	
	public Produto(Long id, String nome, String descricao, double precoUnitario, TipoCadastro tipoCadastro) {
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.precoUnitario = precoUnitario;
		this.tipoCadastro = tipoCadastro;
		this.uuid = UUID.randomUUID().toString();
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getUuid() {
		return uuid;
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

	public double getPrecoUnitario() {
		return precoUnitario;
	}

	public void setPrecoUnitario(double precoUnitario) {
		this.precoUnitario = precoUnitario;
	}

	public TipoCadastro getTipoCadastro() {
		return tipoCadastro;
	}

	public void setTipoCadastro(TipoCadastro tipoCadastro) {
		this.tipoCadastro = tipoCadastro;
	}	
}
