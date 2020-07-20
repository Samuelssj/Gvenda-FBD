package business;

import java.util.List;
import dao.DaoProduto;
import dao.IDaoProduto;
import exeptions.ExceptionUtil;
import model.Produto;

public class BusinessProduto implements IBusinessProduto {
	
	private IDaoProduto daoProduto;

	public BusinessProduto() {
		daoProduto = new DaoProduto();
	}
	
	
	@Override
	public int salvar(Produto produto) throws ExceptionUtil {
		try {
			validar(produto);
			if (produto.getId() == null)
				return daoProduto.salvar(produto);

		} catch (ExceptionUtil e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public void editar(Produto produto) throws ExceptionUtil {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Produto buscarPorId(int id) throws ExceptionUtil {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Produto> getAll() throws ExceptionUtil {
		try {
			return daoProduto.getAll();
		} catch (ExceptionUtil e) {
			
			e.printStackTrace();
			throw new ExceptionUtil(e.getMessage());
		}
	}

	@Override
	public void ativarDesativar(int id) throws ExceptionUtil {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void validar(Produto produto) throws ExceptionUtil {
		// TODO Auto-generated method stub
		
	}

}
