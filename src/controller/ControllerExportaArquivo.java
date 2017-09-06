package controller;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

import dao.DaoVenda;
import model.Venda;
import view.ViewSelecionaDiretorio;

public class ControllerExportaArquivo {

	public ControllerExportaArquivo() {
		super();
		try {
			Path npath = new ViewSelecionaDiretorio().selecionaDiretorio();
			if(npath!=null)
				exportar(npath);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void exportar(Path npath) throws IOException {
		DaoVenda daoVenda = new DaoVenda();
		BufferedWriter writer = Files.newBufferedWriter(npath, StandardCharsets.UTF_8, StandardOpenOption.CREATE);
		
		for(Venda umaVenda : daoVenda.listarPorUltimaVenda())
			writer.write(umaVenda.toString());
			
		writer.close();
		
	}

	
}
