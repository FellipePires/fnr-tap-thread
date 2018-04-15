package br.com.fnr_tap.entidades;

import java.util.ArrayList;
import java.util.Random;

import br.com.fnr_tap.apresentacao.Mercadinho;

public class Caixa {
	private int codigo;
	private ArrayList<Cliente> clientes;
	private double saldoCaixa = Mercadinho.pegarDinheiro(2000);

	public int getCodigo() {	return codigo;	}
	public void setCodigo(int codigo) {	this.codigo = codigo;	}
	public ArrayList<Cliente> getClientes() {		return clientes;	}
	public void setClientes(ArrayList<Cliente> clientes) {		this.clientes = clientes;	}
	public double getSaldoCaixa() {	return saldoCaixa;	}
	public void setSaldoCaixa(double saldoCaixa) {	this.saldoCaixa = saldoCaixa;	}
	
	public Caixa() {	}

	public Caixa(int codigo) {
		this.codigo = codigo;
		this.clientes = new ArrayList<>();
		this.saldoCaixa = gerarClientes();
	}
	
	public double gerarClientes() {
		Random random = new Random();		

		for(int i = 0; i < (random.nextInt(20) + 1); i++) {
			int codigo = random.nextInt(20);
			String nome = "Cliente " + (i+1);
			boolean isPreferencial = random.nextBoolean();
			
			Cliente cliente = new Cliente(codigo, nome, isPreferencial);
			
			if(this.saldoCaixa - cliente.getTotal() < 0) {
				Mercadinho.pegarDinheiro(2000);
			}else {
				this.saldoCaixa -= cliente.getTotal(); 
			}
			
			clientes.add(cliente);
		}
		
		return this.saldoCaixa;
	}

}
