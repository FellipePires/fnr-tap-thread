package br.com.fnr_tap.entidades;

import java.util.ArrayList;
import java.util.Random;

public class Caixa {
	private int codigo;
	private ArrayList<Cliente> clientes;
	private double saldoCaixa;

	public int getCodigo() {	return codigo;	}
	public void setCodigo(int codigo) {	this.codigo = codigo;	}
	public ArrayList<Cliente> getClientes() {		return clientes;	}
	public void setClientes(ArrayList<Cliente> clientes) {		this.clientes = clientes;	}
	public double getSaldoCaixa() {	return saldoCaixa;	}
	public void setSaldoCaixa(double saldoCaixa) {	this.saldoCaixa = saldoCaixa;	}
	
	public Caixa() {}

	public Caixa(int codigo) {
		this.codigo = codigo;
		this.clientes = new ArrayList<>();
		this.saldoCaixa = gerarClientes();
	}
	
	public double gerarClientes() {
		Random random = new Random();		

		for(int i = 0; i < (random.nextInt(10) + 1); i++) {
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
