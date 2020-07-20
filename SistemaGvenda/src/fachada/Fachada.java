package fachada;

import java.util.ArrayList;
import java.util.List;

import business.IBusinessCliente;
import business.IBusinessFornecedor;
import business.IBusinessFuncionario;
import business.IBusinessItem_Produto;
import business.IBusinessProduto;
import dao.DaoCliente;
import dao.IDaoCliente;
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
import business.BusinessCliente;
import business.BusinessFornecedor;
import business.BusinessFuncionario;
import business.BusinessItem_Produto;
import business.BusinessProduto;

public class Fachada implements IFachada {
//	
	private static Fachada instance;
	private IBusinessCliente businessCliente;
	private IBusinessFuncionario businessFuncionario;
	private IBusinessProduto businessProduto;
	private IBusinessFornecedor businessFornecedor;
	private IBusinessItem_Produto businessItem_Produto;
	

	public static Fachada getInstance() {
		if (instance == null) {
			instance = new Fachada();
		}
		return instance;
	}

	public Fachada() {

		businessCliente = new BusinessCliente();
		businessFuncionario = new BusinessFuncionario();
		businessProduto = new BusinessProduto();
		businessFornecedor = new BusinessFornecedor();
		businessProduto = new BusinessProduto();
		businessItem_Produto = new BusinessItem_Produto();
		
		
	}

	
									//CLIENTEE
	
	
	@Override
	public void salvarCliente(Cliente cliente) throws ExceptionUtil {
		// TODO Auto-generated method stub
		businessCliente.salvar(cliente);
		

	}

	public List<ClienteTabAdapter> getAllAdapterCliente() throws ExceptionUtil {
		// TODO Auto-generated method stub
		return this.businessCliente.getAllAdapter();

	}

//	@Override
//	public void editarCliente(Cliente cliente) throws ExceptionUtil {
//		// TODO Auto-generated method stub
//		this.businessCliente.editar(cliente);
//		
//	}
//
	@Override
	public Cliente buscarPorIdCliente(int id) throws ExceptionUtil {
		// TODO Auto-generated method stub
		return this.businessCliente.buscarPorId(id);

	}

	@Override
	public ArrayList<ClienteTabAdapter> buscarPorCPFCliente(String cpf) throws ExceptionUtil {
		// TODO Auto-generated method stub
		return this.businessCliente.buscarPorCPF(cpf);
	} 


//
	@Override
	public List<Cliente> getAllCliente() throws ExceptionUtil {
		// TODO Auto-generated method stub
		return this.businessCliente.getAll();
	}

//
	@Override
	public void ativarDesativarCliente(int id) throws ExceptionUtil {
		this.businessCliente.ativarDesativar(id);

	}

	
									//FUNCIONARIOOOO
	
	
	@Override
	public void salvarFuncionario(Funcionario funcionario, Endereco end) throws ExceptionUtil {

		this.businessFuncionario.salvar(funcionario, end);

	}

	@Override
	public void editarFuncionario(Funcionario funcionario) throws ExceptionUtil {
		// TODO Auto-generated method stub

	}

	@Override
	public Funcionario buscarPorIdFuncionario(int id) throws ExceptionUtil {
		// TODO Auto-generated method stub
		return this.businessFuncionario.buscarPorId(id);
	}

	@Override
	public List<FuncionarioAdapter> buscarPorBuscaFuncionario(String busca) throws ExceptionUtil {
		// TODO Auto-generated method stub
		return this.businessFuncionario.burcarPorBuscaFuncionario(busca);
	}

	@Override
	public List<Funcionario> getAllFuncionario() throws ExceptionUtil {
		// TODO Auto-generated method stub
		return this.businessFuncionario.getAll();
	}

	@Override
	public List<FuncionarioAdapter> getAllAdapterFuncionario() throws ExceptionUtil {
		// TODO Auto-generated method stub
		
		return this.businessFuncionario.getAllAdapter();
	}

	@Override
	public Funcionario buscarPorLoginFuncionario(String login, String senha) throws ExceptionUtil {
		// TODO Auto-generated method stub
		return this.businessFuncionario.buscarPorLogin(login, senha);
	}

