package conexao;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConexaoSQL {

	public Connection getConexao() {

		Path path = Paths.get(System.getProperty("user.dir") +
				System.getProperty("file.separator") + "lib" +
				System.getProperty("file.separator") + "conf.properties");
		Properties properties = getProperties(path);
		
		String uri = properties.getProperty("URL") + properties.getProperty("BASE");		
		
		//System.out.println(path);
		try {
			Class.forName(properties.getProperty("DRIVER_CLASS"));
			return DriverManager.getConnection(uri, 
					properties.getProperty("USUARIO"), 
					properties.getProperty("SENHA"));
		} catch (ClassNotFoundException e) {
			System.out.println("ClassNotFoundException");
			return null;
		}catch (SQLException e) {
			System.out.println("SQLException");
			return null;
		}
	}
	
	private Properties getProperties(Path path) {
		Properties properties = new Properties();

		try (BufferedReader bufferedReader = Files.newBufferedReader(path,
				StandardCharsets.ISO_8859_1)) {
			properties.load(bufferedReader);
		} catch (IOException e) {
			System.err.println("Arquivo conf.properties não encontrado");
		}
		return properties;
	}
}
