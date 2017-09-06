package view;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import dao.DaoPessoa;
import dao.DaoTelefone;
import model.Pessoa;
import model.Telefone;

public class ViewInserirPessoa extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private GridBagConstraints gridBagConstraints = new GridBagConstraints();
	JTextField nomeJTextField, cpfCnpjJTextField, dtNscJTextField, identidadeJTextField,
	nacionalidadeJTextField, cepJTextField, ruaJTextField, numeroJTextField, bairroJTextField, 
	municipioJTextField, eMailJTextField;
	private JButton salvar, cancelar;
	JComboBox statusComboBox = new JComboBox(new String[] { "1", "0" });
	JComboBox estadoComboBox = new JComboBox(new String[] { "PR", "SC", "RS", "AC", "AL", "AP", "AM", "BA", "CE", 
			"DF", "GO", "MA", "MT", "MS", "MG", "PR", "PA", "PB", "PE", "PI", "RJ", "RN", "RO", "RR", "SP", "SE", "TO" });
	JComboBox estadoCivilComboBox = new JComboBox(new String[] { "Solteiro", "Casado", "Viúvo", "Divorciado" });
	Pessoa umaPessoa = new Pessoa();
	DaoPessoa daoPessoa = new DaoPessoa();
	public ViewInserirPessoa(){
		super();
		inicializa();
	}
	
	private void inicializa() {
		JPanel nomeJpanel = new JPanel();
		JPanel statusJpanel = new JPanel();
		JPanel cpfCnpjJpanel = new JPanel();
		JPanel dtNscJpanel = new JPanel();
		JPanel estadoCivilJpanel = new JPanel();
		JPanel identidadeJpanel = new JPanel();
		JPanel nacionalidadeJpanel = new JPanel();
		JPanel cepJpanel = new JPanel();
		JPanel ruaJpanel = new JPanel();
		JPanel numeroJpanel = new JPanel();
		JPanel bairroJpanel = new JPanel();
		JPanel estadoJpanel = new JPanel();
		JPanel municipioJpanel = new JPanel();
		JPanel eMailJpanel = new JPanel();
		salvar = new JButton("Salvar");
		cancelar = new JButton("Voltar");
		
		nomeJpanel.add(new JLabel("Nome:"));
		statusJpanel.add(new JLabel("Status: "));
		cpfCnpjJpanel.add(new JLabel("CPF/CNPJ: "));
		dtNscJpanel.add(new JLabel("Data de Nascimento: "));
		estadoCivilJpanel.add(new JLabel("Estado Civil: "));
		identidadeJpanel.add(new JLabel("Identidade: "));
		eMailJpanel.add(new JLabel("E-Mail: "));
		nacionalidadeJpanel.add(new JLabel("Nacionalidade: "));
		cepJpanel.add(new JLabel("CEP: "));
		ruaJpanel.add(new JLabel("Rua: "));
		numeroJpanel.add(new JLabel("Número: "));
		bairroJpanel.add(new JLabel("Bairro: "));
		estadoJpanel.add(new JLabel("Estado: "));
		municipioJpanel.add(new JLabel("Município: "));
		
		nomeJTextField = new JTextField(20);
		cpfCnpjJTextField = new JTextField(20);
		dtNscJTextField = new JTextField(20);
		identidadeJTextField = new JTextField(20);
		eMailJTextField = new JTextField(20);
		nacionalidadeJTextField = new JTextField(20);
		cepJTextField = new JTextField(20);
		ruaJTextField = new JTextField(49);
		numeroJTextField = new JTextField(20);
		bairroJTextField = new JTextField(20);
		municipioJTextField = new JTextField(20);
		
		setSize(1100, 500);
		setLocation(100, 100);
		setLayout(new GridBagLayout());

		adicionaComponente(0, 0, 1, 1, 0, 0, nomeJpanel);
		adicionaComponente(0, 1, 1, 1, 0, 0, nomeJTextField);
		adicionaComponente(0, 2, 1, 1, 0, 0, statusJpanel);
		adicionaComponente(0, 3, 1, 1, 0, 0, statusComboBox);
		adicionaComponente(0, 4, 1, 1, 0, 0, cpfCnpjJpanel);
		adicionaComponente(0, 5, 1, 1, 0, 0, cpfCnpjJTextField);
		adicionaComponente(1, 0, 1, 1, 0, 0, dtNscJpanel);
		adicionaComponente(1, 1, 1, 1, 0, 0, formataData());
		adicionaComponente(1, 2, 1, 1, 0, 0, estadoCivilJpanel);
		adicionaComponente(1, 3, 1, 1, 0, 0, estadoCivilComboBox);
		adicionaComponente(1, 4, 1, 1, 0, 0, identidadeJpanel);
		adicionaComponente(1, 5, 1, 1, 0, 0, identidadeJTextField);
		adicionaComponente(2, 0, 1, 1, 0, 0, eMailJpanel);
		adicionaComponente(2, 1, 1, 1, 0, 0, eMailJTextField);
		adicionaComponente(2, 2, 1, 1, 0, 0, nacionalidadeJpanel);
		adicionaComponente(2, 3, 1, 1, 0, 0, nacionalidadeJTextField);
		adicionaComponente(2, 4, 1, 1, 0, 0, cepJpanel);
		adicionaComponente(2, 5, 1, 1, 0, 0, formataCep());
		adicionaComponente(3, 0, 1, 1, 0, 0, ruaJpanel);
		adicionaComponente(3, 1, 3, 1, 0, 0, ruaJTextField);
		adicionaComponente(3, 4, 1, 1, 0, 0, numeroJpanel);
		adicionaComponente(3, 5, 1, 1, 0, 0, numeroJTextField);
		adicionaComponente(4, 0, 1, 1, 0, 0, bairroJpanel);
		adicionaComponente(4, 1, 1, 1, 0, 0, bairroJTextField);
		adicionaComponente(4, 2, 1, 1, 0, 0, municipioJpanel);
		adicionaComponente(4, 3, 1, 1, 0, 0, municipioJTextField);
		adicionaComponente(4, 4, 1, 1, 0, 0, estadoJpanel);
		adicionaComponente(4, 5, 1, 1, 0, 0, estadoComboBox);
		adicionaComponente(5, 4, 1, 1, 0, 0, salvar);
		salvar.setBackground(Color.BLACK);
		salvar.setForeground(Color.white);
		salvar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					adicionaPessoa();
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
				int opc1 = JOptionPane.showConfirmDialog(null, "Deseja Inserir Telefone?");
				switch (opc1) {
				case JOptionPane.YES_OPTION:
					new ViewInserirTelefone();
					break;
				case JOptionPane.NO_OPTION:
					dispose();
					break;
				case JOptionPane.CANCEL_OPTION:
					dispose();
					break;
				case JOptionPane.CLOSED_OPTION:
					dispose();
					break;
				}
			}

			
		});
		adicionaComponente(5, 5, 1, 1, 0, 0, cancelar);
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
	
	private void adicionaPessoa() throws ParseException {
		umaPessoa.setNome(nomeJTextField.getText());
    	umaPessoa.setStatus(Integer.parseInt((String) statusComboBox.getSelectedItem()));
    	umaPessoa.setCpfCnpj(cpfCnpjJTextField.getText());
    	umaPessoa.setDtNsc(dtNscJTextField.getText());
    	umaPessoa.setEstadoCivil((String) estadoCivilComboBox.getSelectedItem());
    	umaPessoa.setIdentidade(identidadeJTextField.getText());
    	umaPessoa.setNacionalidade(nacionalidadeJTextField.getText());
    	umaPessoa.setCep(cepJTextField.getText());
    	umaPessoa.setRua(ruaJTextField.getText());
    	umaPessoa.setNumero(Integer.parseInt(numeroJTextField.getText()));
    	umaPessoa.setBairro(bairroJTextField.getText());
    	umaPessoa.setEstado((String) estadoComboBox.getSelectedItem());
    	umaPessoa.setMunicipio(municipioJTextField.getText());
    	umaPessoa.seteMail(eMailJTextField.getText());
    	daoPessoa.inserir(umaPessoa);
	}
	
	private JComponent formataCep() {
		try{
    		javax.swing.text.MaskFormatter cep = new javax.swing.text.MaskFormatter("##.###-###");
    		cepJTextField = new javax.swing.JFormattedTextField(cep);
    	}catch(Exception e){
    	}
		return cepJTextField;
	}

	private JComponent formataData() {
		try{
    		javax.swing.text.MaskFormatter data = new javax.swing.text.MaskFormatter("##/##/####");
    		dtNscJTextField = new javax.swing.JFormattedTextField(data);
    	}catch(Exception e){
    	}
		return dtNscJTextField;
	}

}
