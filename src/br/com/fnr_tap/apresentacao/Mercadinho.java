package br.com.fnr_tap.apresentacao;

public class Mercadinho {
	public static double dinheiroMercadinho = 5000000.90; //Recurso compartilhado

	public static void main(String[] args) {
		
		CaixaPreferencial cp = new CaixaPreferencial();
		CaixaComum cm = new CaixaComum();
		CaixaPequenosItens cpi = new CaixaPequenosItens();
		
		
	}

	/*
	 * Recurso compartilhado entre as Threads
	 */
	public static synchronized double pegarDinheiro(double valor) {
		if(dinheiroMercadinho - valor < 0) {
			return -1;
		}else {
			dinheiroMercadinho -= valor;
			return valor;
		}
	}

}