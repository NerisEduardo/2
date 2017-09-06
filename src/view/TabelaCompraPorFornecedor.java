package view;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import dao.DaoCompra;
import model.Compra;

public class TabelaCompraPorFornecedor extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String[] nomesColunas = {"IDCOMPRA", "IDFORNECEDOR", "NOME", "DATA"};
	private ArrayList<Compra> listaDeCompras;
	
	public TabelaCompraPorFornecedor(int id){
		listaDeCompras = new DaoCompra().listarPorFornecedor(id);
	}
	
	public int getColumnCount() {
		return nomesColunas.length;
	}

	public String getColumnName(int col) {
        return nomesColunas[col];
    }

	public int getRowCount() {
		return listaDeCompras.size();
	}

	public Object getValueAt(int linha, int coluna) {
		switch (coluna) {
		case 0: return listaDeCompras.get(linha).getIdCompra();
		case 1: return listaDeCompras.get(linha).getIdFornecedor();
		case 2: return listaDeCompras.get(linha).getNomePessoa();
		case 3: return listaDeCompras.get(linha).getDataDaCompra();
		default: return "";
		}
	}

}
