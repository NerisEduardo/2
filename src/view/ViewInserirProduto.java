package view;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import dao.DaoProduto;
import model.Produto;

public class ViewInserirProduto extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private GridBagConstraints gridBagConstraints = new GridBagConstraints();
	JTextField codigoJTextField, descricaoJTextField, descricaoResumidaJTextField, grupoJTextField, qtdEstoqueJTextField,
	valorJTextField;
	JComboBox unidadeComboBox = new JComboBox(new String[] { "KG", "AR", "MT", "CC", "L", "P", "CM", "LB", "PC", 
			"CX", "M", "PL", "DM", "M2", "TL", "DZ", "M3", "UN", "G", "ML", "GL", "MM"});
	private JButton salvar, cancelar;
	Produto umProduto = new Produto();
	DaoProduto daoProduto = new DaoProduto();

	public ViewInserirProduto() {
		super();
		inicializa();
	}

	private void inicializa() {
		JPanel codigoJpanel = new JPanel();
		JPanel descricaoJpanel = new JPanel();
		JPanel descricaoResumidaJpanel = new JPanel();
		JPanel grupoJpanel = new JPanel();
		JPanel qtdEstoqueJpanel = new JPanel();
		JPanel unidadeJpanel = new JPanel();
		JPanel valorJpanel = new JPanel();
		salvar = new JButton("Salvar");
		cancelar = new JButton("Cancelar");
		
		codigoJpanel.add(new JLabel("Código:"));
		descricaoJpanel.add(new JLabel("Descrição: "));
		descricaoResumidaJpanel.add(new JLabel("Descrição Resumida: "));
		grupoJpanel.add(new JLabel("Grupo: "));
		qtdEstoqueJpanel.add(new JLabel("Quantidade em Estoque: "));
		unidadeJpanel.add(new JLabel("Unidade: "));
		valorJpanel.add(new JLabel("Valor: "));
		codigoJTextField = new JTextField(20);
		descricaoJTextField = new JTextField(20);
		descricaoResumidaJTextField = new JTextField(20);
		grupoJTextField = new JTextField(20);
		qtdEstoqueJTextField = new JTextField(20);
		valorJTextField = new JTextField(20);
		
		setSize(1100, 500);
		setLocation(100, 100);
		setLayout(new GridBagLayout());

		adicionaComponente(0, 0, 1, 1, 0, 0, codigoJpanel);
		adicionaComponente(0, 1, 1, 1, 0, 0, codigoJTextField);
		adicionaComponente(0, 2, 1, 1, 0, 0, descricaoJpanel);
		adicionaComponente(0, 3, 3, 1, 0, 0, descricaoJTextField);
		adicionaComponente(1, 0, 1, 1, 0, 0, descricaoResumidaJpanel);
		adicionaComponente(1, 1, 3, 1, 0, 0, descricaoResumidaJTextField);
		adicionaComponente(1, 4, 1, 1, 0, 0, grupoJpanel);
		adicionaComponente(1, 5, 1, 1, 0, 0, grupoJTextField);
		adicionaComponente(2, 0, 1, 1, 0, 0, qtdEstoqueJpanel);
		adicionaComponente(2, 1, 1, 1, 0, 0, qtdEstoqueJTextField);
		adicionaComponente(2, 2, 1, 1, 0, 0, unidadeJpanel);
		adicionaComponente(2, 3, 1, 1, 0, 0, unidadeComboBox);
		adicionaComponente(2, 4, 1, 1, 0, 0, valorJpanel);
		adicionaComponente(2, 5, 1, 1, 0, 0, valorJTextField);
		adicionaComponente(4, 4, 1, 1, 0, 0, salvar);
		salvar.setBackground(Color.BLACK);
		salvar.setForeground(Color.white);
		salvar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				adicionaProduto();
			}
		});
		adicionaComponente(4, 5, 1, 1, 0, 0, cancelar);
		cancelar.setBackground(Color.BLACK);
		cancelar.setForeground(Color.white);
		cancelar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		setVisible(true);
		//pack();
	}
	
	private void adicionaProduto(){
		umProduto.setCodigo(Integer.parseInt(codigoJTextField.getText()));
		umProduto.setDescricao(descricaoJTextField.getText());
		umProduto.setDescricaoResumida(descricaoResumidaJTextField.getText());
		umProduto.setGrupo(grupoJTextField.getText());
		umProduto.setQtdEstoque(Integer.parseInt(qtdEstoqueJTextField.getText()));
		umProduto.setUnidade((String) (unidadeComboBox.getSelectedItem()));
		umProduto.setValor(valorJTextField.getText());
		daoProduto.inserir(umProduto);
		setVisible(false);
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
