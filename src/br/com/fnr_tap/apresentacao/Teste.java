package br.com.fnr_tap.apresentacao;

import java.util.Random;

import javax.swing.JOptionPane;

import br.com.fnr_tap.entidades.Caixa;
import br.com.fnr_tap.entidades.Cliente;
import br.com.fnr_tap.entidades.Produto;

public class Teste implements Runnable {

	
	
	public static void main(String[] args) {
	
		
		try {

			Teste t = new Teste();
			Thread x =  new Thread(t);
			
			Teste t1 = new Teste();
			Thread x1 =  new Thread(t1);
			
			x.start();
			x.join(500);
			
			x1.start();
			x1.join(500);
			
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		new Thread(new Teste()).join();
		
		
		
	}
	
	
	public Teste() {
		// TODO Auto-generated constructor stub
	}


	@Override
	public void run() {
		try {
//			Cliente c1 = new Cliente(95, "Armando", false, true);
//			
//			for (Produto pcAtual : c1.getProdutos()) {
//				System.out.println(pcAtual.getCodigo() + "\t" + pcAtual.getDescricao() +"\t" + pcAtual.getPreco() + "\n");
//			}
			
			Caixa c = new Caixa(new Random().nextInt(2000));
			
			for (Cliente cAtual : c.getClientes()) {
				System.out.println("CAIXA " + c.getCodigo() +" \t\t"+cAtual.getCodigo() + "\t" + cAtual.getNome() +"\t" + cAtual.getTotal() + "\n");
				
				for (Produto pAtual : cAtual.getProdutos()) {
					System.out.println(pAtual.getCodigo() + "\t" + pAtual.getDescricao() +"\t" + pAtual.getPreco() + "\n");
				}
				
				JOptionPane.showMessageDialog(null, "Valor total cliente: R$"+cAtual.getTotal());
				
				Thread.sleep(3000);
			}
			JOptionPane.showMessageDialog(null, "SALDO RECEBIDO: R$"+c.getSaldoCaixa());
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		
	}

}