	@Override
	public void ativarDesativarFuncionario(int id) throws ExceptionUtil {
		// TODO Auto-generated method stub

	}

	
	
										//PRODUTO
	
	
	@Override
	public int salvarProduto(Produto produto) throws ExceptionUtil {
		// TODO Auto-generated method stub
		return this.businessProduto.salvar(produto);
	}

	@Override
	public void editarProduto(Produto produto) throws ExceptionUtil {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Produto buscarPorIdProduto(int id) throws ExceptionUtil {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Produto> getAllProduto() throws ExceptionUtil {
		// TODO Auto-generated method stub
		return this.businessProduto.getAll();
	}

	@Override
	public void ativarDesativarProduto(int id) throws ExceptionUtil {
		// TODO Auto-generated method stub
		
	}

	
									
									//FORNECEDOR

	
	@Override
	public void salvarFornecedor(Fornecedor fornecedor) throws ExceptionUtil {
		 businessFornecedor.salvar(fornecedor);
	}

	@Override
	public void editarFornecedor(Fornecedor fornecedor) throws ExceptionUtil {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Fornecedor buscarPorIdFornecedor(int id) throws ExceptionUtil {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Fornecedor> buscarPorNomeFornecedor(String nome) throws ExceptionUtil {
		// TODO Auto-generated method stub
		return this.businessFornecedor.buscarPorNome(nome);
	}

	@Override
	public List<Fornecedor> getAllFornecedor() throws ExceptionUtil {
		return this.businessFornecedor.getAll();
	}

	@Override
	public void ativarDesativarFornecedor(int id) throws ExceptionUtil {
		// TODO Auto-generated method stub
		
	}
	
	
	//ItemProduto

	
	@Override
	public void salvarItemProduto(Item_Produto item_Produto,int produto_id, int id_fornecedor) throws ExceptionUtil {
		// TODO Auto-generated method stub
		this.businessItem_Produto.salvar(item_Produto,produto_id, id_fornecedor);
	}

	@Override
	public void editar_Item_Produto(Item_Produto item_produto) throws ExceptionUtil {
		this.businessItem_Produto.editar(item_produto);
	}


	@Override
	public Item_Produto buscarPorIdItemProduto(int id) throws ExceptionUtil {
		// TODO Auto-generated method stub
		return this.businessItem_Produto.buscarPorId(id);
	}

	
	@Override
	public List<Item_Produto> getAllItemProduto() throws ExceptionUtil {
		// TODO Auto-generated method stub
		return this.businessItem_Produto.getAll();
	}

	@Override
	public List<ProdutoTabAdapter> getAllAdapterItemProduto() throws ExceptionUtil {
		// TODO Auto-generated method stub
		return this.businessItem_Produto.getAllAdapter();
	}

	@Override
	public List<EstoqueTabAdapter> getAllEstoqueAdapterPorBusca(String busca) throws ExceptionUtil {
		// TODO Auto-generated method stub
		return this.businessItem_Produto.getAllEstoqueAdapterPorBusca(busca);
	}
	
	@Override
	public List<ProdutoTabAdapter> getAllAdapterPorBuscaItemProduto(String busca) throws ExceptionUtil {
		// TODO Auto-generated method stub
		return this.businessItem_Produto.getAllAdapterPorBusca(busca);
	}

//	@Override
//	public VendaTabAdapter buscarPorIdVendaAdapterProduto(int id) throws ExceptionUtil {
//		return this.businessItem_Produto.buscarPorIdVendaAdapter(id);
//	}

	@Override
	public void atualizarVendidos_Item_Produto(Item_Produto item_produto) throws ExceptionUtil {
			this.businessItem_Produto.atualizarVenidos(item_produto);
	}

	@Override
	public List<EstoqueTabAdapter> getAllEstoqueAdapterProduto() throws ExceptionUtil {
		return this.businessItem_Produto.getAllEstoqueAdapter();
	}


	@Override
	public void ativarDesativarItemProduto(int id) throws ExceptionUtil {
		// TODO Auto-generated method stub
		this.businessItem_Produto.ativarDesativar(id);
	}

	

}
