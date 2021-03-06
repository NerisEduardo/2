package view;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class ViewListarPessoas extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ViewListarPessoas() {
		super("Lista de Pessoas Cadastradas");
		
		setBounds(100, 100, 1100, 500);
		
		JTable pessoaJTable = new JTable(new TabelaPessoa());
		if(pessoaJTable.getRowCount() > 0){
			JScrollPane jScrollPane = new JScrollPane(pessoaJTable, 
					JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
			add(jScrollPane);
			setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			setVisible(true);
		}
		else{
			JOptionPane.showMessageDialog(null, "A lista est� vazia!");
			dispose();
		}
	}

	
	
}
