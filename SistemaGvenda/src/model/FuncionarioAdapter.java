package model;

public class FuncionarioAdapter {
	
	
	private Integer id;
	private String nome;
	private String cpf;
	private String cargo;
	private String rua;
	private String bairro;
	private Boolean situacao;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public Boolean getSituacao() {
		return situacao;
	}
	public void setSituacao(Boolean situacao) {
		this.situacao = situacao;
	}
	
	@Override
	public String toString() {
		return "FuncionarioAdapter [id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", cargo=" + cargo + ", rua=" + rua
				+ ", bairro=" + bairro + ", situacao=" + situacao + "]";
	}
	
	
	
	
	
	
	

}
