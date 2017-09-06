package view;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class ViewListarTelefones extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ViewListarTelefones() {
		super();
		setBounds(100, 100, 1100, 500);
		
		JTable pessoaJTable = new JTable(new TabelaTelefone());
		if(pessoaJTable.getRowCount() > 0){
			JScrollPane jScrollPane = new JScrollPane(pessoaJTable, 
					JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
			add(jScrollPane);
			setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			setVisible(true);
		}
		else{
			JOptionPane.showMessageDialog(null, "A lista está vazia!");
			dispose();
		}
	}

}
