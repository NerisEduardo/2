package model;

public class Pessoa {
	private int idPessoa;
	private String nome;
	private int status; //0 - inativo, 1 - ativo
	private String cpfCnpj;
	private String dtNsc;
	private String estadoCivil;
	private String identidade;
	private String nacionalidade;
	private String cep;
	private String rua;
	private int numero;
	private String bairro;
	private String estado;
	private String municipio;
	private String eMail;
	
	public int getIdPessoa() {
		return idPessoa;
	}
	public void setIdPessoa(int idPessoa) {
		this.idPessoa = idPessoa;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getCpfCnpj() {
		return cpfCnpj;
	}
	public void setCpfCnpj(String cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}
	public String getDtNsc() {
		return dtNsc;
	}
	public void setDtNsc(String dtNsc) {
		this.dtNsc = dtNsc;
	}
	public String getEstadoCivil() {
		return estadoCivil;
	}
	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}
	public String getIdentidade() {
		return identidade;
	}
	public void setIdentidade(String identidade) {
		this.identidade = identidade;
	}
	public String getNacionalidade() {
		return nacionalidade;
	}
	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getMunicipio() {
		return municipio;
	}
	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}
	public String geteMail() {
		return eMail;
	}
	public void seteMail(String eMail) {
		this.eMail = eMail;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idPessoa;
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
		Pessoa other = (Pessoa) obj;
		if (idPessoa != other.idPessoa)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Pessoa [idPessoa=" + idPessoa + ", nome=" + nome + ", status=" + status + ", cpfCnpj=" + cpfCnpj
				+ ", dtNsc=" + dtNsc + ", estadoCivil=" + estadoCivil + ", identidade=" + identidade
				+ ", nacionalidade=" + nacionalidade + ", cep=" + cep + ", rua=" + rua + ", numero=" + numero
				+ ", bairro=" + bairro + ", estado=" + estado + ", municipio=" + municipio + ", eMail=" + eMail + "]";
	}
	
	
	
}
