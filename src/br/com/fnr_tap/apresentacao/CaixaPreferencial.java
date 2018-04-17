package br.com.fnr_tap.apresentacao;

import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import br.com.fnr_tap.entidades.Caixa;
import br.com.fnr_tap.entidades.Cliente;
import br.com.fnr_tap.entidades.Produto;

import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JProgressBar;

public class CaixaPreferencial extends JFrame implements Runnable {
	private static final long serialVersionUID = 1L;
	private JTextField textFieldCodigoCaixa;
	private JTextField textFieldNomeCliente;
	private JTextField textFieldTotalCliente;
	private JTextField textFieldCodigoFuncionario;
	private JTextArea textAreaProdutos;
	private JProgressBar progressBar;
	static int trabalho = 0;

	public void run() {
		try {
			int codigoCaixa = new Random().nextInt(2000);
			Caixa caixa = new Caixa(codigoCaixa);

			trabalho = caixa.getClientes().size();
			int progresso = 0;
			int i = 0;

			textFieldCodigoCaixa.setText(String.valueOf(caixa.getCodigo()));
			textFieldCodigoFuncionario.setText("1");

			for (Cliente cAtual : caixa.getClientes()) {
				textFieldNomeCliente.setText(cAtual.getNome());

				textAreaProdutos.setText("");
				for (Produto pAtual : cAtual.getProdutos()) {
					String codigo = String.valueOf(pAtual.getCodigo());
					String descricao = pAtual.getDescricao();
					String preco = String.valueOf(pAtual.getPreco());

					textAreaProdutos.append(codigo + "\t" + descricao + "\t" + preco + "\n");
				}

				textFieldTotalCliente.setText(String.valueOf(cAtual.getTotal()));

				progresso += (100 / trabalho);

				progressBar.setValue(progresso);
				Mercadinho.coletarDinheiroCaixa(cAtual.getTotal());
				
				Thread.sleep(caixa.getClientes().get(i).getProdutos().size());//Alterar p/ qntd produtos
				i++;
			}

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public CaixaPreferencial() {
		setTitle("Caixa Preferencial");
		getContentPane().setLayout(null);

		JLabel lblCdCaixa = new JLabel("C\u00D3D. CAIXA");
		lblCdCaixa.setBounds(10, 11, 91, 14);
		getContentPane().add(lblCdCaixa);

		textFieldCodigoCaixa = new JTextField();
		textFieldCodigoCaixa.setBounds(112, 8, 312, 20);
		getContentPane().add(textFieldCodigoCaixa);
		textFieldCodigoCaixa.setColumns(10);

		JLabel lblCdFunc = new JLabel("C\u00D3D.FUNC");
		lblCdFunc.setBounds(10, 36, 70, 17);
		getContentPane().add(lblCdFunc);

		textFieldCodigoFuncionario = new JTextField();
		textFieldCodigoFuncionario.setBounds(112, 34, 312, 20);
		getContentPane().add(textFieldCodigoFuncionario);
		textFieldCodigoFuncionario.setColumns(10);

		JLabel lblNomeCliente = new JLabel("NOME CLIENTE");
		lblNomeCliente.setBounds(10, 64, 91, 14);
		getContentPane().add(lblNomeCliente);

		textFieldNomeCliente = new JTextField();
		textFieldNomeCliente.setBounds(112, 61, 312, 20);
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
		scrollPane.setViewportView(textAreaProdutos);

		progressBar = new JProgressBar();
		progressBar.setStringPainted(true);
		progressBar.setBounds(10, 510, 414, 28);
		getContentPane().add(progressBar);

		JLabel lblTotal = new JLabel("TOTAL");
		lblTotal.setBounds(254, 474, 46, 14);
		getContentPane().add(lblTotal);

		textFieldTotalCliente = new JTextField();
		textFieldTotalCliente.setBounds(310, 471, 114, 20);
		getContentPane().add(textFieldTotalCliente);
		textFieldTotalCliente.setColumns(10);

		setSize(450, 600);
		setLocationRelativeTo(null);
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
