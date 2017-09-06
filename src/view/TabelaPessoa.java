package view;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import dao.DaoPessoa;
import model.Pessoa;

public class TabelaPessoa extends AbstractTableModel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String[] nomesColunas = {"ID", "NOME", "CPFCNPJ", "DATA", "ESTADO CIVIL", 
			"IDENTIDADE", "RUA", "NUMERO", "BAIRRO", "ESTADO", "MUNICIPIO", "EMAIL"};
	private ArrayList<Pessoa> listaDePessoas;
	
	public TabelaPessoa() {
		listaDePessoas = new DaoPessoa().listar();
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
		return listaDePessoas.size();
	}

	@Override
	public Object getValueAt(int linha, int coluna) {
		switch (coluna) {
		case 0: return listaDePessoas.get(linha).getIdPessoa();
		case 1: return listaDePessoas.get(linha).getNome();
		case 2: return listaDePessoas.get(linha).getCpfCnpj(); 
		case 3: return listaDePessoas.get(linha).getDtNsc();
		case 4: return listaDePessoas.get(linha).getEstadoCivil();
		case 5: return listaDePessoas.get(linha).getIdentidade();
		case 6: return listaDePessoas.get(linha).getRua();
		case 7: return listaDePessoas.get(linha).getNumero();
		case 8: return listaDePessoas.get(linha).getBairro();
		case 9: return listaDePessoas.get(linha).getEstado();
		case 10: return listaDePessoas.get(linha).getMunicipio();
		case 11: return listaDePessoas.get(linha).geteMail();
		default: return "";
		}
	}

}
