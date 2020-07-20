package business;

import java.util.List;

import dao.DaoFuncionario;
import dao.IDaoFuncionario;
import exeptions.ExceptionUtil;
import model.Endereco;
import model.Funcionario;
import model.FuncionarioAdapter;

public class BusinessFuncionario implements IBusinessFuncionario {

	private  IDaoFuncionario daoFuncionario;
	
	public BusinessFuncionario() {
	
		
		daoFuncionario = new DaoFuncionario();
		
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void salvar(Funcionario funcionario, Endereco end) throws ExceptionUtil {
		
		try {
			validar(funcionario);
			if (funcionario.getId() == null)
				daoFuncionario.salvar(funcionario, end);


		} catch (ExceptionUtil e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} 
	}

	@Override
	public void editar(Funcionario funcionario) throws ExceptionUtil {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Funcionario buscarPorId(int id) throws ExceptionUtil {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FuncionarioAdapter> burcarPorBuscaFuncionario(String busca) throws ExceptionUtil {
		// TODO Auto-generated method stub
		return this.daoFuncionario.buscarPorBusca(busca);
	}

	@Override
	public List<Funcionario> getAll() throws ExceptionUtil {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FuncionarioAdapter> getAllAdapter() throws ExceptionUtil {
		// TODO Auto-generated method stub
		return daoFuncionario.getAllAdapter();
	}

	@Override
	public Funcionario buscarPorLogin(String login, String senha) throws ExceptionUtil {
		// TODO Auto-generated method stub
		return daoFuncionario.buscarLogin(login, senha);
	}

	@Override
	public void ativarDesativar(int id) throws ExceptionUtil {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void validar(Funcionario funcionario) throws ExceptionUtil {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void validar(String Login, String Senha) throws ExceptionUtil {
		// TODO Auto-generated method stub
		
	}

}
