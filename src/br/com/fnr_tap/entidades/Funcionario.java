package br.com.fnr_tap.entidades;

public class Funcionario {
	private int codigo = 1;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	public Funcionario() {
	}

	public Funcionario(int codigo) {
		this.codigo = codigo;
	}
}