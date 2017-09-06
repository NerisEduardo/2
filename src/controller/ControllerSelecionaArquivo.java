package controller;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;

import dao.DaoProduto;
import model.Produto;

public class ControllerSelecionaArquivo {
	
	public ControllerSelecionaArquivo() {
		getImporta(selecionaArquivo());
	}
	
	public void getImporta(File[] file) {
		if (file != null){
			for(int x = 0; x < file.length; x++){
				Thread threadImporta = new Thread(new ControlleImportaThread(file[x]));
				threadImporta.start();
			}
			JOptionPane.showMessageDialog(null, file.length + " arquivos importados com sucesso!");
		}
		else
			return;
		return;
	}

	public File[] selecionaArquivo(){
		JOptionPane.showMessageDialog(null, "Selecione os arquivos de compra de produto!");
		JFileChooser jfChooser = new JFileChooser("C:\\Users\\Eduardo\\Documents\\Faculdade\\trabalho2\\temp");
		jfChooser.setDialogTitle("Arquivo para importar");
		jfChooser.setMultiSelectionEnabled(true);
		jfChooser.setFileFilter(new FileFilter() {
			
			@Override
			public String getDescription() {
				return "csv";
			}
			
			@Override
			public boolean accept(File f) {
				return f.getName().endsWith("csv")
						|| f.isDirectory();
			}
		});
		int retorno = jfChooser.showOpenDialog(null);
		switch (retorno) {
		case JFileChooser.CANCEL_OPTION:
			JOptionPane.showMessageDialog(null, "Operação Cancelada");
			break;
		case JFileChooser.APPROVE_OPTION:
			return jfChooser.getSelectedFiles();
		case JFileChooser.ERROR_OPTION:
			JOptionPane.showMessageDialog(null, "Erro na Operação");
			break;
		}
		return null;
	}
}
