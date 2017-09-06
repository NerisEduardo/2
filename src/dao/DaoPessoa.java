package dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import conexao.ConexaoSQL;
import model.Pessoa;


public class DaoPessoa {
	private String INSERE_PESSOA = "INSERT INTO TB_pessoa(nomePessoa,status,cpfCnpj,data,"
			+ "estadoCivil,identidade,nacionalidade,CEP,rua,numero,bairro,estado,municipio,eMail) "
			+ "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	private String SELECIONAR_PESSOA = "SELECT * FROM TB_pessoa";
	private String EXCLUI_PESSOA = "DELETE FROM TB_pessoa WHERE IDPESSOA=?";
	
	private static PreparedStatement preparedStatement = null;
	
	public boolean inserir(Pessoa umaPessoa){
		boolean ret = false;
		Connection con = new ConexaoSQL().getConexao();
		try{
			preparedStatement = con.prepareStatement(INSERE_PESSOA);
			preparedStatement.setString(1, umaPessoa.getNome());
			preparedStatement.setInt(2, umaPessoa.getStatus());
			preparedStatement.setString(3, umaPessoa.getCpfCnpj());
			preparedStatement.setString(4, umaPessoa.getDtNsc());
			preparedStatement.setString(5, umaPessoa.getEstadoCivil());
			preparedStatement.setString(6, umaPessoa.getIdentidade());
			preparedStatement.setString(7, umaPessoa.getNacionalidade());
			preparedStatement.setString(8, umaPessoa.getCep());
			preparedStatement.setString(9, umaPessoa.getRua());
			preparedStatement.setInt(10, umaPessoa.getNumero());
			preparedStatement.setString(11, umaPessoa.getBairro());
			preparedStatement.setString(12, umaPessoa.getEstado());
			preparedStatement.setString(13, umaPessoa.getMunicipio());
			preparedStatement.setString(14, umaPessoa.geteMail());
			ret = preparedStatement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return ret;
	}
	
	public ArrayList<Pessoa> listar() {  
		ArrayList<Pessoa> listaDePessoas = new ArrayList<>();
		Connection con = new ConexaoSQL().getConexao();
		
	    try {  
	    	PreparedStatement preparedStatement = con.prepareStatement(SELECIONAR_PESSOA);
		    ResultSet resultSet = preparedStatement.executeQuery();  
	        
		    while (resultSet.next()) {  
		    	Pessoa umaPessoa = new Pessoa();  
		    	umaPessoa.setIdPessoa(resultSet.getInt("IDPESSOA"));
		    	umaPessoa.setNome(resultSet.getString("NOMEPESSOA"));
		    	umaPessoa.setCpfCnpj(resultSet.getString("CPFCNPJ"));
		    	umaPessoa.setDtNsc(resultSet.getString("DATA"));
		    	umaPessoa.setEstadoCivil(resultSet.getString("ESTADOCIVIL"));
		    	umaPessoa.setIdentidade(resultSet.getString("IDENTIDADE"));
		    	umaPessoa.setRua(resultSet.getString("RUA"));
		    	umaPessoa.setNumero(resultSet.getInt("NUMERO"));
		    	umaPessoa.setBairro(resultSet.getString("BAIRRO"));
		    	umaPessoa.setEstado(resultSet.getString("ESTADO"));
		    	umaPessoa.setMunicipio(resultSet.getString("MUNICIPIO"));
		    	umaPessoa.seteMail(resultSet.getString("EMAIL"));
	            listaDePessoas.add(umaPessoa);  
	        }		        
	    }catch (SQLException e) {  
	   	  e.printStackTrace();
	   	}  
	    return listaDePessoas;
	} 
	
	public boolean excluir(int id){
		boolean ret = false;
		Connection con = new ConexaoSQL().getConexao();
		try{
			preparedStatement = con.prepareStatement(EXCLUI_PESSOA);
			preparedStatement.setInt(1, id);
			ret = preparedStatement.execute();
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ret;
	}
}
