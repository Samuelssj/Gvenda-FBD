package business;

import java.util.ArrayList;
import java.util.List;

import exeptions.ExceptionUtil;
import model.Cliente;
import model.ClienteTabAdapter;
import model.ValidacaoException;




public interface IBusinessCliente {
	
	 public void salvar(Cliente cliente) throws ExceptionUtil;

	    public void editar(Cliente cliente) throws ExceptionUtil;

	    public Cliente buscarPorId(int id) throws ExceptionUtil;

	    public ArrayList<ClienteTabAdapter> buscarPorCPF(String cpf) throws ExceptionUtil;

	    public List<ClienteTabAdapter> getAllAdapter() throws ExceptionUtil;

	    public List<Cliente> getAll() throws ExceptionUtil;

	    public void ativarDesativar(int id) throws ExceptionUtil;

	    public void validar(Cliente cliente) throws ValidacaoException;
	    
	    public Cliente buscarPorLoginSenha(String login, String senha) throws ExceptionUtil;
}
