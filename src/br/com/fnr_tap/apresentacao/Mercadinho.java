package br.com.fnr_tap.apresentacao;

import javax.swing.JOptionPane;

public class Mercadinho {
	static double dinheiroMercadinho;

	public static void main(String... args) {
		CaixaComum cm = new CaixaComum();
		Thread caixa01 = new Thread(cm);

		CaixaComum cm2 = new CaixaComum();
		Thread caixa02 = new Thread(cm2);

		CaixaComum cm3 = new CaixaComum();
		Thread caixa03 = new Thread(cm3);
		
		CaixaPequenosItens cpi = new CaixaPequenosItens();
		Thread caixa04 = new Thread(cpi);

		CaixaPequenosItens cpi2 = new CaixaPequenosItens();
		Thread caixa05 = new Thread(cpi2);
		
		CaixaPreferencial cp = new CaixaPreferencial();
		Thread caixa06 = new Thread(cp);

		CaixaPreferencial cp2 = new CaixaPreferencial();
		Thread caixa07 = new Thread(cp2);

		caixa01.start();
		caixa02.start();
		caixa03.start();
		caixa04.start();
		caixa05.start();
		caixa06.start();
		caixa07.start();

		try {
			caixa01.join();
			caixa02.join();
			caixa03.join();
			caixa04.join();
			caixa05.join();
			caixa06.join();
			caixa07.join();
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}

		JOptionPane.showMessageDialog(null, "Dinheiro Mercadinho: R$" + Math.round(dinheiroMercadinho * 100) / 100d);

	}

	public static synchronized void coletarDinheiroCaixa(double dinheiroCliente) {
		dinheiroMercadinho += dinheiroCliente;
	}

}
