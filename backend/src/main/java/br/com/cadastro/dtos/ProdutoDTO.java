package br.com.cadastro.dtos;

import java.io.Serializable;

import br.com.cadastro.enuns.TipoCadastro;

public class ProdutoDTO implements Serializable {
    private static final long serialVersionUID=1L;
    
    private String uuid;
	private String nome;
	private String descricao;
	private double precoUnitario;
	private TipoCadastro tipoCadastro;

	
	public ProdutoDTO() {
		
	}
	
	public ProdutoDTO(String uuid, String nome, String descricao, double precoUnitario, TipoCadastro tipoCadastro) {
		this.uuid = uuid;
		this.nome = nome;
		this.descricao = descricao;
		this.precoUnitario = precoUnitario;
		this.tipoCadastro = tipoCadastro;
	}
	
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
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
