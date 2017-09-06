package controller;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import javax.swing.JOptionPane;

import dao.DaoCompra;
import dao.DaoProduto;
import model.Compra;
import model.Produto;

public class ControlleImportaThread implements Runnable{

	private File arquivo;
	
	public ControlleImportaThread(File file) {
		this.arquivo = file;
	}

	@Override
	public void run() {
		roda();
	}

	private void roda() {
		try {
			List<String> list = null;
		    list = Files.readAllLines(Paths.get(arquivo.getPath()), StandardCharsets.ISO_8859_1);
			list.remove(0);
		    trataLinhasDaTabela(list);
		    File arqFeito = new File(arquivo + ".lido");
		    arquivo.renameTo(arqFeito);
		} catch (IOException e) {
			return;
		}
	}
	
	private List<Produto> trataLinhasDaTabela(List<String> list) {
		
		for(int x = 0; x<list.size();x++){
			String[] linhas = (list.get(x).replace("[", "")).split(";");
			populaProduto(linhas);
		}
		Compra umaCompra = new Compra();
		DaoCompra daoCompra = new DaoCompra();
		umaCompra.setIdFornecedor(Integer.parseInt(JOptionPane.showInputDialog(null, "Insira o ID do Fornecedor: ")));
		umaCompra.setDataDaCompra(JOptionPane.showInputDialog(null, "Insira a Data da Compra: "));
		daoCompra.inserir(umaCompra);
		return null;
	}

	private void populaProduto(String[] linhas) {
		Produto umProduto = new Produto();
		DaoProduto daoProduto = new DaoProduto();
		umProduto.setCodigo(Integer.parseInt(linhas[0]));
		umProduto.setDescricao(linhas[1]);
		umProduto.setDescricaoResumida(linhas[2]);
		umProduto.setGrupo(linhas[3]);
		umProduto.setQtdEstoque(Integer.parseInt(linhas[4]));
		umProduto.setUnidade((linhas[5]));
		umProduto.setValor(linhas[6]);
		daoProduto.inserir(umProduto);
	}

}
