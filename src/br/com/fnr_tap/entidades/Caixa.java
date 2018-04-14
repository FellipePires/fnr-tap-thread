package br.com.fnr_tap.entidades;

import java.util.*;

public class Caixa {

	private int codigo;
	private boolean isPreferencial;
	private boolean isPequenosItens;
	private boolean isComum;
	private ArrayList<Cliente> clientes;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public boolean isPreferencial() {
		return isPreferencial;
	}

	public void setPreferencial(boolean isPreferencial) {
		this.isPreferencial = isPreferencial;
	}

	public boolean isPequenosItens() {
		return isPequenosItens;
	}

	public void setPequenosItens(boolean isPequenosItens) {
		this.isPequenosItens = isPequenosItens;
	}

	public boolean isComum() {
		return isComum;
	}

	public void setComum(boolean isComum) {
		this.isComum = isComum;
	}

	public ArrayList<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(ArrayList<Cliente> clientes) {
		this.clientes = clientes;
	}

	public Caixa() {
	}

	public Caixa(int codigo, ArrayList<Cliente> clientes, boolean isPreferencial, boolean isPequenosItens,
			boolean isComum) {
		this.codigo = codigo;
		this.isPreferencial = isPreferencial;
		this.isPequenosItens = isPequenosItens;
		this.isComum = isComum;
		this.clientes = clientes;
	}

}
