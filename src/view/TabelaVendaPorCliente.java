package view;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import dao.DaoVenda;
import model.Venda;

public class TabelaVendaPorCliente extends AbstractTableModel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String[] nomesColunas = {"IDVENDA", "NOMECLIENTE", "QUANTIDADE", "VALOR", "DATA"};
	private ArrayList<Venda> listaDeVendas;
	
	public TabelaVendaPorCliente(int id){
		listaDeVendas = new DaoVenda().listarPorCliente(id);
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
		return listaDeVendas.size();
	}

	@Override
	public Object getValueAt(int linha, int coluna) {
		switch (coluna) {
		case 0: return listaDeVendas.get(linha).getIdVenda();
		case 1: return listaDeVendas.get(linha).getNomePessoa();
		case 2: return listaDeVendas.get(linha).getQtdProduto();
		case 3: return listaDeVendas.get(linha).getValorTotal();
		case 4: return listaDeVendas.get(linha).getDataDaVenda();
		default: return "";
		}
	}

}
