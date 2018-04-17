package br.com.fnr_tap.apresentacao;

import javax.swing.JOptionPane;

public class Mercadinho {
	static double dinheiroMercadinho;

	public static void main(String... args) {
		CaixaComum cm = new CaixaComum();
		Thread caixa01 = new Thread(cm);

		CaixaPreferencial cp = new CaixaPreferencial();
		Thread caixa02 = new Thread(cp);

		CaixaPequenosItens cpi = new CaixaPequenosItens();
		Thread caixa03 = new Thread(cpi);

		caixa01.start();
		caixa02.start();
		caixa03.start();

		try {
			caixa01.join();
			caixa02.join();
			caixa03.join();
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}

		JOptionPane.showMessageDialog(null, "Dinheiro Mercadinho: R$" + dinheiroMercadinho);

	}

	public static synchronized void coletarDinheiroCaixa(double dinheiroCliente) {
		dinheiroMercadinho += dinheiroCliente;
	}

}
