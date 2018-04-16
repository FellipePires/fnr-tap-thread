package br.com.fnr_tap.apresentacao;

public class Mercadinho {
	public static void main(String[] args) {

		CaixaComum cm = new CaixaComum();
		new Thread(cm).start();
		
		CaixaPreferencial cp = new CaixaPreferencial();
		new Thread(cp).start();
		
		CaixaPequenosItens cpi = new CaixaPequenosItens();
		new Thread(cpi).start();
		
	}
}