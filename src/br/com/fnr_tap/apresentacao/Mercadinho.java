package br.com.fnr_tap.apresentacao;

import java.awt.GridLayout;
import java.util.Random;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import br.com.fnr_tap.entidades.Caixa;
import br.com.fnr_tap.entidades.Cliente;
import br.com.fnr_tap.entidades.Produto;

public class Mercadinho extends JFrame implements Runnable {
	private static final long serialVersionUID = 1L;
	private JTextField textFieldCodCaixa;
	private JTextField textFieldNomeCliente;
	private JTextField textField_2;
	private JProgressBar progressBarCaixa01;
	private JProgressBar progressBarCxComum;
	private JProgressBar progressBarCxPreferencial;
	private JTextArea textAreaProdutos;

	public static void main(String[] args) {
		Mercadinho m = new Mercadinho();
		new Thread(m).start();
	}

	@Override
	public void run() {
		try {
			int codigoCaixa = new Random().nextInt(2000);
			Caixa caixa = new Caixa(codigoCaixa);
			textFieldCodCaixa.setText(String.valueOf(caixa.getCodigo()));
			
			for (Cliente cAtual : caixa.getClientes()) {
				textFieldNomeCliente.setText(cAtual.getNome());
//				System.out.println("CAIXA " + c.getCodigo() + " \t" + cAtual.getCodigo() + "\t" + cAtual.getNome()
//						+ "\t" + cAtual.getTotal() + "\n");

				textAreaProdutos.setText("");
				
				for (Produto pAtual : cAtual.getProdutos()) {
					String codigo = String.valueOf(pAtual.getCodigo());
					String descricao = pAtual.getDescricao();
					String preco = String.valueOf(pAtual.getPreco());
					
					textAreaProdutos.append(codigo +"\t"+ descricao +"\t"+ preco +"\n");
					
//					System.out.println(
//							pAtual.getCodigo() + "\t" + pAtual.getDescricao() + "\t" + pAtual.getPreco() + "\n");
				}
				
				textField_2.setText(String.valueOf(cAtual.getTotal()));
//				JOptionPane.showMessageDialog(null, "Valor total cliente: R$" + cAtual.getTotal());
				
				progressBarCaixa01.setIndeterminate(true);
				Thread.sleep(3000);
			}
			progressBarCaixa01.setIndeterminate(false);
			progressBarCaixa01.setString("SALDO CAIXA: R$"+String.valueOf(caixa.getSaldoCaixa()));
			progressBarCaixa01.setStringPainted(true);
//			JOptionPane.showMessageDialog(null, "SALDO RECEBIDO: R$" + c.getSaldoCaixa());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public Mercadinho() {
		setTitle("Mercadinho");
		getContentPane().setLayout(new GridLayout(1, 0, 0, 0));

		JDesktopPane desktopPane = new JDesktopPane();
		getContentPane().add(desktopPane);
		
		progressBarCaixa01 = new JProgressBar();
		progressBarCaixa01.setBounds(10, 442, 325, 51);
		desktopPane.add(progressBarCaixa01);

		JInternalFrame internalFrame = new JInternalFrame("Caixa 01");
		internalFrame.setBounds(10, 11, 325, 400);
		desktopPane.add(internalFrame);
		internalFrame.getContentPane().setLayout(null);

		JLabel lblCaixa = new JLabel("C\u00D3D. CAIXA");
		lblCaixa.setBounds(10, 11, 86, 14);
		internalFrame.getContentPane().add(lblCaixa);

		textFieldCodCaixa = new JTextField();
		textFieldCodCaixa.setEditable(false);
		textFieldCodCaixa.setBounds(106, 8, 193, 20);
		internalFrame.getContentPane().add(textFieldCodCaixa);
		textFieldCodCaixa.setColumns(10);

		JLabel lblCliente = new JLabel("CLIENTE");
		lblCliente.setBounds(10, 36, 66, 14);
		internalFrame.getContentPane().add(lblCliente);

		textFieldNomeCliente = new JTextField();
		textFieldNomeCliente.setEditable(false);
		textFieldNomeCliente.setBounds(106, 33, 193, 20);
		internalFrame.getContentPane().add(textFieldNomeCliente);
		textFieldNomeCliente.setColumns(10);

		JLabel lblItens = new JLabel("PRODUTOS");
		lblItens.setBounds(128, 75, 66, 14);
		internalFrame.getContentPane().add(lblItens);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 100, 289, 197);
		internalFrame.getContentPane().add(scrollPane);

		textAreaProdutos = new JTextArea();
		scrollPane.setViewportView(textAreaProdutos);
		textAreaProdutos.setEditable(false);
		textAreaProdutos.setLineWrap(true);

		JLabel lblTotal = new JLabel("TOTAL");
		lblTotal.setBounds(148, 324, 46, 14);
		internalFrame.getContentPane().add(lblTotal);

		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setBounds(213, 321, 86, 20);
		internalFrame.getContentPane().add(textField_2);
		textField_2.setColumns(10);

		JInternalFrame internalFrame_1 = new JInternalFrame("Caixa 02");
		internalFrame_1.setBounds(345, 11, 325, 400);
		desktopPane.add(internalFrame_1);
		internalFrame_1.getContentPane().setLayout(null);

		JInternalFrame internalFrame_2 = new JInternalFrame("Caixa 03");
		internalFrame_2.setBounds(680, 11, 318, 400);
		desktopPane.add(internalFrame_2);
		internalFrame_2.getContentPane().setLayout(null);

		progressBarCxComum = new JProgressBar();
		progressBarCxComum.setBounds(345, 442, 325, 51);
		desktopPane.add(progressBarCxComum);

		progressBarCxPreferencial = new JProgressBar();
		progressBarCxPreferencial.setBounds(680, 442, 318, 51);
		desktopPane.add(progressBarCxPreferencial);
		internalFrame_2.setVisible(true);
		internalFrame_1.setVisible(true);
		internalFrame.setVisible(true);

		setSize(1024, 600);
		setLocationRelativeTo(null);
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
}
