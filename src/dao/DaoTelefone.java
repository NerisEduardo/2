package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import conexao.ConexaoSQL;
import model.Telefone;

public class DaoTelefone {
	private String ADICIONA_TELEFONE = "INSERT INTO TB_telefone(idPessoa, telefone) VALUES (?,?)";
	private String SELECIONA_ULTIMA_PESSOA = "SELECT MAX(idPessoa) as numero FROM TB_pessoa";
	private String SELECIONAR_TELEFONE = "SELECT TB_telefone.idPessoa, nomePessoa, telefone FROM TB_telefone "
			+ "INNER JOIN TB_pessoa ON TB_pessoa.idPessoa = TB_telefone.idPessoa";
	
	private static PreparedStatement preparedStatement = null;
	
	public boolean inserir(Telefone umTelefone){
		boolean ret = false;
		Connection con = new ConexaoSQL().getConexao();
		try{
			preparedStatement = con.prepareStatement(ADICIONA_TELEFONE);
			preparedStatement.setInt(1, pegarId());
			preparedStatement.setString(2, umTelefone.getTelefone());
			
			ret = preparedStatement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return ret;
	}
	
	public ArrayList<Telefone> listar() {  
		ArrayList<Telefone> listaDeTelefones = new ArrayList<>();
		Connection con = new ConexaoSQL().getConexao();
		
	    try {  
	    	PreparedStatement preparedStatement = con.prepareStatement(SELECIONAR_TELEFONE);
		    ResultSet resultSet = preparedStatement.executeQuery();  
	        
		    while (resultSet.next()) {  
		    	Telefone umTelefone = new Telefone();  
		    	umTelefone.setIdPessoa(resultSet.getInt("IDPESSOA"));
		    	umTelefone.setNomePessoa(resultSet.getString("NOMEPESSOA"));
		    	umTelefone.setTelefone(resultSet.getString("TELEFONE"));
		    	listaDeTelefones.add(umTelefone);  
	        }		        
	    }catch (SQLException e) {  
	   	  e.printStackTrace();
	   	}  
	    return listaDeTelefones;
	} 
	
	public int pegarId() {  
		int id = 0;
		Connection con = new ConexaoSQL().getConexao();
	    try {  
	    	PreparedStatement preparedStatement = con.prepareStatement(SELECIONA_ULTIMA_PESSOA);
		    ResultSet resultSet = preparedStatement.executeQuery();  
	        
		    if (resultSet.next()) {  
		    	id = resultSet.getInt("numero");
	        }		        
	    }catch (SQLException e) {  
	   	  e.printStackTrace();
	   	}  
	    return id;
	} 
}
	
