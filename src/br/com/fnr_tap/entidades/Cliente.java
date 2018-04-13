package br.com.fnr_tap.entidades;

import java.util.ArrayList;

public class Cliente {
	private int codigo;
	private ArrayList<Produto> produtos;
	private String nome;
	private boolean isPreferencial;
	
	public int getCodigo() {	return codigo;	}
	public void setCodigo(int codigo) {		this.codigo = codigo;		}
	public ArrayList<Produto> getProdutos() {		return produtos;		}
	public void setProdutos(ArrayList<Produto> produtos) {	this.produtos = produtos;	}
	public String getNome() {	return nome;	}
	public void setNome(String nome) {	this.nome = nome;		}
	public boolean isPreferencial() {	return isPreferencial;		}
	public void setPreferencial(boolean isPreferencial) {	this.isPreferencial = isPreferencial;	}

	public Cliente() {	}

	public Cliente(int codigo, ArrayList<Produto> produtos, String nome, boolean isPreferencial) {
		this.codigo = codigo;
		this.produtos = produtos;
		this.nome = nome;
		this.isPreferencial = isPreferencial;
	}

}
