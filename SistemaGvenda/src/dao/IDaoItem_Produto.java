package dao;

import java.util.List;

import exeptions.ExceptionUtil;
import model.EstoqueTabAdapter;
import model.Item_Produto;
import model.ProdutoTabAdapter;

public interface IDaoItem_Produto {
	
	
	public void salvar(Item_Produto item_Produto,int produto_id, int id_fornecedor) throws ExceptionUtil;

	public Item_Produto buscarPorId(int id) throws ExceptionUtil;

	public List<Item_Produto> getAll() throws ExceptionUtil;

	public List<ProdutoTabAdapter> getAllAdapter() throws ExceptionUtil;

	public List<EstoqueTabAdapter> getAllEstoqueAdapter() throws ExceptionUtil;
	
	public List<EstoqueTabAdapter> getAllEstoqueAdapterPorBusca(String busca) throws ExceptionUtil;
	
	public List<ProdutoTabAdapter> getAllAdapterPorBusca(String busca) throws ExceptionUtil;

	//public VendaTabAdapter buscarPorIdVendaAdapter(int id) throws ExceptionUtil;

	public void editar(Item_Produto item_Produto) throws ExceptionUtil;

	public void atualizarVenidos(Item_Produto item_Produto) throws ExceptionUtil;

	public void ativarDesativar(int id) throws ExceptionUtil;

}
