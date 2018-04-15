package br.com.fnr_tap.apresentacao;

public class Mercadinho {
	public static double dinheiroMercadinho = 500000.90; //Recurso compartilhado

	public static void main(String[] args) {
		
		
//		Caixa caixaComum = new Caixa();
//		Caixa caixaPreferencial = new Caixa();
//		Caixa caixaPequenosItens = new Caixa();
		
		CaixaPreferencial cp = new CaixaPreferencial();
					
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