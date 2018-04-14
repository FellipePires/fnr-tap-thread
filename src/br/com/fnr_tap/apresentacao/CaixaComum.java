package br.com.fnr_tap.apresentacao;

import javax.swing.JFrame;

public class CaixaComum implements Runnable{

	private JFrame frame;

	public CaixaComum() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void run() {
		
	}
}