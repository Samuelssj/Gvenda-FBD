package model;

public class Contato {
	
	private Integer id;
	private TipoContato tipo;
	private Cliente cliente;
	private String descricao;
	
	
	public TipoContato getTipo() {
		return tipo;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setTipo(TipoContato tipo) {
		this.tipo = tipo;
	}
	
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
	
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public String toString() {
		return "Contato [id=" + id + ", tipo=" + tipo + ", cliente="  + ", descricao=" + descricao + "]";
	}
	

	
	
	
	
	

}
