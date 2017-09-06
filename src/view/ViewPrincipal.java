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

import controller.ControllerSelecionaArquivo;
import dao.DaoPessoa;
import dao.DaoProduto;

public class ViewPrincipal extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private GridBagConstraints gridBagConstraints = new GridBagConstraints();
	private JButton inserirPessoa, inserirProduto, listarPessoa, excluirPessoa, excluirProduto,  
	listarProduto, listarTelefone, compraProduto, venderProduto, consulta,  sair;

	public ViewPrincipal() {
		super();
		inicializa();
	}

	private void inicializa() {
		inserirPessoa = new JButton("Inserir Pessoa");
		inserirProduto = new JButton("Inserir Produto");
		listarPessoa = new JButton("Listar Pessoa");
		listarProduto = new JButton("Listar Produto");
		listarTelefone = new JButton("Listar Telefones");
		compraProduto = new JButton("Comprar Produto");
		excluirPessoa = new JButton("Excluir Pessoa"); 
		excluirProduto = new JButton("Excluir Produto"); 
		venderProduto = new JButton("Nova Venda");
		consulta = new JButton("Consultas");
		sair = new JButton("Sair");
		
		setSize(1100, 500);
		setLocation(100, 100);
		setLayout(new GridBagLayout());

		adicionaComponente(0, 0, 1, 1, 0, 0, inserirPessoa);
		inserirPessoa.setBackground(Color.black);
		inserirPessoa.setForeground(Color.white);
		inserirPessoa.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new ViewInserirPessoa();
			}
		});
		adicionaComponente(0, 1, 1, 1, 0, 0, listarPessoa);
		listarPessoa.setBackground(Color.BLACK);
		listarPessoa.setForeground(Color.WHITE);
		listarPessoa.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new ViewListarPessoas();
			}
		});
		adicionaComponente(0, 2, 1, 1, 0, 0, listarTelefone);
		listarTelefone.setBackground(Color.BLACK);
		listarTelefone.setForeground(Color.WHITE);
		listarTelefone.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new ViewListarTelefones();
			}
		});
		adicionaComponente(0, 3, 1, 1, 0, 0, excluirPessoa);
		excluirPessoa.setBackground(Color.BLACK);
		excluirPessoa.setForeground(Color.WHITE);
		excluirPessoa.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String id = JOptionPane.showInputDialog(null, "Digite o ID da pessoa: ");
				if(id!=null){
					DaoPessoa daoPessoa = new DaoPessoa();
					daoPessoa.excluir(Integer.parseInt(id));
					setVisible(false);
				}
			}
		});
		adicionaComponente(1, 0, 1, 1, 0, 0, inserirProduto);
		inserirProduto.setBackground(Color.black);
		inserirProduto.setForeground(Color.white);
		inserirProduto.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new ViewInserirProduto();
			}
		});
		
		adicionaComponente(1, 1, 1, 1, 0, 0, listarProduto);
		listarProduto.setBackground(Color.BLACK);
		listarProduto.setForeground(Color.WHITE);
		listarProduto.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new ViewListarProdutos();
			}
		});
		
		adicionaComponente(1, 2, 1, 1, 0, 0, compraProduto);
		compraProduto.setBackground(Color.BLACK);
		compraProduto.setForeground(Color.WHITE);
		compraProduto.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new ControllerSelecionaArquivo();
			}
		});
		adicionaComponente(1, 3, 1, 1, 0, 0, excluirProduto);
		excluirProduto.setBackground(Color.BLACK);
		excluirProduto.setForeground(Color.WHITE);
		excluirProduto.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String id = JOptionPane.showInputDialog(null, "Digite o ID da produto: ");
				if(id!=null){
					DaoProduto daoProduto = new DaoProduto();
					daoProduto.excluir(Integer.parseInt(id));
					setVisible(false);
				}
			}
		});
		adicionaComponente(2, 0, 1, 1, 0, 0, venderProduto);
		venderProduto.setBackground(Color.BLACK);
		venderProduto.setForeground(Color.WHITE);
		venderProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ViewVenda();
			}
		});
		adicionaComponente(2, 1, 1, 1, 0, 0, consulta);
		consulta.setBackground(Color.BLACK);
		consulta.setForeground(Color.WHITE);
		consulta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ViewConsultas();
			}
		});
		adicionaComponente(2, 3, 1, 1, 0, 0, sair);
		sair.setBackground(Color.BLACK);
		sair.setForeground(Color.WHITE);
		sair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		setVisible(true);
		
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
