package br.com.fnr_tap.apresentacao;

public class Mercadinho {
	public static void main(String[] args) {

		CaixaComum cm = new CaixaComum();
		new Thread(cm).start();
		
		CaixaComum cm2 = new CaixaComum();
		new Thread(cm2).start();
		
	}
}
