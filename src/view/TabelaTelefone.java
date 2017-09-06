package view;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import dao.DaoTelefone;
import model.Telefone;

public class TabelaTelefone extends AbstractTableModel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String[] nomesColunas = {"IDPESSOA", "NOME", "TELEFONE"};
	private ArrayList<Telefone> listaDeTelefones;
	
	public TabelaTelefone(){
		listaDeTelefones = new DaoTelefone().listar();
	}

	@Override
	public int getColumnCount() {
		return nomesColunas.length;
	}

	@Override
	public String getColumnName(int col) {
        return nomesColunas[col];
    }

	@Override
	public int getRowCount() {
		return listaDeTelefones.size();
	}

	@Override
	public Object getValueAt(int linha, int coluna) {
		switch (coluna) {
		case 0: return listaDeTelefones.get(linha).getIdPessoa();
		case 1: return listaDeTelefones.get(linha).getNomePessoa();
		case 2: return listaDeTelefones.get(linha).getTelefone();
		default: return "";
		}
	}

}
