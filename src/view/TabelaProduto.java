package view;


import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import dao.DaoProduto;
import model.Produto;

public class TabelaProduto extends AbstractTableModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String[] nomesColunas = {"ID", "CODIGO", "DESCRICAO", "DESCRICAO RESUMIDA", "GRUPO", "QTDESTOQUE", "UNIDADE", "VALOR"};
	private ArrayList<Produto> listaDeProdutos;
	
	public TabelaProduto(){
		listaDeProdutos = new DaoProduto().listar();
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
		return listaDeProdutos.size();
	}

	@Override
	public Object getValueAt(int linha, int coluna) {
		switch (coluna) {
		case 0: return listaDeProdutos.get(linha).getIdProduto();
		case 1: return listaDeProdutos.get(linha).getCodigo();
		case 2: return listaDeProdutos.get(linha).getDescricao();
		case 3: return listaDeProdutos.get(linha).getDescricaoResumida();
		case 4: return listaDeProdutos.get(linha).getGrupo();
		case 5: return listaDeProdutos.get(linha).getQtdEstoque();
		case 6: return listaDeProdutos.get(linha).getUnidade();
		case 7: return listaDeProdutos.get(linha).getValor();
		default: return "";
		}
	}

}
