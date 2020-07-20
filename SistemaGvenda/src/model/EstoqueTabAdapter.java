package model;

public class EstoqueTabAdapter {
	private int id;
	private long cod_barras;
	private String descricao;
	private double preco_unidade;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public long getCod_barras() {
		return cod_barras;
	}
	public void setCod_barras(long cod_barras) {
		this.cod_barras = cod_barras;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public double getPreco_unidade() {
		return preco_unidade;
	}
	public void setPreco_unidade(double preco_unidade) {
		this.preco_unidade = preco_unidade;
	}
	
	
	@Override
	public String toString() {
		return "EstoqueTabAdapter [id=" + id + ", cod_barras=" + cod_barras + ", descricao=" + descricao
				+ ", preco_unidade=" + preco_unidade + "]";
	}

	
	
	
	
	
	
}
