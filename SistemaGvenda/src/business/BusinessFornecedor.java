package business;

import java.util.List;

import dao.DaoFornecedor;
import dao.IDaoFornecedor;
import exeptions.ExceptionUtil;
import model.Fornecedor;

public class BusinessFornecedor implements IBusinessFornecedor{
	
	
	  private IDaoFornecedor daoFornecedor;
	    
	    public BusinessFornecedor() {
	        this.daoFornecedor = new DaoFornecedor();
	    }


	@Override
	public void salvar(Fornecedor fornecedor) throws ExceptionUtil {

   
           // validar(fornecedor);
           
           this.daoFornecedor.salvar(fornecedor);

       
	}

	@Override
	public Fornecedor buscarPorId(int id) throws ExceptionUtil {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Fornecedor> getAll() throws ExceptionUtil {
	     
	            return daoFornecedor.getAll();
	       
	}

	@Override
	public List<Fornecedor> buscarPorNome(String nome) throws ExceptionUtil {
		// TODO Auto-generated method stub
		return daoFornecedor.buscarPorNome(nome);
	}

	@Override
	public void editar(Fornecedor fornecedor) throws ExceptionUtil {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ativarDesativar(int id) throws ExceptionUtil {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void validar(Fornecedor fornecedor) throws ExceptionUtil {
		// TODO Auto-generated method stub
		
	}

}
