package view;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.ControllerExportaArquivo;
import dao.DaoVenda;
import model.Venda;

public class ViewAdicionaProdutos extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private GridBagConstraints gridBagConstraints = new GridBagConstraints();
	JTextField idProdutoJTextField, qtdProdutoJTextField;
	private JButton salvar, cancelar;
	Venda umaVenda = new Venda();
	DaoVenda daoVenda = new DaoVenda();

	public ViewAdicionaProdutos() {
		super();
		inicializa();
	}
	
	private void inicializa() {
		JPanel idProdutoJpanel = new JPanel();
		JPanel qtdProdutoJpanel = new JPanel();
		salvar = new JButton("Adicionar Produto");
		cancelar = new JButton("Cancelar");
		
		idProdutoJpanel.add(new JLabel("Digite o ID do Produto: "));
		qtdProdutoJpanel.add(new JLabel("Digite a Quantidade de Produtos: "));
		idProdutoJTextField = new JTextField(20);
		qtdProdutoJTextField = new JTextField(20);
		
		setSize(1100, 500);
		setLocation(100, 100);
		setLayout(new GridBagLayout());
		
		adicionaComponente(0, 0, 1, 1, 0, 0, idProdutoJpanel);
		adicionaComponente(0, 1, 1, 1, 0, 0, idProdutoJTextField);
		adicionaComponente(1, 0, 1, 1, 0, 0, qtdProdutoJpanel);
		adicionaComponente(1, 1, 1, 1, 0, 0, qtdProdutoJTextField);
		adicionaComponente(2, 0, 1, 1, 0, 0, salvar);
		salvar.setBackground(Color.BLACK);
		salvar.setForeground(Color.white);
		salvar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				adicionaProdutos();
			}
		});
		adicionaComponente(2, 1, 1, 1, 0, 0, cancelar);
		cancelar.setBackground(Color.BLACK);
		cancelar.setForeground(Color.white);
		cancelar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		setVisible(true);
	}
	
	private void adicionaProdutos() {
		umaVenda.setIdProduto(Integer.parseInt(idProdutoJTextField.getText()));
		umaVenda.setQtdProduto(Integer.parseInt(qtdProdutoJTextField.getText()));
		daoVenda.inserirProdutos(umaVenda);
		mensagem();
	}
	
	private void mensagem() {
		int opc1 = JOptionPane.showConfirmDialog(null, "Deseja inserir mais Produtos?");
		switch (opc1) {
		case JOptionPane.YES_OPTION:
			idProdutoJTextField.setText("");
			qtdProdutoJTextField.setText("");
			break;
		case JOptionPane.NO_OPTION:
			JOptionPane.showMessageDialog(null, "Venda Finalizada!");
			new ControllerExportaArquivo();
			dispose();
			break;
		case JOptionPane.CANCEL_OPTION:
			JOptionPane.showMessageDialog(null, "Venda Finalizada!");
			new ControllerExportaArquivo();
			dispose();
			break;
		case JOptionPane.CLOSED_OPTION:
			JOptionPane.showMessageDialog(null, "Venda Finalizada!");
			new ControllerExportaArquivo();
			dispose();
			break;
		}
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
		add(componente, gridBagConstraints);
	}

}
