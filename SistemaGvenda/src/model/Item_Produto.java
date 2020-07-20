package model;

import java.util.Date;

public class Item_Produto {
	
	
	private Integer id;
	private long cod_barras;
	private double unid_medida;
	private Date data_validade;
	private Date data_fabricacao;
	private Date data_compra;
	private double preco_unidade;
	private double porc_atacado;
	private double porc_varejo;
	private Fornecedor fornecedor_id;
	private Produto produto_id;
	private int quantidade;
	private int vendidos;
	private boolean perecivel;
	private boolean status;
	
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public long getCod_barras() {
		return cod_barras;
	}
	public void setCod_barras(long cod_barras) {
		this.cod_barras = cod_barras;
	}
	public double getUnid_medida() {
		return unid_medida;
	}
	public void setUnid_medida(double unid_medida) {
		this.unid_medida = unid_medida;
	}
	public Date getData_validade() {
		return data_validade;
	}
	public void setData_validade(Date data_validade) {
		this.data_validade = data_validade;
	}
	public Date getData_fabricacao() {
		return data_fabricacao;
	}
	public void setData_fabricacao(Date data_fabricacao) {
		this.data_fabricacao = data_fabricacao;
	}
	public Date getData_compra() {
		return data_compra;
	}
	public void setData_compra(Date data_compra) {
		this.data_compra = data_compra;
	}
	public double getPreco_unidade() {
		return preco_unidade;
	}
	public void setPreco_unidade(double preco_unidade) {
		this.preco_unidade = preco_unidade;
	}
	public double getPorc_atacado() {
		return porc_atacado;
	}
	public void setPorc_atacado(double porc_atacado) {
		this.porc_atacado = porc_atacado;
	}
	public double getPorc_varejo() {
		return porc_varejo;
	}
	public void setPorc_varejo(double porc_varejo) {
		this.porc_varejo = porc_varejo;
	}
	public Fornecedor getFornecedor_id() {
		return fornecedor_id;
	}
	public void setFornecedor_id(Fornecedor fornecedor_id) {
		this.fornecedor_id = fornecedor_id;
	}
	public Produto getProduto_id() {
		return produto_id;
	}
	public void setProduto_id(Produto produto_id) {
		this.produto_id = produto_id;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public int getVendidos() {
		return vendidos;
	}
	public void setVendidos(int vendidos) {
		this.vendidos = vendidos;
	}
	public boolean isPerecivel() {
		return perecivel;
	}
	public void setPerecivel(boolean perecivel) {
		this.perecivel = perecivel;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	
	

}
