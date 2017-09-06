package model;

public class Venda {
	private int idVenda;
	private int idCliente;
	private int idProduto;
	private int qtdProduto;
	private String nomePessoa;
	private String descricao;
	private String dataDaVenda;
	private String valorTotal;
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public int getQtdProduto() {
		return qtdProduto;
	}
	public String getNomePessoa() {
		return nomePessoa;
	}
	public void setNomePessoa(String nomePessoa) {
		this.nomePessoa = nomePessoa;
	}
	public void setQtdProduto(int qtdProduto) {
		this.qtdProduto = qtdProduto;
	}
	
	public int getIdVenda() {
		return idVenda;
	}
	public void setIdVenda(int idVenda) {
		this.idVenda = idVenda;
	}
	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	public int getIdProduto() {
		return idProduto;
	}
	public void setIdProduto(int idProduto) {
		this.idProduto = idProduto;
	}
	public String getDataDaVenda() {
		return dataDaVenda;
	}
	public void setDataDaVenda(String dataDaVenda) {
		this.dataDaVenda = dataDaVenda;
	}
	public String getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(String valorTotal) {
		this.valorTotal = valorTotal;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataDaVenda == null) ? 0 : dataDaVenda.hashCode());
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + idCliente;
		result = prime * result + idProduto;
		result = prime * result + idVenda;
		result = prime * result + ((nomePessoa == null) ? 0 : nomePessoa.hashCode());
		result = prime * result + qtdProduto;
		result = prime * result + ((valorTotal == null) ? 0 : valorTotal.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Venda other = (Venda) obj;
		if (dataDaVenda == null) {
			if (other.dataDaVenda != null)
				return false;
		} else if (!dataDaVenda.equals(other.dataDaVenda))
			return false;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (idCliente != other.idCliente)
			return false;
		if (idProduto != other.idProduto)
			return false;
		if (idVenda != other.idVenda)
			return false;
		if (nomePessoa == null) {
			if (other.nomePessoa != null)
				return false;
		} else if (!nomePessoa.equals(other.nomePessoa))
			return false;
		if (qtdProduto != other.qtdProduto)
			return false;
		if (valorTotal == null) {
			if (other.valorTotal != null)
				return false;
		} else if (!valorTotal.equals(other.valorTotal))
			return false;
		return true;
	}
	
	
	@Override
	public String toString() {
		return "Nome: " + nomePessoa + " idCliente: " + idCliente + " idVenda: " + idVenda + 
				System.lineSeparator() +
				"--------------------------------------------------" +
				System.lineSeparator() +
				"Quantidade de Produtos: "+ qtdProduto +  " Valor Total: " + valorTotal +
				System.lineSeparator() +
				"--------------------------------------------------" +
				System.lineSeparator() +
				"Data da Venda: " + dataDaVenda;
	}
	
	

}
