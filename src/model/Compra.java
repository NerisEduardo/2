package model;

public class Compra {
	private int idCompra;
	private int idFornecedor;
	private String nomePessoa;
	private String dataDaCompra;
	
	public int getIdCompra() {
		return idCompra;
	}
	public void setIdCompra(int idCompra) {
		this.idCompra = idCompra;
	}
	public int getIdFornecedor() {
		return idFornecedor;
	}
	public void setIdFornecedor(int idFornecedor) {
		this.idFornecedor = idFornecedor;
	}
	public String getNomePessoa() {
		return nomePessoa;
	}
	public void setNomePessoa(String nomePessoa) {
		this.nomePessoa = nomePessoa;
	}

	public String getDataDaCompra() {
		return dataDaCompra;
	}
	public void setDataDaCompra(String dataDaCompra) {
		this.dataDaCompra = dataDaCompra;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataDaCompra == null) ? 0 : dataDaCompra.hashCode());
		result = prime * result + idFornecedor;
		result = prime * result + idCompra;
		result = prime * result + ((nomePessoa == null) ? 0 : nomePessoa.hashCode());
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
		Compra other = (Compra) obj;
		if (dataDaCompra == null) {
			if (other.dataDaCompra != null)
				return false;
		} else if (!dataDaCompra.equals(other.dataDaCompra))
			return false;
		if (idFornecedor != other.idFornecedor)
			return false;
		if (idCompra != other.idCompra)
			return false;
		if (nomePessoa == null) {
			if (other.nomePessoa != null)
				return false;
		} else if (!nomePessoa.equals(other.nomePessoa))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Compra [idCompra=" + idCompra + ", idCliente=" + idFornecedor +
				", nomePessoa=" + nomePessoa + ", dataDaCompra=" + dataDaCompra + "]";
	}
	
	
}
