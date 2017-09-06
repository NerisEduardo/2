package view;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class ViewSelecionaDiretorio {
	public Path selecionaDiretorio() throws IOException{
		JFileChooser jfilechooser = new JFileChooser();
		
		String pathExemplos = System.getProperty("user.dir");
		File f = new File(pathExemplos);
		//File f = new File("C:\\");
		jfilechooser.setCurrentDirectory(f);
		jfilechooser.setDialogTitle("Selecione o diretório onde será exportado o arquivo");
		jfilechooser.setFileHidingEnabled(true);
		jfilechooser.setMultiSelectionEnabled(false);
		

		
		File[] umArq = {new File(pathExemplos + "\\Novo.txt")};
		jfilechooser.setSelectedFiles(umArq);

		int retorno = jfilechooser.showDialog(null, "Exportar");

		switch (retorno) {
		case JFileChooser.CANCEL_OPTION:
			JOptionPane.showMessageDialog(null,"Operação Cancelada");
			return null;
		case JFileChooser.APPROVE_OPTION:
			return Paths.get(jfilechooser.getSelectedFile().getPath());
		case JFileChooser.ERROR_OPTION:
			JOptionPane.showMessageDialog(null,"Erro na Operação");
			return null;
		}
		
		Path path = Paths.get(jfilechooser.getSelectedFile().getPath());
		//System.out.println(path.toString());
		return path;
	}

}
