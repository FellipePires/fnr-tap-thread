package br.com.fnr_tap.entidades;

import java.util.*;

public class Cliente {
	private int codigo;
	private ArrayList<Produto> produtos;
	private String nome;
	private boolean isPreferencial;
	private double total = 0;

	public int getCodigo() {		return codigo;	}
	public void setCodigo(int codigo) {		this.codigo = codigo;	}
	public ArrayList<Produto> getProdutos() {		return produtos;	}
	public void setProdutos(ArrayList<Produto> produtos) {		this.produtos = produtos;	}
	public String getNome() {		return nome;	}
	public void setNome(String nome) {		this.nome = nome;	}
	public boolean isPreferencial() {		return isPreferencial;	}
	public void setPreferencial(boolean isPreferencial) {		this.isPreferencial = isPreferencial;	}
	public double getTotal() { return total;	}
	public void setTotal(int total) {	this.total = total; 	}

	public Cliente() {	}

	public Cliente(int codigo, String nome, boolean isPreferencial) {
		this.codigo = codigo;
		this.nome = nome;
		this.isPreferencial = isPreferencial;
		this.produtos = new ArrayList<>();
		this.total = gerarProdutos();
	}

	public double gerarProdutos() {
		Random random = new Random();		

		for(int i = 0; i < (random.nextInt(25) + 1); i++) {
			int codigo = random.nextInt(1000);
			String descricao = "Produto " + (i+1);
			double preco = random.nextDouble() * 100;
			preco = Math.round(preco * 100) / 100d;
			this.total += preco;
			
			Produto produto = new Produto(codigo, descricao, preco);
			this.produtos.add(produto);
		}
		
		return this.total;
	}
	
}
