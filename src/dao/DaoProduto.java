package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import conexao.ConexaoSQL;
import model.Produto;

public class DaoProduto {
	private String INSERE_PRODUTO = "INSERT INTO TB_produto(codigo,descricao,descricaoResumida,grupo,"
			+ "qtdEstoque,unidade,valor) VALUES (?,?,?,?,?,?,?)";
	private final String SELECIONA_PRODUTO = "SELECT * FROM TB_produto";
	private final String EXCLUI_PRODUTO = "DELETE FROM TB_produto WHERE idProduto=?";
	
	private static PreparedStatement preparedStatement = null;
	
	public boolean inserir(Produto umProduto){
		boolean ret = false;
		Connection con = new ConexaoSQL().getConexao();
		try{
			preparedStatement = con.prepareStatement(INSERE_PRODUTO);
			preparedStatement.setInt(1, umProduto.getCodigo());
			preparedStatement.setString(2, umProduto.getDescricao());
			preparedStatement.setString(3, umProduto.getDescricaoResumida());
			preparedStatement.setString(4, umProduto.getGrupo());
			preparedStatement.setInt(5, umProduto.getQtdEstoque());
			preparedStatement.setString(6, umProduto.getUnidade());
			preparedStatement.setString(7, umProduto.getValor());
			ret = preparedStatement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return ret;
	}
	
	public ArrayList<Produto> listar() {  
		ArrayList<Produto> listaDeProdutos = new ArrayList<>();
		Connection con = new ConexaoSQL().getConexao();
		
	    try {  
	    	PreparedStatement preparedStatement = con.prepareStatement(SELECIONA_PRODUTO);
		    ResultSet resultSet = preparedStatement.executeQuery();  
	        
		    while (resultSet.next()) {  
		    	Produto produto = new Produto();  
		    	produto.setIdProduto(resultSet.getInt("IDPRODUTO"));
	        	produto.setCodigo(resultSet.getInt("CODIGO"));
	        	produto.setDescricao(resultSet.getString("DESCRICAO"));  
	        	produto.setDescricaoResumida(resultSet.getString("DESCRICAORESUMIDA"));  
	        	produto.setGrupo(resultSet.getString("GRUPO"));
	        	produto.setQtdEstoque(resultSet.getInt("QTDESTOQUE"));  
	        	produto.setUnidade(resultSet.getString("UNIDADE")); 
	        	produto.setValor(resultSet.getString("VALOR")); 
	            listaDeProdutos.add(produto);  
	        }		        
	    	}catch (SQLException e) {  
	    	  e.printStackTrace();
	    	}  
	  
	    return listaDeProdutos;
	} 
	
	public boolean excluir(int id){
		boolean ret = false;
		Connection con = new ConexaoSQL().getConexao();
		try{
			preparedStatement = con.prepareStatement(EXCLUI_PRODUTO);
			preparedStatement.setInt(1, id);
			ret = preparedStatement.execute();
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ret;
	}
}