package view;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import dao.DaoVenda;
import model.Venda;

public class TabelaVendasPorAno extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String[] nomesColunas = {"IDVENDA", "IDCLIENTE", "IDPRODUTO", "QUANTIDADE", "DATA", "VALOR"};
	private ArrayList<Venda> listaDeVendas;
	
	public TabelaVendasPorAno(String ano){
		listaDeVendas = new DaoVenda().listarPorAno(ano);
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
		case 1: return listaDeVendas.get(linha).getIdCliente();
		case 2: return listaDeVendas.get(linha).getIdProduto();
		case 3: return listaDeVendas.get(linha).getQtdProduto();
		case 4: return listaDeVendas.get(linha).getDataDaVenda();
		case 5: return listaDeVendas.get(linha).getValorTotal();
		default: return "";
		}
	}
}
