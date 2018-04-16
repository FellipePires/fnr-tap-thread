package br.com.fnr_tap.entidades;

import java.util.ArrayList;
import java.util.Random;

public class Caixa {
	private int codigo;
	private ArrayList<Cliente> clientes;
	private double saldoCaixa;
//	private boolean isCaixaComum;
//	private boolean isCaixaPequenosItens;
//	private boolean isCaixaPreferencial;

	public int getCodigo() {	return codigo;	}
	public void setCodigo(int codigo) {	this.codigo = codigo;	}
	public ArrayList<Cliente> getClientes() {		return clientes;	}
	public void setClientes(ArrayList<Cliente> clientes) {		this.clientes = clientes;	}
	public double getSaldoCaixa() {	return saldoCaixa;	}
	public void setSaldoCaixa(double saldoCaixa) {	this.saldoCaixa = saldoCaixa;	}
//	public boolean isCaixaComum() {	return isCaixaComum;}
//	public void setCaixaComum(boolean isCaixaComum) {	this.isCaixaComum = isCaixaComum;	}
//	public boolean isCaixaPequenosItens() {		return isCaixaPequenosItens;	}
//	public void setCaixaPequenosItens(boolean isCaixaPequenosItens) {		this.isCaixaPequenosItens = isCaixaPequenosItens;	}
//	public boolean isCaixaPreferencial() {		return isCaixaPreferencial;	}
//	public void setCaixaPreferencial(boolean isCaixaPreferencial) {		this.isCaixaPreferencial = isCaixaPreferencial;	}
	
	public Caixa() {}

	public Caixa(int codigo) {//boolean isCaixaComum, boolean isCaixaPequenosItens, boolean isCaixaPreferencial
		this.codigo = codigo;
		this.clientes = new ArrayList<>();
		this.saldoCaixa = gerarClientes();
//		this.isCaixaComum = isCaixaComum;
//		this.isCaixaPequenosItens = isCaixaPequenosItens;
//		this.isCaixaPreferencial = isCaixaPreferencial;
	}
	
	public double gerarClientes() {
		Random random = new Random();		

		for(int i = 0; i < (random.nextInt(5) + 1); i++) {
			int codigo = random.nextInt(20);
			String nome = "Cliente " + (i+1);
			boolean isPreferencial = random.nextBoolean();
			boolean isPequenosItens = random.nextBoolean();
			
			Cliente cliente = new Cliente(codigo, nome, isPreferencial, isPequenosItens);
			
			this.saldoCaixa += cliente.getTotal(); 
			
			clientes.add(cliente);
		}
		
		this.saldoCaixa = Math.round(this.saldoCaixa * 100) / 100d;
		return this.saldoCaixa;
	}
		
}