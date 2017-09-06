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

import dao.DaoTelefone;
import model.Telefone;

public class ViewInserirTelefone extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private GridBagConstraints gridBagConstraints = new GridBagConstraints();
	JTextField telefoneJTextField;
	private JButton salvar, cancelar;
	Telefone umTelefone;
	DaoTelefone daoTelefone;
	
	public ViewInserirTelefone() {
		super();
		inicializa();
	}

	private void inicializa() {
		JPanel telefoneJpanel = new JPanel();
		salvar = new JButton("Adicionar Telefone");
		cancelar = new JButton("Cancelar");
		
		telefoneJpanel.add(new JLabel("Digite o Telefone: "));
		telefoneJTextField = new JTextField(20);
		
		setSize(1100, 500);
		setLocation(100, 100);
		setLayout(new GridBagLayout());
		
		adicionaComponente(0, 0, 1, 1, 0, 0, telefoneJpanel);
		adicionaComponente(0, 1, 1, 1, 0, 0, telefoneJTextField);
		adicionaComponente(1, 0, 1, 1, 0, 0, salvar);
		salvar.setBackground(Color.BLACK);
		salvar.setForeground(Color.white);
		salvar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				adicionaTelefone();
			}
		});
		adicionaComponente(1, 1, 1, 1, 0, 0, cancelar);
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
	
	private void adicionaTelefone() {
		umTelefone = new Telefone();
		daoTelefone = new DaoTelefone();
		umTelefone.setTelefone(telefoneJTextField.getText());
		daoTelefone.inserir(umTelefone);
		mensagem();
		
	}
	
	private void mensagem() {
		int opc1 = JOptionPane.showConfirmDialog(null, "Deseja inserir mais Telefones?");
		switch (opc1) {
		case JOptionPane.YES_OPTION:
			telefoneJTextField.setText("");
			break;
		case JOptionPane.NO_OPTION:
			JOptionPane.showMessageDialog(null, "Telefone Inserido!");
			dispose();
			break;
		case JOptionPane.CANCEL_OPTION:
			JOptionPane.showMessageDialog(null, "Telefone Inserido!");
			dispose();
			break;
		case JOptionPane.CLOSED_OPTION:
			JOptionPane.showMessageDialog(null, "Telefone Inserido!");
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
