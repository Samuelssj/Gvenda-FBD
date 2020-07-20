package business;

import java.util.List;

import dao.DaoItem_Produto;
import dao.IDaoItem_Produto;
import exeptions.ExceptionUtil;
import model.EstoqueTabAdapter;
import model.Item_Produto;
import model.ProdutoTabAdapter;

public class BusinessItem_Produto  implements IBusinessItem_Produto{
	
	private IDaoItem_Produto daoItemProduto;

	public BusinessItem_Produto() {
		daoItemProduto = new DaoItem_Produto();
	}
	
	
	@Override
	public void salvar(Item_Produto item_Produto, int produto_id, int id_fornecedor) throws ExceptionUtil {

		try {
			//validar(item_Produto);
			if (item_Produto.getId() == null)
				daoItemProduto.salvar(item_Produto, produto_id, id_fornecedor);

		} catch (ExceptionUtil e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ExceptionUtil(e.getMessage());
		}
		
	}

	@Override
	public Item_Produto buscarPorId(int id) throws ExceptionUtil {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Item_Produto> getAll() throws ExceptionUtil {
		// TODO Auto-generated method stub
		return daoItemProduto.getAll();
	}

	@Override
	public List<ProdutoTabAdapter> getAllAdapter() throws ExceptionUtil {
		// TODO Auto-generated method stub
		return daoItemProduto.getAllAdapter();
	}

	@Override
	public List<EstoqueTabAdapter> getAllEstoqueAdapter() throws ExceptionUtil {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EstoqueTabAdapter> getAllEstoqueAdapterPorBusca(String busca) throws ExceptionUtil {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProdutoTabAdapter> getAllAdapterPorBusca(String busca) throws ExceptionUtil {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void editar(Item_Produto item_Produto) throws ExceptionUtil {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void atualizarVenidos(Item_Produto item_Produto) throws ExceptionUtil {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ativarDesativar(int id) throws ExceptionUtil {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void validar(Item_Produto item_Produto) throws ExceptionUtil {
		// TODO Auto-generated method stub
		
	}

}
