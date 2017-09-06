package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import conexao.ConexaoSQL;
import model.Compra;

public class DaoCompra {
	private String INSERE_COMPRA = "INSERT INTO TB_compra(idPessoa,dataDaCompra)"
			+ "VALUES (?,?)";
	private String SELECIONA_COMPRA_POR_FORNECEDOR = 
			"SELECT idCompra, TB_compra.idPessoa, nomePessoa, dataDaCompra FROM TB_compra "
			+ "INNER JOIN TB_pessoa ON TB_compra.idPessoa = TB_pessoa.idPessoa WHERE TB_compra.idPessoa = ?";
	private String SELECIONA_DATA = "SELECT idCompra, TB_compra.idPessoa, nomePessoa, dataDaCompra FROM TB_compra "
			+ "INNER JOIN TB_pessoa ON TB_compra.idPessoa = TB_pessoa.idPessoa WHERE dataDaCompra LIKE ?";
	

	private static PreparedStatement preparedStatement = null;
	
	public boolean inserir(Compra umaCompra){
		boolean ret = false;
		Connection con = new ConexaoSQL().getConexao();
		try{
			preparedStatement = con.prepareStatement(INSERE_COMPRA);
			preparedStatement.setInt(1, umaCompra.getIdFornecedor());
			preparedStatement.setString(2, umaCompra.getDataDaCompra());
			ret = preparedStatement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return ret;
	}
	
	public ArrayList<Compra> listarPorFornecedor(int id) {  
		ArrayList<Compra> listaDeCompras = new ArrayList<>();
		Connection con = new ConexaoSQL().getConexao();
		
	    try {  
	    	PreparedStatement preparedStatement = con.prepareStatement(SELECIONA_COMPRA_POR_FORNECEDOR);
	    	preparedStatement.setInt(1, id);
		    ResultSet resultSet = preparedStatement.executeQuery();  
	        
		    while (resultSet.next()) {  
		    	Compra umaCompra = new Compra();  
		    	umaCompra.setIdCompra(resultSet.getInt("IDCOMPRA"));
		    	umaCompra.setIdFornecedor(resultSet.getInt("IDPESSOA"));
		    	umaCompra.setNomePessoa(resultSet.getString("NOMEPESSOA"));
		    	umaCompra.setDataDaCompra(resultSet.getString("DATADACOMPRA"));
		    	listaDeCompras.add(umaCompra);  
	        }	        
	    }catch (SQLException e) {  
	   	  e.printStackTrace();
	   	}  
	    return listaDeCompras;
	} 
	
	public ArrayList<Compra> listarPorMes(String mes) {  
		ArrayList<Compra> listaDeCompras = new ArrayList<>();
		Connection con = new ConexaoSQL().getConexao();
		
	    try {  
	    	PreparedStatement preparedStatement = con.prepareStatement(SELECIONA_DATA);
	    	preparedStatement.setString(1, "%/"+ mes + "/%");
		    ResultSet resultSet = preparedStatement.executeQuery();  
	        
		    while (resultSet.next()) {  
		    	Compra umaCompra = new Compra();  
		    	umaCompra.setIdCompra(resultSet.getInt("IDCOMPRA"));
		    	umaCompra.setIdFornecedor(resultSet.getInt("IDPESSOA"));
		    	umaCompra.setNomePessoa(resultSet.getString("NOMEPESSOA"));
		    	umaCompra.setDataDaCompra(resultSet.getString("DATADACOMPRA"));
		    	listaDeCompras.add(umaCompra);  
	        }	        
	    }catch (SQLException e) {  
	   	  e.printStackTrace();
	   	}  
	    return listaDeCompras;
	} 
	
	public ArrayList<Compra> listarPorAno(String ano) {  
		ArrayList<Compra> listaDeCompras = new ArrayList<>();
		Connection con = new ConexaoSQL().getConexao();
		
	    try {  
	    	PreparedStatement preparedStatement = con.prepareStatement(SELECIONA_DATA);
	    	preparedStatement.setString(1, "%/"+ ano);
		    ResultSet resultSet = preparedStatement.executeQuery();  
	        
		    while (resultSet.next()) {  
		    	Compra umaCompra = new Compra();  
		    	umaCompra.setIdCompra(resultSet.getInt("IDCOMPRA"));
		    	umaCompra.setIdFornecedor(resultSet.getInt("IDPESSOA"));
		    	umaCompra.setNomePessoa(resultSet.getString("NOMEPESSOA"));
		    	umaCompra.setDataDaCompra(resultSet.getString("DATADACOMPRA"));
		    	listaDeCompras.add(umaCompra);  
	        }	        
	    }catch (SQLException e) {  
	   	  e.printStackTrace();
	   	}  
	    return listaDeCompras;
	}
}
