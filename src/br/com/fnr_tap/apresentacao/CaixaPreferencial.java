package br.com.fnr_tap.apresentacao;

import javax.swing.JFrame;

public class CaixaPreferencial extends JFrame implements Runnable {
	private static final long serialVersionUID = 1L;

	public CaixaPreferencial() {
		exibirJanela();
	}

	@Override
	public void run() {
		
		
		
	}
	
	public void exibirJanela() {
		this.setSize(400, 400);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setResizable(false);
		this.setTitle("Caixa Preferencial");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
