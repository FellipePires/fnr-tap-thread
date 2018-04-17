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

public class CaixaComum extends JFrame implements Runnable {
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

			textFieldCodigoCaixa.setText(String.valueOf(caixa.getCodigo()));
			textFieldCodigoFuncionario.setText("2");

			for (Cliente cAtual : caixa.getClientes()) {
				textFieldNomeCliente.setText(cAtual.getNome());

				textAreaProdutos.setText("");
//				Produto pAtual = new Produto();
				for (int i = cAtual.getProdutos().size(); i > 0 ; i--) {
					
					String codigo = String.valueOf(cAtual.getProdutos().get(i).getCodigo());
					String descricao = cAtual.getProdutos().get(i).getDescricao();
					String preco = String.valueOf(cAtual.getProdutos().get(i).getPreco());

					textAreaProdutos.append(codigo + "\t" + descricao + "\t" + preco + "\n");
					Thread.sleep(cAtual.getProdutos().size() * 200);
				}

				textFieldTotalCliente.setText(String.valueOf(cAtual.getTotal()));

				progresso += (100 / trabalho) + 1;
				
//				while (progresso >= 97) {
//					progresso += 100 / trabalho;
//				}
				
				progressBar.setValue(progresso);
				Mercadinho.coletarDinheiroCaixa(cAtual.getTotal());
				Thread.sleep(3000);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public CaixaComum() {
		setTitle("Caixa Comum");
		getContentPane().setLayout(null);

		JLabel lblCdCaixa = new JLabel("C\u00D3D. CAIXA");
		lblCdCaixa.setBounds(10, 11, 91, 14);
		getContentPane().add(lblCdCaixa);

		textFieldCodigoCaixa = new JTextField();
		textFieldCodigoCaixa.setBounds(112, 8, 312, 20);
		getContentPane().add(textFieldCodigoCaixa);
		textFieldCodigoCaixa.setColumns(10);

		JLabel lblCdFunc = new JLabel("C\u00D3D.FUNC");
		lblCdFunc.setBounds(10, 36, 70, 21);
		getContentPane().add(lblCdFunc);

		textFieldCodigoFuncionario = new JTextField();
		textFieldCodigoFuncionario.setBounds(112, 36, 312, 20);
		getContentPane().add(textFieldCodigoFuncionario);
		textFieldCodigoFuncionario.setColumns(10);

		JLabel lblNomeCliente = new JLabel("NOME CLIENTE");
		lblNomeCliente.setBounds(10, 68, 91, 14);
		getContentPane().add(lblNomeCliente);

		textFieldNomeCliente = new JTextField();
		textFieldNomeCliente.setBounds(112, 62, 312, 20);
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
