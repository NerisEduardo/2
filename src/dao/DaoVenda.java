package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import conexao.ConexaoSQL;
import model.Venda;

public class DaoVenda {
	private String INSERE_VENDA = "INSERT INTO TB_venda(idPessoa,dataDaVenda)"
			+ "VALUES (?,?)";
	private String INSERE_PRODUTOS = "INSERT INTO TB_vendaProdutos(idProduto,qtdProduto)"
			+ "VALUES (?,?)";
	private String SELECIONA_VENDA_POR_CLIENTE = 
			"SELECT TB_venda.idVenda, nomePessoa, SUM(qtdProduto) AS QTDPRODUTO, SUM(valorProduto) AS VALORTOTAL, dataDaVenda "
			+ "FROM TB_venda "
			+ "INNER JOIN TB_pessoa ON TB_pessoa.idPessoa = TB_venda.idPessoa "
			+ "INNER JOIN TB_vendaProdutos ON TB_vendaProdutos.idVenda = TB_venda.idVenda "
			+ "WHERE TB_pessoa.idPessoa = ? "
			+ "GROUP BY TB_venda.idVenda, nomePessoa, dataDaVenda";
	private String SELECIONA_DATA = 
			"SELECT TB_venda.idVenda, nomePessoa, SUM(qtdProduto) AS qtdProduto, SUM(valorProduto) AS valorTotal, dataDaVenda "
			+ "FROM TB_venda "
			+ "INNER JOIN TB_vendaProdutos ON TB_venda.idVenda = TB_vendaProdutos.idVenda "
			+ "INNER JOIN TB_pessoa ON TB_pessoa.idPessoa = TB_venda.idPessoa "
			+ "WHERE dataDaVenda LIKE ? "
			+ "GROUP BY TB_venda.idVenda, nomePessoa, dataDaVenda";
	private String SELECIONA_ÚLTIMA_VENDA = 
			"SELECT TB_venda.idVenda, TB_venda.idPessoa, nomePessoa, SUM(qtdProduto) AS qtd , dataDaVenda, SUM(valorProduto) AS valor "
			+ "FROM TB_venda "
			+ "INNER JOIN TB_pessoa ON TB_pessoa.idPessoa = TB_venda.idPessoa "
			+ "INNER JOIN TB_vendaProdutos ON TB_venda.idVenda = TB_vendaProdutos.idVenda "
			+ "WHERE TB_venda.idVenda = (SELECT MAX(idVenda) FROM TB_venda) "
			+ "GROUP BY TB_venda.idVenda, TB_venda.idPessoa, nomePessoa, dataDaVenda";
	
	private static PreparedStatement preparedStatement = null;
	
