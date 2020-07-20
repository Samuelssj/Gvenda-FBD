package model;

import java.util.Date;

public class ProdutoTabAdapter {
	
	private Integer id;
	private Integer produto_id;
	private Integer fornecedor_id;
    private String descricao;
    private String marca;
    private long cod_barras;
    private double preco_varejo;
    private int estoque;
    private Date data_cadastro;
    private boolean status;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getProduto_id() {
		return produto_id;
	}
	public void setProduto_id(Integer produto_id) {
		this.produto_id = produto_id;
	}
	public Integer getFornecedor_id() {
		return fornecedor_id;
	}
	public void setFornecedor_id(Integer fornecedor_id) {
		this.fornecedor_id = fornecedor_id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public long getCod_barras() {
		return cod_barras;
	}
	public void setCod_barras(long cod_barras) {
		this.cod_barras = cod_barras;
	}
	public double getPreco_varejo() {
		return preco_varejo;
	}
	public void setPreco_varejo(double preco_varejo) {
		this.preco_varejo = preco_varejo;
	}
	public int getEstoque() {
		return estoque;
	}
	public void setEstoque(int estoque) {
		this.estoque = estoque;
	}
	public Date getData_cadastro() {
		return data_cadastro;
	}
	public void setData_cadastro(Date data_cadastro) {
		this.data_cadastro = data_cadastro;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	
	@Override
	public String toString() {
		return "ProdutoTabAdapter [id=" + id + ", produto_id=" + produto_id + ", fornecedor_id=" + fornecedor_id
				+ ", descricao=" + descricao + ", marca=" + marca + ", cod_barras=" + cod_barras + ", preco_varejo="
				+ preco_varejo + ", estoque=" + estoque + ", data_cadastro=" + data_cadastro + ", status=" + status
				+ "]";
	}

    
    
    
    
}
