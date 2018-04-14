package br.com.fnr_tap.entidades;

import java.util.*;

public class Produto {
	Random gerador = new Random();
	
	
	private int codigo;
	private String descricao;
	private double preco;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	public double gerarPreco(double preco) {
		preco = gerador.nextDouble() * 100;
		preco = Math.round(preco * 100) / 100d;
		return preco;
	}

	public Produto() {
	}

	public Produto(int codigo, String descricao, double preco) {
		this.codigo = codigo;
		this.descricao = descricao;
		this.preco = preco;
	}
}