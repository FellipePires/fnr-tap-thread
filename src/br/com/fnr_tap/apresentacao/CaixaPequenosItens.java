package br.com.fnr_tap.apresentacao;

import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import br.com.fnr_tap.entidades.Caixa;
import br.com.fnr_tap.entidades.Produto;

import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JProgressBar;

public class CaixaPequenosItens extends JFrame implements Runnable {
	private static final long serialVersionUID = 1L;
	private JTextField textFieldCodigoCaixa;
	private JTextField textFieldNomeCliente;
	private JTextField textFieldTotalCliente;
	private JTextField textFieldCodigoFuncionario;
	private JTextArea textAreaProdutos;
	private JProgressBar progressBar;
	Thread thread;
	int trabalho = 0;

	public void run() {
		try {
			int codigoCaixa = new Random().nextInt(2000);
			Caixa caixa = new Caixa(codigoCaixa);

			trabalho = caixa.getClientes().size();
			int barraProgresso = 0;
			
			textFieldCodigoCaixa.setText(String.valueOf(caixa.getCodigo()));
			textFieldCodigoFuncionario.setText(String.valueOf(new Random().nextInt(2000)));

			for (int i = 0; i < caixa.getClientes().size(); i++) {
				textFieldNomeCliente.setText(caixa.getClientes().get(i).getNome());

				textFieldTotalCliente.setText("");
				textAreaProdutos.setText("");
				for (Produto produtoAtual : caixa.getClientes().get(i).getProdutos()) {
						String codigo = String.valueOf(produtoAtual.getCodigo());
						String descricao = produtoAtual.getDescricao();
						String preco = String.valueOf(produtoAtual.getPreco());

						textAreaProdutos.append(codigo + "\t" + descricao + "\t" + preco + "\n");
						Thread.sleep(1000);
				}

				textFieldTotalCliente.setText(String.valueOf(caixa.getClientes().get(i).getTotal()));

				barraProgresso += (100 / trabalho);

				progressBar.setValue(barraProgresso);
				Mercadinho.coletarDinheiroCaixa(caixa.getSaldoCaixa());

				Thread.sleep(caixa.getClientes().get(i).getProdutos().size() * 100);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public CaixaPequenosItens() throws InterruptedException{
		setTitle("Caixa Pequenos Itens");
		getContentPane().setLayout(null);

		JLabel lblCdCaixa = new JLabel("C\u00D3D. CAIXA");
		lblCdCaixa.setBounds(10, 11, 91, 14);
		getContentPane().add(lblCdCaixa);

		textFieldCodigoCaixa = new JTextField();
		textFieldCodigoCaixa.setEditable(false);
		textFieldCodigoCaixa.setBounds(112, 8, 312, 20);
		getContentPane().add(textFieldCodigoCaixa);
		textFieldCodigoCaixa.setColumns(10);

		JLabel lblCdFunc = new JLabel("C\u00D3D.FUNC");
		lblCdFunc.setBounds(10, 36, 70, 21);
		getContentPane().add(lblCdFunc);

		textFieldCodigoFuncionario = new JTextField();
		textFieldCodigoFuncionario.setEditable(false);
		textFieldCodigoFuncionario.setBounds(112, 36, 312, 20);
		getContentPane().add(textFieldCodigoFuncionario);
		textFieldCodigoFuncionario.setColumns(10);

		JLabel lblNomeCliente = new JLabel("NOME CLIENTE");
		lblNomeCliente.setBounds(10, 68, 91, 14);
		getContentPane().add(lblNomeCliente);

		textFieldNomeCliente = new JTextField();
		textFieldNomeCliente.setEditable(false);
		textFieldNomeCliente.setBounds(112, 65, 312, 20);
		getContentPane().add(textFieldNomeCliente);
		textFieldNomeCliente.setColumns(10);

		JLabel lblProdutos = new JLabel("PRODUTOS");
		lblProdutos.setHorizontalAlignment(SwingConstants.CENTER);
		lblProdutos.setBounds(159, 89, 70, 14);
		getContentPane().add(lblProdutos);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 111, 414, 337);
		getContentPane().add(scrollPane);

		textAreaProdutos = new JTextArea();
		textAreaProdutos.setEditable(false);
		scrollPane.setViewportView(textAreaProdutos);

		progressBar = new JProgressBar();
		progressBar.setStringPainted(true);
		progressBar.setBounds(10, 510, 414, 28);
		getContentPane().add(progressBar);

		JLabel lblTotal = new JLabel("TOTAL");
		lblTotal.setBounds(254, 474, 46, 14);
		getContentPane().add(lblTotal);

		textFieldTotalCliente = new JTextField();
		textFieldTotalCliente.setEditable(false);
		textFieldTotalCliente.setBounds(310, 471, 114, 20);
		getContentPane().add(textFieldTotalCliente);
		textFieldTotalCliente.setColumns(10);

		setSize(450, 600);
		setLocationRelativeTo(null);
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.thread = new Thread(this);
		this.thread.start();
	}
}
