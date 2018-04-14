package br.com.fnr_tap.entidades;

public class Funcionario {
	private String nome;
	private int codigo;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	public Funcionario() {
	}

	public Funcionario(String nome, int codigo) {
		this.nome = nome;
		this.codigo = codigo;
	}
}