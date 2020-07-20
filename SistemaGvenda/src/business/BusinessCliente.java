package business;

import java.util.ArrayList;
import java.util.List;

import sql.Util;
import dao.DaoCliente;

import dao.IDaoCliente;
import exeptions.ExceptionUtil;
import model.Cliente;
import model.ClienteTabAdapter;
import model.ValidacaoException;



public class BusinessCliente implements IBusinessCliente {

	private IDaoCliente daoCliente;
	
	public BusinessCliente() {
	
	this.daoCliente = new DaoCliente() {

		@Override
		public Cliente buscarPorId(int id) throws ExceptionUtil {
			// TODO Auto-generated method stub
			return daoCliente.buscarPorId(id);
		}
	};
		
		 
	}
	
	@Override
	public void salvar(Cliente cliente) throws ExceptionUtil{
		
		
//		 if (!Util.validarEmail(cliente.getLogin())) {
//             throw new BusinessException("EMAIL INVÃ�LIDO");
//       }
//       if (!Util.validarNome(cliente.getNome())) {
//            throw new BusinessException("NOME DEVE CONTER NOME E SOBRENOME");
//       } 
    
		this.daoCliente.salvar(cliente);
	
	
        
   }
	

	@Override
	public void editar(Cliente cliente) throws ExceptionUtil {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Cliente buscarPorId(int id) throws ExceptionUtil {
		// TODO Auto-generated method stub
		return daoCliente.buscarPorId(id);
	}

	@Override
	public ArrayList<ClienteTabAdapter> buscarPorCPF(String cpf) throws ExceptionUtil {
		// TODO Auto-generated method stub
		
		return daoCliente.buscarPorCPF(cpf);
		
//		try {
//		} catch (ExceptionUtil e) {
//			e.printStackTrace();
//			throw new ExceptionUtil(e.getMessage());
//		}
	}

	@Override
	public List<ClienteTabAdapter> getAllAdapter() throws ExceptionUtil {
		
		return daoCliente.getAllAdapter();
		
	}

	@Override
	public List<Cliente> getAll() throws ExceptionUtil {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void ativarDesativar(int id) throws ExceptionUtil {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void validar(Cliente cliente) throws ValidacaoException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Cliente buscarPorLoginSenha(String login, String senha) throws ExceptionUtil {
		// TODO Auto-generated method stub
		return null;
	}

}
