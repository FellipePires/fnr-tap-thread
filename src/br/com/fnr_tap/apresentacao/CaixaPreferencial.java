package br.com.fnr_tap.apresentacao;

import javax.swing.JFrame;

public class CaixaPreferencial implements Runnable{

	private JFrame frame;

	public CaixaPreferencial() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void run() {
		
	}
}