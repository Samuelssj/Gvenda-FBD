package model;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Cliente {

	private Integer id;
	private String nome;
	private String cpf;
	private Endereco endereco;
	private String sexo;
	private String data_nascimento;
	private List<Contato> contatos;
	
	public Cliente(){
		this.contatos = new ArrayList<>();
	}

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

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	
	public String getData_nascimento() {
		return data_nascimento;
	}

	public void setData_nascimento(String data_nascimento) {
		this.data_nascimento = data_nascimento;
	}

	public List<Contato> getContatos() {
		return contatos;
	}

	public void setContatos(List<Contato> contatos) {
		this.contatos = contatos;
	}

	
	
	
	

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", endereco=" +  ", nome=" + nome + ", cpf=" + cpf + ", sexo=" + sexo
				+ ", data_nascimento=" + data_nascimento + ", login="  + ", senha=" + ", contatos="
				+ contatos + "]";
	}



	
	
	
}
