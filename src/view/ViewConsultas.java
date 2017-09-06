package view;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ViewConsultas extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private GridBagConstraints gridBagConstraints = new GridBagConstraints();
	private JButton comprasFornecedor, vendasCliente, comprasMes, comprasAno, vendasMes,  
	vendasAno,  sair;

	public ViewConsultas() {
		super();
		inicializa();
	}

	private void inicializa() {
		comprasFornecedor = new JButton("Compras por Fornecedor");
		vendasCliente = new JButton("Vendas por Cliente");
		comprasMes = new JButton("Compras por Mês");
		vendasAno = new JButton("Vendas por Ano");
		comprasAno = new JButton("Compras por Ano"); 
		vendasMes = new JButton("Vendas por Mês"); 
		sair = new JButton("Voltar");
		
		setSize(1100, 500);
		setLocation(100, 100);
		setLayout(new GridBagLayout());

		adicionaComponente(0, 0, 1, 1, 0, 0, comprasFornecedor);
		comprasFornecedor.setBackground(Color.black);
		comprasFornecedor.setForeground(Color.white);
		comprasFornecedor.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int id = Integer.parseInt(JOptionPane.showInputDialog(null, "Insira o ID do Fornecedor: "));
				if(id!=0)
					new ViewListarComprasPorFornecedor(id);
			}
		});
		adicionaComponente(0, 1, 1, 1, 0, 0, comprasMes);
		comprasMes.setBackground(Color.BLACK);
		comprasMes.setForeground(Color.WHITE);
		comprasMes.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String mes = JOptionPane.showInputDialog(null, "Insira o mês da compra: ");
				if(mes!=null)
					new ViewListarComprasPorMes(mes);
			}
		});
		adicionaComponente(0, 2, 1, 1, 0, 0, comprasAno);
		comprasAno.setBackground(Color.BLACK);
		comprasAno.setForeground(Color.WHITE);
		comprasAno.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String ano = JOptionPane.showInputDialog(null, "Insira o ano da compra: ");
				if(ano!=null)
					new ViewListarComprasPorAno(ano);
			}
		});
		adicionaComponente(1, 0, 1, 1, 0, 0, vendasCliente);
		vendasCliente.setBackground(Color.black);
		vendasCliente.setForeground(Color.white);
		vendasCliente.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int id = Integer.parseInt(JOptionPane.showInputDialog(null, "Insira o ID do Cliente: "));
				if(id!=0)
					new ViewListarVendasPorClientes(id);
			}
		});
		adicionaComponente(1, 1, 1, 1, 0, 0, vendasMes);
		vendasMes.setBackground(Color.BLACK);
		vendasMes.setForeground(Color.WHITE);
		vendasMes.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String mes = JOptionPane.showInputDialog(null, "Insira o mês da venda: ");
				if(mes!=null)
					new ViewListarVendasPorMes(mes);
			}
		});
		adicionaComponente(1, 2, 1, 1, 0, 0, vendasAno);
		vendasAno.setBackground(Color.BLACK);
		vendasAno.setForeground(Color.WHITE);
		vendasAno.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String ano = JOptionPane.showInputDialog(null, "Insira o ano da compra: ");
				if(ano!=null)
					new ViewListarVendasPorAno(ano);
			}
		});
		
		adicionaComponente(2, 2, 1, 1, 0, 0, sair);
		sair.setBackground(Color.BLACK);
		sair.setForeground(Color.WHITE);
		sair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		setVisible(true);
		//pack();
		
	}
	
	public void adicionaComponente(int Linha, int Coluna, int Largura,
			int Altura, double EscalaX, double EscalaY, JComponent componente) {

		gridBagConstraints.gridx = Coluna;
		gridBagConstraints.gridy = Linha;
		gridBagConstraints.gridwidth = Largura;
		gridBagConstraints.gridheight = Altura;
		gridBagConstraints.weightx = EscalaX;
		gridBagConstraints.weighty = EscalaY;
		gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraints.anchor = GridBagConstraints.WEST;
		gridBagConstraints.insets = new Insets (0,0,5,5);
		add(componente, gridBagConstraints);
	}

}