	public boolean inserir(Venda umaVenda){
		boolean ret = false;
		Connection con = new ConexaoSQL().getConexao();
		try{
			preparedStatement = con.prepareStatement(INSERE_VENDA);
			preparedStatement.setInt(1, umaVenda.getIdCliente());
			preparedStatement.setString(2, umaVenda.getDataDaVenda());
			ret = preparedStatement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return ret;
	}
	
	public boolean inserirProdutos(Venda umaVenda){
		boolean ret = false;
		Connection con = new ConexaoSQL().getConexao();
		try{
			preparedStatement = con.prepareStatement(INSERE_PRODUTOS);
			preparedStatement.setInt(1, umaVenda.getIdProduto());
			preparedStatement.setInt(2, umaVenda.getQtdProduto());
			ret = preparedStatement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return ret;
	}

	public ArrayList<Venda> listarPorCliente(int id) {  
		ArrayList<Venda> listaDeVendas = new ArrayList<>();
		Connection con = new ConexaoSQL().getConexao();
		
	    try {  
	    	PreparedStatement preparedStatement = con.prepareStatement(SELECIONA_VENDA_POR_CLIENTE);
	    	preparedStatement.setInt(1, id);
		    ResultSet resultSet = preparedStatement.executeQuery();  
	        
		    while (resultSet.next()) {  
		    	Venda umaVenda = new Venda();  
		    	umaVenda.setIdVenda(resultSet.getInt("IDVENDA"));
		    	umaVenda.setNomePessoa(resultSet.getString("NOMEPESSOA"));
		    	umaVenda.setQtdProduto(resultSet.getInt("QTDPRODUTO"));
		    	umaVenda.setValorTotal(resultSet.getString("VALORTOTAL"));
		    	umaVenda.setDataDaVenda(resultSet.getString("DATADAVENDA"));
	            listaDeVendas.add(umaVenda);  
	        }		        
	    }catch (SQLException e) {  
	   	  e.printStackTrace();
	   	}  
	    return listaDeVendas;
	} 
	
	public ArrayList<Venda> listarPorMes(String mes) {  
		ArrayList<Venda> listaDeVendas = new ArrayList<>();
		Connection con = new ConexaoSQL().getConexao();
		
	    try {  
	    	PreparedStatement preparedStatement = con.prepareStatement(SELECIONA_DATA);
	    	preparedStatement.setString(1, "%/"+ mes + "/%");
		    ResultSet resultSet = preparedStatement.executeQuery();  
	        
		    while (resultSet.next()) {  
		    	Venda umaVenda = new Venda();  
		    	umaVenda.setIdVenda(resultSet.getInt("IDVENDA"));
		    	umaVenda.setNomePessoa(resultSet.getString("NOMEPESSOA"));
		    	umaVenda.setQtdProduto(resultSet.getInt("QTDPRODUTO"));
		    	umaVenda.setValorTotal(resultSet.getString("VALORTOTAL"));
		    	umaVenda.setDataDaVenda(resultSet.getString("DATADAVENDA"));
	            listaDeVendas.add(umaVenda);  
	        }	        
	    }catch (SQLException e) {  
	   	  e.printStackTrace();
	   	}  
	    return listaDeVendas;
	} 
	
	public ArrayList<Venda> listarPorAno(String ano) {  
		ArrayList<Venda> listaDeVendas = new ArrayList<>();
		Connection con = new ConexaoSQL().getConexao();
		
	    try {  
	    	PreparedStatement preparedStatement = con.prepareStatement(SELECIONA_DATA);
	    	preparedStatement.setString(1, "%/" + ano);
		    ResultSet resultSet = preparedStatement.executeQuery();  
	        
		    while (resultSet.next()) {  
		    	Venda umaVenda = new Venda();  
		    	umaVenda.setIdVenda(resultSet.getInt("IDVENDA"));
		    	umaVenda.setNomePessoa(resultSet.getString("NOMEPESSOA"));
		    	umaVenda.setQtdProduto(resultSet.getInt("QTDPRODUTO"));
		    	umaVenda.setValorTotal(resultSet.getString("VALORTOTAL"));
		    	umaVenda.setDataDaVenda(resultSet.getString("DATADAVENDA"));
	            listaDeVendas.add(umaVenda);  
	        }	        
	    }catch (SQLException e) {  
	   	  e.printStackTrace();
	   	}  
	    return listaDeVendas;
	}
	
	public ArrayList<Venda> listarPorUltimaVenda() {  
		ArrayList<Venda> listaDeVendas = new ArrayList<>();
		Connection con = new ConexaoSQL().getConexao();
		
	    try {  
	    	PreparedStatement preparedStatement = con.prepareStatement(SELECIONA_ÚLTIMA_VENDA);
		    ResultSet resultSet = preparedStatement.executeQuery();  
	        
		    while (resultSet.next()) {  
		    	Venda umaVenda = new Venda();  
		    	umaVenda.setIdVenda(resultSet.getInt("IDVENDA"));
		    	umaVenda.setIdCliente(resultSet.getInt("IDPESSOA"));
		    	umaVenda.setNomePessoa(resultSet.getString("NOMEPESSOA"));
		    	umaVenda.setQtdProduto(resultSet.getInt("QTD"));
		    	umaVenda.setDataDaVenda(resultSet.getString("DATADAVENDA"));
		    	umaVenda.setValorTotal(resultSet.getString("VALOR"));
	            listaDeVendas.add(umaVenda);  
	        }	        
	    }catch (SQLException e) {  
	   	  e.printStackTrace();
	   	}  
	    return listaDeVendas;
	}

}
