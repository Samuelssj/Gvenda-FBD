package business;

import java.util.List;

import exeptions.ExceptionUtil;
import model.Fornecedor;


public interface IBusinessFornecedor {
	
	 public void salvar(Fornecedor fornecedor) throws ExceptionUtil;

	    public void editar(Fornecedor fornecedor) throws ExceptionUtil;

	    public Fornecedor buscarPorId(int id) throws ExceptionUtil;

	    public List<Fornecedor> getAll() throws ExceptionUtil;

	    public List<Fornecedor> buscarPorNome(String nome) throws ExceptionUtil;
	    
	    public void ativarDesativar(int id) throws ExceptionUtil;

	    public void validar(Fornecedor fornecedor) throws ExceptionUtil;

}
