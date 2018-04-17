package br.com.fnr_tap.apresentacao;

import javax.swing.JOptionPane;

public class Mercadinho {
	static double dinheiroMercadinho;

	public static void main(String... args) {

		try {
			CaixaComum cm = new CaixaComum();
			CaixaComum cm2 = new CaixaComum();
			CaixaComum cm3 = new CaixaComum();
			CaixaPequenosItens cpi = new CaixaPequenosItens();
			CaixaPequenosItens cpi2 = new CaixaPequenosItens();
			CaixaPreferencial cp = new CaixaPreferencial();
			CaixaPreferencial cp2 = new CaixaPreferencial();

			cm.thread.join();
			cm2.thread.join();
			cm3.thread.join();
			cpi.thread.join();
			cpi2.thread.join();
			cp.thread.join();
			cp2.thread.join();
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}

		JOptionPane.showMessageDialog(null, "Dinheiro Mercadinho: R$" + Math.round(dinheiroMercadinho * 100) / 100d);

	}

	public static synchronized void coletarDinheiroCaixa(double dinheiroCliente) {
		dinheiroMercadinho += dinheiroCliente;
	}

}
