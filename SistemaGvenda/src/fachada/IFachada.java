package fachada;

import java.util.ArrayList;
import java.util.List;
import org.postgresql.jdbc.EscapedFunctions;

import exeptions.ExceptionUtil;
import model.Cliente;
import model.ClienteTabAdapter;
import model.Endereco;
import model.EstoqueTabAdapter;
import model.Fornecedor;
import model.Funcionario;
import model.FuncionarioAdapter;
import model.Item_Produto;
import model.Produto;
import model.ProdutoTabAdapter;

public interface IFachada {

	public void salvarCliente(Cliente cliente) throws ExceptionUtil;

//	public void editarCliente(Cliente cliente) throws ExceptionUtil;
	public Cliente buscarPorIdCliente(int id) throws ExceptionUtil;

	public ArrayList<ClienteTabAdapter> buscarPorCPFCliente(String cpf) throws ExceptionUtil;
	
	public List<ClienteTabAdapter> getAllAdapterCliente() throws ExceptionUtil;

	public List<Cliente> getAllCliente() throws ExceptionUtil;

	public void ativarDesativarCliente(int id) throws ExceptionUtil;

	// Funcionario
	public void salvarFuncionario(Funcionario funcionario, Endereco end) throws ExceptionUtil;

	public void editarFuncionario(Funcionario funcionario) throws ExceptionUtil;

	public Funcionario buscarPorIdFuncionario(int id) throws ExceptionUtil;

	public List<FuncionarioAdapter> buscarPorBuscaFuncionario(String busca) throws ExceptionUtil;

	public List<Funcionario> getAllFuncionario() throws ExceptionUtil;

	public List<FuncionarioAdapter> getAllAdapterFuncionario() throws ExceptionUtil;

	public Funcionario buscarPorLoginFuncionario(String login, String senha) throws ExceptionUtil;

	public void ativarDesativarFuncionario(int id) throws ExceptionUtil;

	// Produto
	public int salvarProduto(Produto produto) throws ExceptionUtil;

	public void editarProduto(Produto produto) throws ExceptionUtil;

	public Produto buscarPorIdProduto(int id) throws ExceptionUtil;

	public List<Produto> getAllProduto() throws ExceptionUtil;

	public void ativarDesativarProduto(int id) throws ExceptionUtil;

	// Fornecedor

	public void salvarFornecedor(Fornecedor fornecedor) throws ExceptionUtil;

	public void editarFornecedor(Fornecedor fornecedor) throws ExceptionUtil;

	public Fornecedor buscarPorIdFornecedor(int id) throws ExceptionUtil;

	public List<Fornecedor> buscarPorNomeFornecedor(String nome) throws ExceptionUtil;

	public List<Fornecedor> getAllFornecedor() throws ExceptionUtil;

	public void ativarDesativarFornecedor(int id) throws ExceptionUtil;

	// ItemProduto

	public void salvarItemProduto(Item_Produto item_Produto, int produto_id, int id_fornecedor)
			throws ExceptionUtil;

	public void editar_Item_Produto(Item_Produto item_produto) throws ExceptionUtil;

	public Item_Produto buscarPorIdItemProduto(int id) throws ExceptionUtil;

	public List<Item_Produto> getAllItemProduto() throws ExceptionUtil;

	public List<ProdutoTabAdapter> getAllAdapterItemProduto() throws ExceptionUtil;

	public List<EstoqueTabAdapter> getAllEstoqueAdapterProduto() throws ExceptionUtil;

	public List<EstoqueTabAdapter> getAllEstoqueAdapterPorBusca(String busca) throws ExceptionUtil;

	public List<ProdutoTabAdapter> getAllAdapterPorBuscaItemProduto(String busca) throws ExceptionUtil;

//	public VendaTabAdapter buscarPorIdVendaAdapterProduto(int id) throws ExceptionUtil;

	public void atualizarVendidos_Item_Produto(Item_Produto item_produto) throws ExceptionUtil;

	public void ativarDesativarItemProduto(int id) throws ExceptionUtil;

}
