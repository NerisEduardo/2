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
import javax.swing.JPanel;
import javax.swing.JTextField;

import dao.DaoVenda;
import model.Venda;


public class ViewVenda extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private GridBagConstraints gridBagConstraints = new GridBagConstraints();
	JTextField idPessoaJTextField, dataJTextField;
	private JButton salvar, cancelar;
	Venda umaVenda = new Venda();
	DaoVenda daoVenda = new DaoVenda();

	public ViewVenda() {
		super();
		inicializa();
	}

	private void inicializa() {
		JPanel idPessoaJpanel = new JPanel();
		JPanel dataJpanel = new JPanel();
		salvar = new JButton("Adicionar Produtos");
		cancelar = new JButton("Cancelar");
		
		idPessoaJpanel.add(new JLabel("Digite o ID do Cliente: "));
		dataJpanel.add(new JLabel("Digite a Data da Venda: "));
		idPessoaJTextField = new JTextField(20);
		dataJTextField = new JTextField(20);
		
		setSize(1100, 500);
		setLocation(100, 100);
		setLayout(new GridBagLayout());

		adicionaComponente(0, 0, 1, 1, 0, 0, idPessoaJpanel);
		adicionaComponente(0, 1, 1, 1, 0, 0, idPessoaJTextField);
		adicionaComponente(2, 0, 1, 1, 0, 0, dataJpanel);
		adicionaComponente(2, 1, 1, 1, 0, 0, formataData());
		adicionaComponente(3, 0, 1, 1, 0, 0, salvar);
		salvar.setBackground(Color.BLACK);
		salvar.setForeground(Color.white);
		salvar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				adicionaVenda();
				new ViewAdicionaProdutos();
			}
		});
		adicionaComponente(3, 1, 1, 1, 0, 0, cancelar);
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
	
	private void adicionaVenda(){
		umaVenda.setIdCliente(Integer.parseInt(idPessoaJTextField.getText()));
		umaVenda.setDataDaVenda(dataJTextField.getText());
		daoVenda.inserir(umaVenda);
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
	
	private JComponent formataData() {
		try{
    		javax.swing.text.MaskFormatter data = new javax.swing.text.MaskFormatter("##/##/####");
    		dataJTextField = new javax.swing.JFormattedTextField(data);
    	}catch(Exception e){
    	}
		return dataJTextField;
	}

	
	
}
